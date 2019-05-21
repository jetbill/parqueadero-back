package co.com.ceiba.adn.parqueaderoback.validations;

public final class Constantes {
	
	public static final String RESTRINCION_MATRICULA = "A";
	public static final String MSG_PARQUEO_NO_DISPONIBLE = "Actualmente no se encuentran estacionamientos disponibles para este vehiculo";
	public static final String MSG_INGRESO_NO_PERMITIDO = "Ingreso no permitido para vehiculos con esta esta placa";
	public static final String MSG_INGRESO_EXISTENTE = "Vehiculo ya se encuentra ingresado";
	public static final Integer MAXIMO_CARRO = 20;
	public static final Integer MAXIMO_MOTO = 10;
	public static final Double CILINDRAJE_SUP = 500.0;
	public static final Double VALOR_EXCEDENTE = 2000.0;
	public static final Integer LIMITE_DIA_INFERIOR = 9;
	public static final Integer LIMITE_DIA_SUPERIOR = 24;
	public static final Long HORA_MILISEGUNDOS = 3600000L;
	public static final String MSG_ENTRADA_NO_ENCONTRADA = "No se puede generar salida porque no hay entrada relacionada";
	public static final String MSG_SALIDA_REGISTRADA = "Ya se encuentra una salida registrada para esta entrada";

	public static final Double VALOR_HORA_CARRO = 1000.0;
	public static final Double VALOR_HORA_MOTO = 500.0;
	public static final Double VALOR_DIA_CARRO = 8000.0;
	public static final Double VALOR_DIA_MOTO = 4000.0;
	
}
