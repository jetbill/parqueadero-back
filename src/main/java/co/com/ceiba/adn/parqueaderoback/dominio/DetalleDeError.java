package co.com.ceiba.adn.parqueaderoback.dominio;

import java.util.Date;

public class DetalleDeError {

	private Date fecha;
	private String mensaje;
	private String descripcion;
	
	public DetalleDeError(Date fecha, String mensaje, String descripcion) {
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}
	
	public DetalleDeError() {
		
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
