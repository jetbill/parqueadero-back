package co.com.ceiba.adn.parqueaderoback.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity(name="salidas")
public class RegistroSalidaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "fecha_salida", nullable = false)
	private Timestamp fechaSalida;
	
	@Column(name = "valor_servicio", nullable = false)
	private Double valorServicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_entrada")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private RegistroEntradaEntity entrada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorServicio() {
		return valorServicio;
	}
	public void setValorServicio(Double valorServicio) {
		this.valorServicio = valorServicio;
	}
	public RegistroEntradaEntity getEntrada() {
		return entrada;
	}
	public void setEntrada(RegistroEntradaEntity entrada) {
		this.entrada = entrada;
	}
	public Timestamp getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	

}
