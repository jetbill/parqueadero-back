package co.com.ceiba.adn.parqueaderoback.validations;

import co.com.ceiba.adn.parqueaderoback.dominio.Moto;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;

public class CondicionSalida {
	
	private Vehiculo vehiculo;
	private Integer cantidadHoras;
	
	public CondicionSalida(Vehiculo vehiculo, Integer cantidadHoras) {
		this.vehiculo = vehiculo;
		this.cantidadHoras = cantidadHoras;
	}
		
	private static Boolean aplicaReglaCilindrajeMoto(Moto moto) {
	return moto.getCilindraje() > Constantes.CILINDRAJE_SUP;	
	}
	
	private Double calcularExcedenteCilindrajeMoto(Vehiculo vehiculo) {
		Double excedente = 0.0;
		if((vehiculo instanceof Moto) && aplicaReglaCilindrajeMoto((Moto) vehiculo) ) {
			excedente+= Constantes.VALOR_EXCEDENTE;			
		}
		return excedente;
	}
		
	public DetalleSalida calcularDetalleSalida() {
		Integer dias = 0;
		Integer horas = 0;
		DetalleSalida calculoTiempo = new DetalleSalida();
		if (cantidadHoras > Constantes.LIMITE_DIA_SUPERIOR) {
			dias = cantidadHoras / Constantes.LIMITE_DIA_SUPERIOR;
			horas = cantidadHoras % Constantes.LIMITE_DIA_SUPERIOR;
			if (horas > Constantes.LIMITE_DIA_INFERIOR) {
				dias++;
				horas = 0;
			}
		} else if (cantidadHoras > Constantes.LIMITE_DIA_INFERIOR) {
			dias++;
			horas = 0;
		} else {
			horas = cantidadHoras;
		}
		calculoTiempo.setDias(dias);
		calculoTiempo.setHoras(horas);
		calculoTiempo.setExcedente(calcularExcedenteCilindrajeMoto(vehiculo));
		return calculoTiempo;
		
	}
	
}
