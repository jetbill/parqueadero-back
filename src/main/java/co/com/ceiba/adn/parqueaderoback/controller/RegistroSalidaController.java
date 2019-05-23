package co.com.ceiba.adn.parqueaderoback.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo; 
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroSalida;
import co.com.ceiba.adn.parqueaderoback.service.SalidaService;

@RestController
@RequestMapping("/retirar")
public class RegistroSalidaController {
	
	private SalidaService salidaService;
	
	@Autowired
	public RegistroSalidaController(SalidaService salidaService) {		
		this.salidaService=salidaService;
	}
	
	@PostMapping("/vehiculo")
	public RegistroSalida retirarvehiculo(@RequestBody Vehiculo vehiculo) {
		LocalDateTime fechaSalida = LocalDateTime.now();		
		return salidaService.generarSalida(vehiculo.getMatricula(), fechaSalida);
	}
	
	

}
