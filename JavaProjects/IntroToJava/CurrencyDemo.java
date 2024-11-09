package JavaProjects.IntroToJava;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class CurrencyDemo {
    public static void main(String[] args) {
        int items;
        double itemCost, total;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the number of items: ");
            items = input.nextInt();
            System.out.print("Enter the cost per item: ");
            itemCost = input.nextDouble();
        }
        total = items * itemCost;
        System.out.println("unformatted total: " + total);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("Formatted Total: " + currencyFormat.format(total));
    }   

}