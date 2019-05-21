package co.com.ceiba.adn.parqueaderoback.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.adn.parqueaderoback.dominio.Carro;
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.dominio.TipoVehiculo;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;
import co.com.ceiba.adn.parqueaderoback.validations.CondicionEntradaCarro;
import co.com.ceiba.adn.parqueaderoback.validations.CondicionEntradaMoto;
import co.com.ceiba.adn.parqueaderoback.validations.CondicionParqueo;

@Service
public class EntradaService {
	
	private RegistroEntradaService registroEntradaService;

	public EntradaService(RegistroEntradaService registroEntradaService) {
		this.registroEntradaService = registroEntradaService;
	}
	
	public List<RegistroEntrada> obtenerParqueosActivosPorTipo(TipoVehiculo tipoVehiculo){
		return registroEntradaService.vehiculosRegistradosPorTipo(tipoVehiculo.toString());
		
	}
	
	public List<RegistroEntrada> obtenerParqueosActivos(){
		return registroEntradaService.vehiculosRegistrados();
	}
	
	public RegistroEntrada   obtenerEntradaPorId(Long id) {
		return registroEntradaService.findById(id);
		
	}
	
	public CondicionParqueo getControlParqueo(Vehiculo vehiculo, LocalDateTime fechaEntrda, RegistroEntradaService registroEntradaService) {
		if(vehiculo instanceof Carro) {
			return new CondicionEntradaCarro(vehiculo,fechaEntrda,registroEntradaService);
		}else {
			return new CondicionEntradaMoto(vehiculo,fechaEntrda,registroEntradaService);
		}
	}
	
	@Transactional
	public RegistroEntrada registarIngreso(Vehiculo vehiculo, LocalDateTime fechaEntrda) {
		CondicionParqueo condicionParqueo = getControlParqueo(vehiculo,fechaEntrda,registroEntradaService);
		condicionParqueo.validarIngreso();
		RegistroEntrada entrada = new RegistroEntrada();
		entrada.setEstadoParqueo(Boolean.TRUE);
		entrada.setFechaEntrada(fechaEntrda);
		entrada.setVehiculo(vehiculo);
		return registroEntradaService.save(entrada);
		
		
	}

}
