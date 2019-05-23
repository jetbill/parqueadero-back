package co.com.ceiba.adn.parqueaderoback.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity(name="entradas")
public class RegistroEntradaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "fecha_entrada", nullable = false)
	private Timestamp fechaEntrada;
	
	@Column(name = "estado_parqueo", nullable = false)
	private Boolean estadoParqueo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="matricula")
	//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private VehiculoEntity vehiculoEntity;
	
	@Column(name = "tipo_vehiculo", nullable = false)
	private String tipoVehiculo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Timestamp fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Boolean getEstadoParqueo() {
		return estadoParqueo;
	}
	public void setEstadoParqueo(Boolean estadoParqueo) {
		this.estadoParqueo = estadoParqueo;
	}
	
	public VehiculoEntity getVehiculoEntity() {
		return vehiculoEntity;
	}
	public void setVehiculoEntity(VehiculoEntity vehiculoEntity) {
		this.vehiculoEntity = vehiculoEntity;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	
}
