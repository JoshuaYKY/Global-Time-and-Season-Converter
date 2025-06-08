import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class SeasonDeterminer {
    public static void checkSeason(String country, Map<String, String> hemispheres) {
        if (!hemispheres.containsKey(country)) {
            System.out.println("Country not supported.");
            return;
        }

        String hemi = hemispheres.get(country);
        LocalDate date = LocalDate.now();
        Month m = date.getMonth();
        int d = date.getDayOfMonth();

        String season;

        if (hemi.equals("Northern")) {
            if ((m == Month.MARCH && d >= 20) || m == Month.APRIL || m == Month.MAY)
                season = "Spring";
            else if ((m == Month.JUNE && d >= 21) || m == Month.JULY || m == Month.AUGUST)
                season = "Summer";
            else if ((m == Month.SEPTEMBER && d >= 22) || m == Month.OCTOBER || m == Month.NOVEMBER)
                season = "Fall";
            else
                season = "Winter";
        } else {
            if ((m == Month.SEPTEMBER && d >= 22) || m == Month.OCTOBER || m == Month.NOVEMBER)
                season = "Spring";
            else if ((m == Month.DECEMBER && d >= 21) || m == Month.JANUARY || m == Month.FEBRUARY)
                season = "Summer";
            else if ((m == Month.MARCH && d >= 20) || m == Month.APRIL || m == Month.MAY)
                season = "Fall";
            else
                season = "Winter";
        }

        System.out.println("Today is: " + date);
        System.out.println("Current season in " + country + ": " + season);
    }
}
