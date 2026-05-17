import java.util.Scanner;

public class miniATM {

    public static void main(String[] args) {

        int balance = 10000;

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("================================");
            System.out.println("         MINI ATM MACHINE       ");
            System.out.println("================================");

            System.out.println("1. Balance Inquiry");
            System.out.println("2. Mini Statement");
            System.out.println("3. Services");
            System.out.println("4. Bill Payments");
            System.out.println("5. Fast Cash");
            System.out.println("6. Cash Withdrawal");
            System.out.println("7. PIN Change");
            System.out.println("8. Funds Transfer");

            System.out.print("\nChoose Option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.println("\n----- Balance Inquiry -----");
                    System.out.println("Available Balance : $" + balance);
                }

                case 2 -> {
                    System.out.println("\n----- Mini Statement -----");
                    System.out.println("No recent transactions.");
                }

                case 3 -> {
                    System.out.println("\n----- Services -----");
                    System.out.println("Customer Care: 1800-000-000");
                }

                case 4 -> { 
                    System.out.println("\n----- Bill Payments -----");
                    System.out.println("Mobile bill paid successfully.");
                }

                case 5 -> {
                    System.out.println("\n----- Fast Cash -----");
                    System.out.println("You can withdraw below ₹10,000.");
                }

                case 6 -> {
                    System.out.println("\n----- Cash Withdrawal -----");

                    System.out.print("Enter Amount: ₹");
                    int withdrawAmount = sc.nextInt();

                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } 
                    else if (withdrawAmount <= balance) {

                        balance -= withdrawAmount;

                        System.out.println("Withdrawal Successful.");
                        System.out.println("Remaining Balance : ₹" + balance);
                    } 
                    else {
                        System.out.println("Insufficient Balance.");
                    }
                }

                case 7 -> {
                    System.out.println("\n----- PIN Change -----");

                    System.out.print("Enter New PIN: ");
                    int newPin = sc.nextInt();

                    System.out.println("PIN changed successfully.");
                }

                case 8 -> {
                    System.out.println("\n----- Funds Transfer -----");
                    System.out.println("Choose transfer method:");
                    System.out.println("1. UPI");
                    System.out.println("2. Bank Transfer");
                }

                default -> {
                    System.out.println("Invalid Input.");
                }
            }

            System.out.println("\nThank You For Using MINI ATM.");
        }
    }
}