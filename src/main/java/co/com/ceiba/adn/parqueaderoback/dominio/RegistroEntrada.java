package co.com.ceiba.adn.parqueaderoback.dominio;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RegistroEntrada {
	private Long id;
	private LocalDateTime fechaEntrada;
	private Boolean estadoParqueo;
	private Vehiculo vehiculo;
	private TipoVehiculo tipoVehiculo;
	
	public RegistroEntrada() {
	}

	public RegistroEntrada(Long id, LocalDateTime fechaEntrada, Boolean estadoParqueo) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.estadoParqueo = estadoParqueo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Boolean getEstadoParqueo() {
		return estadoParqueo;
	}

	public void setEstadoParqueo(Boolean estadoParqueo) {
		this.estadoParqueo = estadoParqueo;
	}

	

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "RegistroEntrada [id=" + id + ", fechaEntrada=" + fechaEntrada + ", estadoParqueo=" + estadoParqueo
				+ ", vehiculo=" + vehiculo + ", tipoVehiculo=" + tipoVehiculo + "]";
	}
	
	

}
