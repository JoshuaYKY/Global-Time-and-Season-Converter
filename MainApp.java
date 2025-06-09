import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
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

                LocalTime cTime = TimeConverter.convertTime(source, target, time);
                System.out.println("Converted time in " + source + ": " + target);

            }

            if (choice == 2) {
                System.out.print("Enter country: ");
                String country = input.nextLine();
                String season = SeasonDeterminer.checkSeason(country);

                System.out.println("Today is: " + LocalDate.now());
                System.out.println("Current season in " + country + ": " + season);
            }

            if (choice != 1 && choice != 2 && choice != 3){
                System.out.print("Invalid input, please try again!");
            }

        } while (choice != 3);

        System.out.println("Goodbye!");
        input.close();
    }
}