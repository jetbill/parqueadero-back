package co.com.ceiba.adn.parqueaderoback.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

@Entity(name="vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public class VehiculoEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Size(min=3,max=6)
	@Column(nullable=false)
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
