package co.com.ceiba.adn.parqueaderoback.service;

import java.time.LocalDateTime;
import java.util.List;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;



public interface RegistroEntradaService {
	
	Integer numeroDeVehiculosRegistradosPorTipo(String tipoVehiculo);
	
	List<RegistroEntrada> obtenerParqueosActivos();
	
	List<RegistroEntrada> vehiculosRegistradosPorTipo(String tipoVehiculo);
	
	List<RegistroEntrada> vehiculosRegistradosPorMatricula(String matricula);
	
	RegistroEntrada guardarRegistro(RegistroEntrada registroEntrada);
	
	
	
	RegistroEntrada buscarPorId(Long id);
	
	

}
