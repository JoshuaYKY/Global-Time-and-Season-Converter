import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<String, String> timezones = new HashMap<>();
        timezones.put("USA", "America/New_York");
        timezones.put("Japan", "Asia/Tokyo");
        timezones.put("Australia", "Australia/Sydney");

        Map<String, String> hemispheres = new HashMap<>();
        hemispheres.put("USA", "Northern");
        hemispheres.put("Japan", "Northern");
        hemispheres.put("Australia", "Southern");

        int choice;
        do {
            System.out.println("\n=== World Time & Season App ===");
            System.out.println("1. Convert Time");
            System.out.println("2. Determine Current Season");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine(); // clear newline

            if (choice == 1) {
                System.out.print("Enter source country: ");
                String source = input.nextLine();
                System.out.print("Enter target country: ");
                String target = input.nextLine();
                System.out.print("Enter time (HH:mm): ");
                String time = input.nextLine();

                TimeConverter.convertTime(source, target, time, timezones);
            }

            if (choice == 2) {
                System.out.print("Enter country: ");
                String country = input.nextLine();
                SeasonDeterminer.checkSeason(country, hemispheres);
            }

        } while (choice != 3);

        System.out.println("Goodbye!");
        input.close();
    }
}
