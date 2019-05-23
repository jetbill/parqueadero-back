package co.com.ceiba.adn.parqueaderoback.validations;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

import co.com.ceiba.adn.parqueaderoback.dominio.RegistroEntrada;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;
import co.com.ceiba.adn.parqueaderoback.exceptions.EntradaException;
import co.com.ceiba.adn.parqueaderoback.service.RegistroEntradaService;

public abstract class CondicionParqueo 
{
	
	
	private Vehiculo vehiculo;
	private LocalDateTime fechaEntrda;
	protected RegistroEntradaService registroEntrada;
	
	public CondicionParqueo(Vehiculo vehiculo, LocalDateTime fechaEntrda, RegistroEntradaService registroEntrada) {
		this.vehiculo = vehiculo;
		this.fechaEntrda = fechaEntrda;
		this.registroEntrada = registroEntrada;
	}
	
	protected abstract Boolean validarDisponibilidad();
	
	private Boolean validarIngresoSegunMatriculaYdiaDeSemana() {
		if(vehiculo.getMatricula().toUpperCase().startsWith(Constantes.RESTRINCION_MATRICULA)) {
			DayOfWeek dia = fechaEntrda.getDayOfWeek();
			return dia != DayOfWeek.SUNDAY && dia != DayOfWeek.MONDAY;
			
		}
		return true;
	}
	
	private Boolean validarParqueoExistente() {
		List<RegistroEntrada> entradas = registroEntrada.vehiculosRegistradosPorMatricula(vehiculo.getMatricula());
		return !entradas.isEmpty();
	}
	
	public void validarIngreso() {
		if(!validarDisponibilidad()) {
			throw new EntradaException(Constantes.MSG_PARQUEO_NO_DISPONIBLE);
		}else if(!validarIngresoSegunMatriculaYdiaDeSemana()) {
			throw new EntradaException(Constantes.MSG_INGRESO_NO_PERMITIDO);
		}else if(validarParqueoExistente()) {
			throw new EntradaException(Constantes.MSG_INGRESO_EXISTENTE);
		}
	}
	
}
