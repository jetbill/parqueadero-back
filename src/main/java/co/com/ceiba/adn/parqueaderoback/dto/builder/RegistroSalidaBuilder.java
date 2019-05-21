package co.com.ceiba.adn.parqueaderoback.dto.builder;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroSalida;
import co.com.ceiba.adn.parqueaderoback.entity.RegistroSalidaEntity;
import co.com.ceiba.adn.parqueaderoback.utilities.ConvertidorDeFecha;

public final class RegistroSalidaBuilder {
	
	public static RegistroSalida convertirADominio(RegistroSalidaEntity registroSalidaEntity) {
		RegistroSalida registroSalida = null;
		
		if(registroSalidaEntity!=null) {
			registroSalida = new RegistroSalida();
			registroSalida.setId(registroSalidaEntity.getId());
			registroSalida.setFechaSalida(ConvertidorDeFecha.convertirALocalDateTime(registroSalidaEntity.getFechaSalida()));
			registroSalida.setValorServicio(registroSalidaEntity.getValorServicio());
			registroSalida.setEntrada(RegistroEntradaBuilder.convertirADominio(registroSalidaEntity.getEntrada()));
		}
		
		return registroSalida;
		
	}
	
	public static RegistroSalidaEntity convertirAEntity(RegistroSalida registroSalida) {
		RegistroSalidaEntity registroSalidaEntity = null;
		if(registroSalida!=null) {
			registroSalidaEntity = new RegistroSalidaEntity();
			registroSalidaEntity.setId(registroSalida.getId());
			registroSalidaEntity.setFechaSalida(ConvertidorDeFecha.convertirATimestamp(registroSalida.getFechaSalida()));
			registroSalidaEntity.setValorServicio(registroSalida.getValorServicio());
			registroSalidaEntity.setEntrada(RegistroEntradaBuilder.convertirAEntity(registroSalida.getEntrada()));			
			
		}
		return registroSalidaEntity; 
	}
	
}
