package co.com.ceiba.adn.parqueaderoback.service;

import java.util.List;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroSalida;



public interface RegistroSalidaService {
	
	List<RegistroSalida> buscarEntradaPorId(Long id);
	
	RegistroSalida save(RegistroSalida registroSalida);
	
	
	

}
