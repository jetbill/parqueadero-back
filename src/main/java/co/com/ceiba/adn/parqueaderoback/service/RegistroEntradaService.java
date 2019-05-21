package co.com.ceiba.adn.parqueaderoback.service;

import java.util.List;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;



public interface RegistroEntradaService {
	
	Integer numeroDeVehiculosRegistradosPorTipo(String tipoVehiculo);
	
	List<RegistroEntrada> vehiculosRegistrados();
	
	List<RegistroEntrada> vehiculosRegistradosPorTipo(String tipoVehiculo);
	
	List<RegistroEntrada> vehiculosRegistradosMatricula(String matricula);
	
	RegistroEntrada save(RegistroEntrada registroEntrada);
	
	RegistroEntrada findById(Long id);
	
	

}
