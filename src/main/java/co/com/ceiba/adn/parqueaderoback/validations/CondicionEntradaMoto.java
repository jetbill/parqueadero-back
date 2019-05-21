package co.com.ceiba.adn.parqueaderoback.validations;

import java.time.LocalDateTime;

import co.com.ceiba.adn.parqueaderoback.dominio.TipoVehiculo;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;
import co.com.ceiba.adn.parqueaderoback.service.RegistroEntradaService;

public class CondicionEntradaMoto extends CondicionParqueo{

	public CondicionEntradaMoto(Vehiculo vehiculo, LocalDateTime fechaEntrda, RegistroEntradaService registroEntrada) {
		super(vehiculo, fechaEntrda, registroEntrada);
		
	}

	@Override
	protected Boolean validarDisponibilidad() {
		Integer motosRegistradas = registroEntrada.numeroDeVehiculosRegistradosPorTipo(TipoVehiculo.MOTO.toString());
		return motosRegistradas < Constantes.MAXIMO_MOTO;
	}

}
