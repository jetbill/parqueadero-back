package co.com.ceiba.adn.parqueaderoback.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroSalida;
import co.com.ceiba.adn.parqueaderoback.dto.builder.RegistroEntradaBuilder;
import co.com.ceiba.adn.parqueaderoback.dto.builder.RegistroSalidaBuilder;
import co.com.ceiba.adn.parqueaderoback.entity.RegistroSalidaEntity;
import co.com.ceiba.adn.parqueaderoback.repository.RegistroSalidaRepository;
import co.com.ceiba.adn.parqueaderoback.utilities.ConvertidorDeFecha;

@Service
public class RegistroSalidaServiceImp implements RegistroSalidaService {
	private RegistroSalidaRepository registroSalidaRepository;
	
	@Autowired
	public RegistroSalidaServiceImp(RegistroSalidaRepository registroSalidaRepository) {
		this.registroSalidaRepository = registroSalidaRepository;
		
	}
	

	@Override
	public List<RegistroSalida> buscarEntradaPorId(Long id) {
		List<RegistroSalidaEntity> salidas = registroSalidaRepository.buscarEntradaPorId(id);
		return salidas.stream()
				.map(RegistroSalidaBuilder::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public RegistroSalida save(RegistroSalida registroSalida) {
		RegistroSalidaEntity registroSalidaEntity = new RegistroSalidaEntity();
		registroSalidaEntity.setFechaSalida(ConvertidorDeFecha.convertirATimestamp(registroSalida.getFechaSalida()));
		registroSalidaEntity.setValorServicio(registroSalida.getValorServicio());
		registroSalidaEntity.setEntrada(RegistroEntradaBuilder.convertirAEntity(registroSalida.getEntrada()));
		registroSalidaEntity.getEntrada().setEstadoParqueo(Boolean.FALSE);		
		return RegistroSalidaBuilder.convertirADominio(registroSalidaRepository.save(registroSalidaEntity));
	}

}
