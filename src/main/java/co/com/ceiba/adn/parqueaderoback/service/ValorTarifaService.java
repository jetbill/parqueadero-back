package co.com.ceiba.adn.parqueaderoback.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.com.ceiba.adn.parqueaderoback.dominio.CobroTarifa;
import co.com.ceiba.adn.parqueaderoback.dominio.TiempoDeServicio;
import co.com.ceiba.adn.parqueaderoback.dominio.TipoVehiculo;
import co.com.ceiba.adn.parqueaderoback.validations.Constantes;

@Service
public class ValorTarifaService {

	private List<CobroTarifa> tarifas;

	public ValorTarifaService() {
		tarifas = new ArrayList<>();
		tarifas.add(new CobroTarifa(Constantes.VALOR_DIA_CARRO, TipoVehiculo.CARRO, TiempoDeServicio.DIA));
		tarifas.add(new CobroTarifa(Constantes.VALOR_HORA_CARRO, TipoVehiculo.CARRO, TiempoDeServicio.HORA));
		tarifas.add(new CobroTarifa(Constantes.VALOR_DIA_MOTO, TipoVehiculo.MOTO, TiempoDeServicio.DIA));
		tarifas.add(new CobroTarifa(Constantes.VALOR_HORA_MOTO, TipoVehiculo.MOTO, TiempoDeServicio.HORA));

	}

	public List<CobroTarifa> getTarifasPorTipo(TipoVehiculo tipoVehiculo) {
		return tarifas.stream().filter(obj -> obj.getTipoVehiculo() == tipoVehiculo).collect(Collectors.toList());
	}

	public CobroTarifa getTarifaTiempoDeServicioPorTipo(TipoVehiculo tipoVehiculo, TiempoDeServicio tiempoDeServicio) {
		return tarifas.stream()
				.filter(obj -> obj.getTiempoServicio() == tiempoDeServicio && obj.getTipoVehiculo() == tipoVehiculo)
				.findFirst().orElse(new CobroTarifa(BigDecimal.ZERO.doubleValue()));
	}

	public List<CobroTarifa> obtenerTodasLasTarifas() {
		return tarifas;
	}

	public List<CobroTarifa> obtenerTarifaCarro() {
		return getTarifasPorTipo(TipoVehiculo.CARRO);
	}

	public List<CobroTarifa> obtenerTarifaMoto() {
		return getTarifasPorTipo(TipoVehiculo.MOTO);

	}

}
