package co.com.ceiba.adn.parqueaderoback.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroSalida;
import co.com.ceiba.adn.parqueaderoback.exceptions.SalidaException;
import co.com.ceiba.adn.parqueaderoback.validations.CobroDeParqueo;
import co.com.ceiba.adn.parqueaderoback.validations.Constantes;

@Service
public class SalidaService {
	private RegistroSalidaService registroSalidaService;	
	private RegistroEntradaService registroEntradaService;
	private ValorTarifaService valorTarifaService;
	
	
	public SalidaService(RegistroSalidaService registroSalidaService, RegistroEntradaService registroEntradaService,
			ValorTarifaService valorTarifaService) {
		this.registroSalidaService = registroSalidaService;
		this.registroEntradaService = registroEntradaService;
		this.valorTarifaService = valorTarifaService;
	}
	
	private void validarEntrada(RegistroEntrada registroEntrada) {
		if(!registroSalidaService.buscarEntradaPorId(registroEntrada.getId()).isEmpty()) {
			throw new SalidaException(Constantes.MSG_SALIDA_REGISTRADA);
		}
		
	}
	
	private Long calcularCantidadDeHoras(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		Long horasDeParqueo = Timestamp.valueOf(fechaSalida).getTime() - Timestamp.valueOf(fechaEntrada).getTime();
		return horasDeParqueo / Constantes.HORA_MILISEGUNDOS;
	}
	
	private RegistroSalida calcularTotal(RegistroEntrada registroEntrada,LocalDateTime fechaSalida) {
		validarEntrada(registroEntrada);
		Long cantidadHoras = calcularCantidadDeHoras(registroEntrada.getFechaEntrada(), fechaSalida);
		CobroDeParqueo cobroDeParqueo = new CobroDeParqueo(registroEntrada.getVehiculo(), valorTarifaService);
		RegistroSalida registroSalida = new RegistroSalida();
		registroSalida.setEntrada(registroEntrada);
		registroSalida.setFechaSalida(fechaSalida);
		registroSalida.setValorServicio(cobroDeParqueo.totalAPargarParqueo(cantidadHoras.intValue()));
		return registroSalida;		
		
	}
	
	@Transactional
	public RegistroSalida generarSalida(String matricula,LocalDateTime fechaSalida) {
		List<RegistroEntrada>  registroEntradas = registroEntradaService.vehiculosRegistradosMatricula(matricula);
		if(!registroEntradas.isEmpty()) {
			RegistroEntrada registroEntrada = registroEntradas.get(0);
			RegistroSalida registroSalida = calcularTotal(registroEntrada,fechaSalida);
			return registroSalidaService.save(registroSalida);			
		}else {
			throw new SalidaException(Constantes.MSG_ENTRADA_NO_ENCONTRADA);
		}
		
	}
	
}
