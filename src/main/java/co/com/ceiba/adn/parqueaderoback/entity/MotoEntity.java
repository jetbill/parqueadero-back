package co.com.ceiba.adn.parqueaderoback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="motos")
public class MotoEntity extends VehiculoEntity {
	
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private Double cilindraje;

	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
	

}
