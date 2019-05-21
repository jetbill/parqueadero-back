package co.com.ceiba.adn.parqueaderoback.dominio;

public class Carro extends Vehiculo{
	
	public Carro() {
		
	}
	
public Carro(String matricula) {
	super(matricula);
		
	}

@Override
public TipoVehiculo getTipoVehiculo() {
	return TipoVehiculo.CARRO;
}


	
	
	

}
