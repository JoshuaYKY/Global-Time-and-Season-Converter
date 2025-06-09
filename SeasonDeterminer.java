import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class SeasonDeterminer {
    public static String checkSeason(String pCountry) {
        Map<String, String> hemispheres = new HashMap<>();
        hemispheres.put("USA", "Northern");
        hemispheres.put("Japan", "Northern");
        hemispheres.put("Australia", "Southern");
        hemispheres.put("India", "Northern");
        hemispheres.put("UK", "Northern");
        hemispheres.put("Canada", "Northern");
        hemispheres.put("Germany", "Northern");
        hemispheres.put("China", "Northern");
        hemispheres.put("South Africa", "Southern");
        hemispheres.put("France", "Northern");
        hemispheres.put("UAE", "Northern");
        hemispheres.put("Russia", "Northern");
        hemispheres.put("Argentina", "Southern");
        hemispheres.put("Mexico", "Northern");
        hemispheres.put("New Zealand", "Southern");

        String country = pCountry.trim().toLowerCase();

       
        if (!hemispheres.containsKey(country)) {
            System.out.println("Country not supported.");
            return null;
        }


        String hemi = hemispheres.get(country);
        LocalDate date = LocalDate.now();
        Month m = date.getMonth();
        int d = date.getDayOfMonth();

        String season;

        if (hemi.equals("Northern")) {
            if ((m == Month.MARCH && d >= 20) || m == Month.APRIL || m == Month.MAY || (m == Month.JUNE && d<=20)) {
                season = "Spring";
            }
            else if ((m == Month.JUNE && d >= 21) || m == Month.JULY || m == Month.AUGUST || (m == Month.SEPTEMBER && d<= 22)) {
                season = "Summer";
            }
            else if ((m == Month.SEPTEMBER && d >= 23) || m == Month.OCTOBER || m == Month.NOVEMBER || (m == Month.DECEMBER && d <= 21)) {
                season = "Fall";
            }
            else {
                    season = "Winter";
            }
        } else {
            if ((m == Month.MARCH && d >= 20) || m == Month.APRIL || m == Month.MAY || (m == Month.JUNE && d<=20)) {
                season = "Fall";
            }
            else if ((m == Month.JUNE && d >= 21) || m == Month.JULY || m == Month.AUGUST || (m == Month.SEPTEMBER && d<= 22)) {
                season = "Winter";
            }
            else if ((m == Month.SEPTEMBER && d >= 23) || m == Month.OCTOBER || m == Month.NOVEMBER || (m == Month.DECEMBER && d <= 21)) {
                season = "Spring";
            }
            else {
                    season = "Summer";
            }
        }

        return season;
    }
}
