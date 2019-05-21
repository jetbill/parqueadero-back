package co.com.ceiba.adn.parqueaderoback.dto.builder;

import co.com.ceiba.adn.parqueaderoback.dominio.Carro;
import co.com.ceiba.adn.parqueaderoback.dominio.Moto;
import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.dominio.TipoVehiculo;
import co.com.ceiba.adn.parqueaderoback.entity.CarroEntity;
import co.com.ceiba.adn.parqueaderoback.entity.MotoEntity;
import co.com.ceiba.adn.parqueaderoback.entity.RegistroEntradaEntity;
import co.com.ceiba.adn.parqueaderoback.utilities.ConvertidorDeFecha;

public final class RegistroEntradaBuilder {	
	
	
	public static RegistroEntrada convertirADominio(RegistroEntradaEntity registroEntradaEntity) {
		RegistroEntrada registroEntrada = null;
		if(registroEntradaEntity!=null) {
			registroEntrada = new RegistroEntrada();
			registroEntrada.setId(registroEntradaEntity.getId());
			registroEntrada.setFechaEntrada(ConvertidorDeFecha.convertirALocalDateTime(registroEntradaEntity.getFechaEntrada()));
			registroEntrada.setEstadoParqueo(registroEntradaEntity.getEstadoParqueo());		
			registroEntrada.setTipoVehiculo(TipoVehiculo.valueOf(registroEntradaEntity.getTipoVehiculo()));
			if(registroEntradaEntity.getVehiculoEntity() instanceof CarroEntity) {				
				registroEntrada.setVehiculo(CarroBuilder.convertirADominio((CarroEntity)registroEntradaEntity.getVehiculoEntity()));
			}else if (registroEntradaEntity.getVehiculoEntity() instanceof MotoEntity){
				registroEntrada.setVehiculo(MotoBuilder.convertirADominio((MotoEntity)registroEntradaEntity.getVehiculoEntity()));
			}
			
		}
		return registroEntrada;
	}
	
	public static RegistroEntradaEntity convertirAEntity(RegistroEntrada registroEntrada) {
		RegistroEntradaEntity registroEntradaEntity = null;
		if(registroEntrada!= null) {
			registroEntradaEntity = new RegistroEntradaEntity();
			registroEntradaEntity.setId(registroEntrada.getId());
			registroEntradaEntity.setFechaEntrada(ConvertidorDeFecha.convertirATimestamp(registroEntrada.getFechaEntrada()));
			registroEntradaEntity.setEstadoParqueo(registroEntrada.getEstadoParqueo());			
			if(registroEntrada.getVehiculo() instanceof Carro) {
				registroEntradaEntity.setTipoVehiculo(TipoVehiculo.CARRO.toString());
				registroEntradaEntity.setVehiculoEntity(CarroBuilder.convertirAEntity((Carro) registroEntrada.getVehiculo()));
			}else {
				registroEntradaEntity.setTipoVehiculo(TipoVehiculo.MOTO.toString());
				registroEntradaEntity.setVehiculoEntity(MotoBuilder.convertirAEntity((Moto) registroEntrada.getVehiculo()));
			}
			
		}
		
		
		return registroEntradaEntity;
	}
	
	

}
