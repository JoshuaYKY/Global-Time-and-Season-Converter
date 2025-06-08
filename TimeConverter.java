import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class TimeConverter {
    public static void convertTime(String from, String to, String timeInput, Map<String, String> timezones) {
        if (!timezones.containsKey(from) || !timezones.containsKey(to)) {
            System.out.println("Country not supported.");
            return;
        }

        try {
            LocalTime time = LocalTime.parse(timeInput);
            LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time);

            ZoneId fromZone = ZoneId.of(timezones.get(from));
            ZoneId toZone = ZoneId.of(timezones.get(to));

            ZonedDateTime fromZoned = dateTime.atZone(fromZone);
            ZonedDateTime toZoned = fromZoned.withZoneSameInstant(toZone);

            System.out.println("Converted time in " + to + ": " + toZoned.toLocalTime());
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm.");
        }
    }
}
