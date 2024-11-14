public class HelloWorldLoop {
    public static void main(String[] args) {
        int outerCounter = 1;
        while (outerCounter <= 5) {
            int innerCounter = 1;
            while (innerCounter < 10) {
                System.out.println("Hello, World!");
                innerCounter++;
            }
        outerCounter++;
        }
    }
}