package co.com.ceiba.adn.parqueaderoback.dominio;

import java.time.LocalDateTime;

public class RegistroSalida {
	private Long id;
	private LocalDateTime fechaSalida;
	private Double valorServicio;
	private RegistroEntrada entrada;
	
	public RegistroSalida() {
		
	}
	
	public RegistroSalida(Long id, LocalDateTime fechaSalida, Double valorServicio) {
		this.id = id;
		this.fechaSalida = fechaSalida;
		this.valorServicio = valorServicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Double getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(Double valorServicio) {
		this.valorServicio = valorServicio;
	}

	public RegistroEntrada getEntrada() {
		return entrada;
	}

	public void setEntrada(RegistroEntrada entrada) {
		this.entrada = entrada;
	}
	
}
