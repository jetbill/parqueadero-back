package co.com.ceiba.adn.parqueaderoback.utilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class ConvertidorDeFecha {
	
	private ConvertidorDeFecha() {
	}

	public static Timestamp convertirATimestamp(LocalDateTime localDateTime) {
		Timestamp timestamp = null;
		if(localDateTime!=null) {
			timestamp = Timestamp.valueOf(localDateTime);
		}
		return timestamp;
	}

	public static LocalDateTime convertirALocalDateTime(Timestamp timestamp) {
		LocalDateTime localDateTime = null;
		if(timestamp != null) {
			localDateTime = timestamp.toLocalDateTime();
		}
		return localDateTime;
	}

}
