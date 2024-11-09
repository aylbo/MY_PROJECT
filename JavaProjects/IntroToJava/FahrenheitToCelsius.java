package JavaProjects.lib.IntroToJava;

import java.util.Scanner;
public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        input.nextLine(); //cleans up newLine at the end of user input
        System.out.print("Enter a date in format of DayOfWeek Month Day: ");  
        String day = input.nextLine();
        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.println(day + " Celsius: " + celsius);
        if (fahrenheit > 70) {
            System.out.println("Yay! Go to park.");
        }
    }
}