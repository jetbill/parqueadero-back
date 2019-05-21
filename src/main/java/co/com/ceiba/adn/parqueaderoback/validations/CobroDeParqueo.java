package co.com.ceiba.adn.parqueaderoback.validations;



import co.com.ceiba.adn.parqueaderoback.dominio.CobroTarifa;
import co.com.ceiba.adn.parqueaderoback.dominio.TiempoDeServicio;
import co.com.ceiba.adn.parqueaderoback.dominio.Vehiculo;
import co.com.ceiba.adn.parqueaderoback.service.ValorTarifaService;

public class CobroDeParqueo {
	
	private Vehiculo vehiculo;
	private ValorTarifaService valorTarifa;
	
	public CobroDeParqueo(Vehiculo vehiculo, ValorTarifaService valorTarifa) {
		this.vehiculo = vehiculo;
		this.valorTarifa = valorTarifa;
	}
	
	public Double totalAPargarParqueo(Integer cantidadHoras) {
		DetalleSalida detalleSalida = new CondicionSalida(vehiculo, cantidadHoras).calcularDetalleSalida();
		CobroTarifa cobroDia = valorTarifa.getTarifaTiempoDeServicioPorTipo(vehiculo.getTipoVehiculo(), TiempoDeServicio.DIA);
		CobroTarifa cobroHora = valorTarifa.getTarifaTiempoDeServicioPorTipo(vehiculo.getTipoVehiculo(), TiempoDeServicio.HORA);

		Double total = cobroDia.getValor() * detalleSalida.getDias();
		total += cobroHora.getValor() * detalleSalida.getHoras();
		total += detalleSalida.getExcedente();
		return total;
		
	}
	
	
	

}
