import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        final int MIN_PARK_TEMP = 70;
        final int MAX_PARK_TEMP = 90;

        Scanner input = new Scanner(System.in); // Declare Scanner here

        try {
            System.out.print("Enter a Fahrenheit value: ");
            int fahrenheit = input.nextInt();
            input.nextLine(); // cleans up newline at the end of user input

            System.out.print("Enter a date in format of DayOfWeek: ");
            String day = input.next();

            double celsius = (5.0 / 9) * (fahrenheit - 32);

            boolean raining = false;
            System.out.print("Is it raining? (y/n): ");
            String rainInput = input.next().toLowerCase();
            if (rainInput.startsWith("y")) {
                raining = true;
            }

            System.out.printf("%s Celsius: %.1f\n", day, celsius);

            if ((fahrenheit >= MIN_PARK_TEMP) && (fahrenheit <= MAX_PARK_TEMP)) {
                System.out.println("Yay! It's at least " + MIN_PARK_TEMP + " degrees but under " + MAX_PARK_TEMP + ".");
            } 
            
            if (raining) {
                System.out.println("Look up fun things to do in the rain.");
            }
            
            else {
                System.out.println("Time to go to the park.");
            } 
            System.out.println("Bye");
        }
        finally {
            input.close(); // Close the Scanner to avoid resource leak
        }
    }
}
