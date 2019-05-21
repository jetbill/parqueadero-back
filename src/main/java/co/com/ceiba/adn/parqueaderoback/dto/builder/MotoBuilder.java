package co.com.ceiba.adn.parqueaderoback.dto.builder;

import co.com.ceiba.adn.parqueaderoback.dominio.Moto;
import co.com.ceiba.adn.parqueaderoback.entity.MotoEntity;

public final class MotoBuilder {
	
	
	
	public static Moto convertirADominio(MotoEntity motoEntity) {
		Moto moto = null;
		if(motoEntity!=null) {
			moto = new Moto();
			moto.setMatricula(motoEntity.getMatricula());
			moto.setCilindraje(motoEntity.getCilindraje());
			
		}
		return moto;
		
	}
	
	public static MotoEntity convertirAEntity(Moto moto) {
		MotoEntity motoEntity = null;
		if(moto!=null) {
			motoEntity = new MotoEntity();
			motoEntity.setMatricula(moto.getMatricula());
			motoEntity.setCilindraje(moto.getCilindraje());
		}
		return motoEntity;
	}

}
