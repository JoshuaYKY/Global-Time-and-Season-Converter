import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class TimeConverter {
    public static LocalTime convertTime(String pFrom, String pTo, String timeInput) {
        Map<String, String> timezones = new HashMap<>();
        timezones.put("usa", "America/New_York");
        timezones.put("japan", "Asia/Tokyo");
        timezones.put("australia", "Australia/Sydney");
        timezones.put("malaysia", "Asia/Kuala_Lumpur");
        timezones.put("india", "Asia/Kolkata");
        timezones.put("uk", "Europe/London");
        timezones.put("canada", "America/Toronto");
        timezones.put("germany", "Europe/Berlin");
        timezones.put("china", "Asia/Shanghai");
        timezones.put("brazil", "America/Sao_Paulo");
        timezones.put("south africa", "Africa/Johannesburg");
        timezones.put("france", "Europe/Paris");
        timezones.put("uae", "Asia/Dubai");
        timezones.put("russia", "Europe/Moscow");

        String from = pFrom.trim().toLowerCase();
        String to = pTo.trim().toLowerCase();

        if (!timezones.containsKey(from) || !timezones.containsKey(to)) {
            System.out.println("Country not supported.");
            return null;
        }

        try {
            LocalTime time = LocalTime.parse(timeInput);
            LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time);

            ZoneId fromZone = ZoneId.of(timezones.get(from));
            ZoneId toZone = ZoneId.of(timezones.get(to));

            ZonedDateTime fromZoned = dateTime.atZone(fromZone);
            ZonedDateTime toZoned = fromZoned.withZoneSameInstant(toZone);

            System.out.println("Converted time in " + to + ": " + toZoned.toLocalTime());
            return toZoned.toLocalTime();
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm.");
            return null;
        }
    }
}
