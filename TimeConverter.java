import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class TimeConverter {
    public static LocalTime convertTime(String pFrom, String pTo, String timeInput) {
        Map<String, String> timezones = new HashMap<>();
        timezones.put("USA", "America/New_York");
        timezones.put("Japan", "Asia/Tokyo");
        timezones.put("Australia", "Australia/Sydney");
        timezones.put("Malaysia", "Asia/Kuala_Lumpur");
        timezones.put("India", "Asia/Kolkata");
        timezones.put("UK", "Europe/London");
        timezones.put("Canada", "America/Toronto");
        timezones.put("Germany", "Europe/Berlin");
        timezones.put("China", "Asia/Shanghai");
        timezones.put("Brazil", "America/Sao_Paulo");
        timezones.put("South Africa", "Africa/Johannesburg");
        timezones.put("France", "Europe/Paris");
        timezones.put("UAE", "Asia/Dubai");
        timezones.put("Russia", "Europe/Moscow");

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
