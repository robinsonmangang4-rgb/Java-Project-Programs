import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Divide");
            System.out.println("4. Multiply");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1 -> System.out.println("Result = " + (num1 + num2));

                case 2 -> System.out.println("Result = " + (num1 - num2));

                case 3 -> System.out.println("Result = " + (num1 / num2));

                case 4 -> System.out.println("Result = " + (num1 * num2));

                default -> System.out.println("Invalid choice");
            }

            sc.close();
        }
    }
}