package co.com.ceiba.adn.parqueaderoback.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parqueaderoback.dominio.Carro;
import co.com.ceiba.adn.parqueaderoback.dominio.Moto;
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;
import co.com.ceiba.adn.parqueaderoback.dto.builder.CarroBuilder;
import co.com.ceiba.adn.parqueaderoback.dto.builder.MotoBuilder;
import co.com.ceiba.adn.parqueaderoback.dto.builder.RegistroEntradaBuilder;
import co.com.ceiba.adn.parqueaderoback.entity.RegistroEntradaEntity;
import co.com.ceiba.adn.parqueaderoback.entity.VehiculoEntity;
import co.com.ceiba.adn.parqueaderoback.repository.RegistroEntradaRepository;
import co.com.ceiba.adn.parqueaderoback.utilities.ConvertidorDeFecha;

@Service
public class RegistroEntradaServiceImp implements RegistroEntradaService{
	private RegistroEntradaRepository registroEntradaRepository;
	
	
	@Autowired
	public RegistroEntradaServiceImp(RegistroEntradaRepository registroEntradaRepository) {
		this.registroEntradaRepository = registroEntradaRepository;
	}

	@Override
	public Integer numeroDeVehiculosRegistradosPorTipo(String tipoVehiculo) {		
		return registroEntradaRepository.numeroDeVehiculosRegistradosPorTipo(tipoVehiculo);
	}

	@Override
	public List<RegistroEntrada> vehiculosRegistrados() {
		List<RegistroEntradaEntity> entradaEntity = registroEntradaRepository.vehiculosRegistrados();
		return entradaEntity.stream()
				.map(RegistroEntradaBuilder::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public List<RegistroEntrada> vehiculosRegistradosPorTipo(String tipoVehiculo) {
		List<RegistroEntradaEntity> entradaEntity = registroEntradaRepository.vehiculosRegistradosPorTipo(tipoVehiculo);		
		return entradaEntity.stream()
				.map(RegistroEntradaBuilder::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public List<RegistroEntrada> vehiculosRegistradosMatricula(String matricula) {
		List<RegistroEntradaEntity> entradaEntity = registroEntradaRepository.vehiculosRegistradosMatricula(matricula);		
		return entradaEntity.stream()
				.map(RegistroEntradaBuilder::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public RegistroEntrada save(RegistroEntrada registroEntrada) {
		VehiculoEntity vehiculoEntity  = obtenerVehiculoEntity(registroEntrada.getVehiculo());
		RegistroEntradaEntity registroEntradaEntity = new RegistroEntradaEntity();
		registroEntradaEntity.setEstadoParqueo(Boolean.TRUE);
		registroEntradaEntity.setFechaEntrada(ConvertidorDeFecha.convertirATimestamp(registroEntrada.getFechaEntrada()));
		registroEntradaEntity.setTipoVehiculo(registroEntrada.getVehiculo().getTipoVehiculo().toString());
		registroEntradaEntity.setVehiculoEntity(vehiculoEntity);		
		return RegistroEntradaBuilder.convertirADominio(registroEntradaRepository.save(registroEntradaEntity));
	}

	
	@Override
	public RegistroEntrada findById(Long id) {	
		RegistroEntradaEntity regEntity= null;
		if(registroEntradaRepository.findById(id).isPresent()) {
			regEntity = registroEntradaRepository.findById(id).get();			
		}
		return RegistroEntradaBuilder.convertirADominio(regEntity);			
	}
	
	private VehiculoEntity obtenerVehiculoEntity(Vehiculo vehiculo) {
		if(vehiculo instanceof Carro) {
			return CarroBuilder.convertirAEntity((Carro) vehiculo);
		}else {
			return MotoBuilder.convertirAEntity((Moto) vehiculo);
		}
		
	}

}
