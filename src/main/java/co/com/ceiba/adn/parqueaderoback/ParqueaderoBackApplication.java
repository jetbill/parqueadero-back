package co.com.ceiba.adn.parqueaderoback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.service.RegistroEntradaService;

@SpringBootApplication
public class ParqueaderoBackApplication implements CommandLineRunner{
	@Autowired
	private RegistroEntradaService registroEntradaService;

	public static void main(String[] args) {
		SpringApplication.run(ParqueaderoBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*getNumerodeCarros();
		getNumerodeMotos();
		System.out.println();
		System.out.println("Total vehiculos");
		getRegistrados();
		System.out.println("El vehiculo de matriclua jlo125 es ");
		getVehiculosporMatricula();*/
		
	}
	
	private void getNumerodeCarros() {
		Integer num = registroEntradaService.numeroDeVehiculosRegistradosPorTipo("CARRO");
		System.out.println("Numero de Carros registrados: "+num);
	}
	
	private void getNumerodeMotos() {
		Integer num = registroEntradaService.numeroDeVehiculosRegistradosPorTipo("MOTO");
		System.out.println("Numero de Motos registradas: "+num);
	}
	
	private void getRegistrados() {
		List<RegistroEntrada> registrados = registroEntradaService.obtenerParqueosActivos();
		registrados.forEach(System.out::println);
	}
	
	private void getVehiculosporMatricula() {
		List<RegistroEntrada> registrados = registroEntradaService.vehiculosRegistradosPorMatricula("jlo125");
		registrados.forEach(System.out::println);
	}

}
