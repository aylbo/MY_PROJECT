package HWs;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner input = new Scanner (System.in)) {
            System.out.println("List of operations: add subtract multiply divide alphabetize");
            System.out.println("Enter an operation:");
            String operation = input.nextLine().toLowerCase();

            switch (operation) {
                case "add":
                    int int1 = 0, int2 = 0;
                    System.out.println("Enter two integers:");
                    if (input.hasNextInt()) {
                        int1 = input.nextInt();
                        if (input.hasNextInt()) {
                            int2 = input.nextInt();
                        } else {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    int sum = int1 + int2;
                    System.out.println("Answer: " + sum);
                    break;
                
                case "subtract":
                int int3 = 0, int4 = 0;
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    int3 = input.nextInt();
                    if (input.hasNextInt()) {
                        int4 = input.nextInt();
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                    int subs = int3 - int4;
                    System.out.println("Answer: " + subs);
                break;                   

                case "multiply":
                    double dbl1 = 0, dbl2 = 0;
                    System.out.println("Enter two doubles:");
                    if (input.hasNextDouble()) {
                        dbl1 = input.nextDouble();
                        if (input.hasNextDouble()) {
                            dbl2 = input.nextDouble();
                        } else {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    double mult = dbl1 * dbl2;
                    System.out.printf("Answer: %.2f\n", mult);
                break;    

                case "divide":
                    double dbl3 = 0, dbl4 = 1;
                    System.out.println("Enter two doubles:");
                    if (input.hasNextDouble()) {
                        dbl3 = input.nextDouble();
                        if (input.hasNextDouble()) {
                            dbl4 = input.nextDouble();
                            if (dbl4 != 0) {
                                double div = dbl3 / dbl4;
                                System.out.printf("Answer: %.2f\n", div);
                            } else {
                                System.out.println("Invalid input entered. Terminating...");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
  
                case "alphabetize":
                    System.out.println("Enter two words:");
                    String wrd1 = input.next();
                    String wrd2 = input.next();
                    int result = wrd1.toLowerCase().compareTo(wrd2.toLowerCase());
                    if (result < 0) {
                        System.out.println("Answer: " + wrd1 + " comes before " + wrd2 + " alphabetically.");
                    } else if (result > 0) {
                        System.out.println("Answer: " + wrd2 + " comes before " + wrd1 + " alphabetically.");
                    } else {
                        System.out.println("Answer: Chicken or Egg.");
                    }
                    break;    

                default:
                    System.out.println("Invalid input entered. Terminating...");
                    break;
            }
        }

    }
}
