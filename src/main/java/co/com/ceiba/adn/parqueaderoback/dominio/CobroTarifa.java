package co.com.ceiba.adn.parqueaderoback.dominio;

public class CobroTarifa {
	private Double valor;
	private TipoVehiculo tipoVehiculo;
	private TiempoDeServicio tiempoServicio;
	
	
	public CobroTarifa(Double valor, TipoVehiculo tipoVehiculo, TiempoDeServicio tiempoServicio) {
		this.valor = valor;
		this.tipoVehiculo = tipoVehiculo;
		this.tiempoServicio = tiempoServicio;
	}
	
	
	public CobroTarifa(Double valor) {
		this.valor = valor;
	}


	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public TiempoDeServicio getTiempoServicio() {
		return tiempoServicio;
	}
	public void setTiempoServicio(TiempoDeServicio tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}
	
	

}
