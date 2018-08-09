package warframe.api.utils;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.SECONDS;;
public class TimeUtils {
	
	
	public static LocalTime gmtStringToLocalTime(String gmtTime) {
		Instant instant = Instant.parse(gmtTime);
		return instant.atZone(ZoneId.systemDefault()).toLocalTime();
		
	}
	
	public static String timeRemaining (LocalTime endTime) {
		LocalTime now = LocalTime.now();
		LocalTime result = endTime.minusSeconds(now.toSecondOfDay());
		return result.toString();
	}
	
	public static String timeRemaining(String gmtEndTime) {
		return timeRemaining(gmtStringToLocalTime(gmtEndTime));
	}
}
