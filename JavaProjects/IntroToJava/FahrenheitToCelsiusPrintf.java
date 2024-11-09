package JavaProjects.IntroToJava;

import java.util.Scanner;
public class FahrenheitToCelsiusPrintf {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter a Fahrenheit value: ");
			int Fahrenheit = input.nextInt();
			System.out.print("Enter a day of the week: ");
			String day = input.next();
			System.out.print("Enter your preffered Celsius label (Celsius, Centigrade, C): ");
			String cText = input.next();
			double Celsius = (5.0/9) * (Fahrenheit - 32);
			System.out.printf("%s Fahrenheit: %d\n", day, Fahrenheit);
			System.out.printf("%s %10s: %.1f \n", day, cText, Celsius);
		}
	}
}