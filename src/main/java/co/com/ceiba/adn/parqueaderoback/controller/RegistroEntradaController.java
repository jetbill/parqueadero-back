package co.com.ceiba.adn.parqueaderoback.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.adn.parqueaderoback.dominio.Carro;
import co.com.ceiba.adn.parqueaderoback.dominio.Moto;
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.service.EntradaService;


@RestController
@RequestMapping("/parqueo")
public class RegistroEntradaController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private EntradaService entradaService;

	@Autowired
	public RegistroEntradaController(EntradaService EntradaService) {
		this.entradaService = EntradaService;
	}
	
	@GetMapping("/listar")
	public List<RegistroEntrada> listarRegistrosDeEntrada() {		
		return entradaService.obtenerParqueosActivos();
		
	}
	
	@PostMapping("/carro")
	public ResponseEntity<?> registarCarro(@Valid @RequestBody Carro carro,BindingResult result) {
		RegistroEntrada registroEntrada = null;
		LocalDateTime fechaEntrada = LocalDateTime.now();
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			registroEntrada = entradaService.registarIngreso(carro, fechaEntrada);
		} catch (DataAccessException error) {
			response.put("mensaje", "No se pudo registrar el Carro");
			response.put("error", error.getMessage().concat(": ").concat(error.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Carro ha sido registrado con exito!");
		response.put("registroEntrada", registroEntrada);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); 
		
	}
	
	@PostMapping("/moto")
	public ResponseEntity<?>  registarMoto(@Valid  @RequestBody Moto moto,BindingResult result) {
		RegistroEntrada registroEntrada = null;
		LocalDateTime fechaEntrada = LocalDateTime.now();
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			registroEntrada = entradaService.registarIngreso(moto, fechaEntrada);
		} catch (DataAccessException error) {
			response.put("mensaje", "No se pudo registrar la moto");
			response.put("error", error.getMessage().concat(": ").concat(error.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La Moto ha sido registrada con exito!");
		response.put("registroEntrada", registroEntrada);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED); 
		
	}
	
	

}
