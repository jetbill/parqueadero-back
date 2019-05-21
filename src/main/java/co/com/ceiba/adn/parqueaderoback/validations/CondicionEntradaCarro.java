package co.com.ceiba.adn.parqueaderoback.validations;

import java.time.LocalDateTime;

import co.com.ceiba.adn.parqueaderoback.dominio.TipoVehiculo;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;
import co.com.ceiba.adn.parqueaderoback.service.RegistroEntradaService;

public class CondicionEntradaCarro extends CondicionParqueo{

	public CondicionEntradaCarro(Vehiculo vehiculo, LocalDateTime fechaEntrda, RegistroEntradaService registroEntrada) {
		super(vehiculo, fechaEntrda, registroEntrada);
		
	}

	@Override
	protected Boolean validarDisponibilidad() {
		Integer carrosRegistrados = registroEntrada.numeroDeVehiculosRegistradosPorTipo(TipoVehiculo.CARRO.toString());
		return carrosRegistrados < Constantes.MAXIMO_CARRO;
	}

}
