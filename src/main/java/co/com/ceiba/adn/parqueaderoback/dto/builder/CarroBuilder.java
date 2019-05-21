package co.com.ceiba.adn.parqueaderoback.dto.builder;

import co.com.ceiba.adn.parqueaderoback.dominio.Carro;
import co.com.ceiba.adn.parqueaderoback.entity.CarroEntity;

public final class CarroBuilder {
	
	
	public static Carro convertirADominio(CarroEntity carroEntity) {
		Carro carro = null;
		
			if(carroEntity!= null) {
				carro = new Carro();
				carro.setMatricula(carroEntity.getMatricula());				
			}
			
		return carro;
		
	}
	
	public static CarroEntity convertirAEntity(Carro carro) {
		CarroEntity carroEntity = null;
		if(carro!=null) {
			carroEntity = new CarroEntity();
			carroEntity.setMatricula(carro.getMatricula());
		}
		return carroEntity;
	}

}
