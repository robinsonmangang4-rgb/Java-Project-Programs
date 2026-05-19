import java.util.ArrayList;
import java.util.Scanner;

public class MiniAtmMachine {

    // ---------------- GLOBAL VARIABLES ----------------

    static Scanner sc = new Scanner(System.in);

    static double balance = 10000;

    static String pin = "1234";

    static ArrayList<String> history = new ArrayList<>();

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        int choice;

        do {

            showMainMenu();

            System.out.print("\nChoose Option: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1 -> balanceInquiry();

                case 2 -> miniStatement();

                case 3 -> atmServices();

                case 4 -> billPayments();

                case 5 -> fastCash();

                case 6 -> cashWithdrawal();

                case 7 -> pinChange();

                case 8 -> fundsTransfer();

                case 9 -> {
                    System.out.println("\nThank You For Using MINI ATM");
                    System.out.println("Visit Again!");
                }

                default -> System.out.println("Invalid Input!");
            }

        } while (choice != 9);

        sc.close();
    }

    // ---------------- MAIN MENU ----------------

    public static void showMainMenu() {

        System.out.println("\n================================");
        System.out.println("         MINI ATM MACHINE       ");
        System.out.println("================================");

        System.out.println("1. Balance Inquiry");
        System.out.println("2. Mini Statement");
        System.out.println("3. ATM Services");
        System.out.println("4. Bill Payments");
        System.out.println("5. Fast Cash");
        System.out.println("6. Cash Withdrawal");
        System.out.println("7. PIN Change");
        System.out.println("8. Funds Transfer");
        System.out.println("9. Exit");
    }

    // ---------------- BALANCE ----------------

    public static void balanceInquiry() {

        System.out.println("\n----- Balance Inquiry -----");

        System.out.println("Available Balance : ₹" + balance);
    }

    // ---------------- MINI STATEMENT ----------------

    public static void miniStatement() {

        System.out.println("\n----- Mini Statement -----");

        if (history.isEmpty()) {

            System.out.println("No Transactions Yet.");

        } else {

            for (String transaction : history) {

                System.out.println(transaction);
            }
        }
    }

    // ---------------- ATM SERVICES ----------------

    public static void atmServices() {

        int serviceChoice;

        do {

            System.out.println("\n===== ATM SERVICES =====");

            System.out.println("1. Mobile Banking");
            System.out.println("2. Internet Banking");
            System.out.println("3. Customer Support");
            System.out.println("4. Cheque Book Request");
            System.out.println("5. SMS Alert Service");
            System.out.println("6. Debit Card Service");
            System.out.println("7. Back To Main Menu");

            System.out.print("Choose Service: ");

            serviceChoice = sc.nextInt();

            switch (serviceChoice) {

                case 1 -> mobileBanking();

                case 2 -> internetBanking();

                case 3 -> customerSupport();

                case 4 -> chequeBookRequest();

                case 5 -> smsAlertService();

                case 6 -> debitCardService();

                case 7 -> System.out.println("Returning to Main Menu...");

                default -> System.out.println("Invalid Service Option!");
            }

        } while (serviceChoice != 7);
    }

    // ---------------- MOBILE BANKING ----------------

    public static void mobileBanking() {

        System.out.println("\nMobile Banking Activated Successfully.");

        history.add("Mobile Banking Activated");
    }

    // ---------------- INTERNET BANKING ----------------

    public static void internetBanking() {

        System.out.println("\nInternet Banking Activated Successfully.");

        history.add("Internet Banking Activated");
    }

    // ---------------- CUSTOMER SUPPORT ----------------

    public static void customerSupport() {

        System.out.println("\nConnecting To Customer Support...");

        System.out.println("Customer Care Number : 1800-123-456");

        history.add("Customer Support Accessed");
    }

    // ---------------- CHEQUE BOOK ----------------

    public static void chequeBookRequest() {

        System.out.println("\nCheque Book Request Submitted.");

        history.add("Cheque Book Requested");
    }

    // ---------------- SMS ALERT ----------------

    public static void smsAlertService() {

        System.out.println("\nSMS Alert Service Activated.");

        history.add("SMS Alert Activated");
    }

    // ---------------- DEBIT CARD SERVICE ----------------

    public static void debitCardService() {

        System.out.println("\nDebit Card Is Active And Secure.");

        history.add("Debit Card Service Accessed");
    }

    // ---------------- BILL PAYMENTS ----------------

    public static void billPayments() {

        int billChoice;

        do {

            System.out.println("\n===== BILL PAYMENTS =====");

            System.out.println("1. Electricity Bill");
            System.out.println("2. Water Bill");
            System.out.println("3. Mobile Recharge");
            System.out.println("4. Gas Bill");
            System.out.println("5. Back");

            System.out.print("Choose Option: ");

            billChoice = sc.nextInt();

            switch (billChoice) {

                case 1 -> payBill("Electricity Bill");

                case 2 -> payBill("Water Bill");

                case 3 -> payBill("Mobile Recharge");

                case 4 -> payBill("Gas Bill");

                case 5 -> System.out.println("Returning...");

                default -> System.out.println("Invalid Option!");
            }

        } while (billChoice != 5);
    }

    // ---------------- PAY BILL METHOD ----------------

    public static void payBill(String billType) {

        System.out.print("\nEnter Amount : ₹");

        double amount = sc.nextDouble();

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            System.out.println(billType + " Paid Successfully.");

            history.add(billType + " Paid : ₹" + amount);

        } else {

            System.out.println("Insufficient Balance or Invalid Amount.");
        }
    }

    // ---------------- FAST CASH ----------------

    public static void fastCash() {

        System.out.println("\n===== FAST CASH =====");

        System.out.println("1. ₹500");
        System.out.println("2. ₹1000");
        System.out.println("3. ₹2000");
        System.out.println("4. ₹5000");

        System.out.print("Choose Amount Option: ");

        int option = sc.nextInt();

        int amount = 0;

        switch (option) {

            case 1 -> amount = 500;

            case 2 -> amount = 1000;

            case 3 -> amount = 2000;

            case 4 -> amount = 5000;

            default -> {
                System.out.println("Invalid Option.");
                return;
            }
        }

        withdraw(amount);
    }

    // ---------------- CASH WITHDRAWAL ----------------

    public static void cashWithdrawal() {

        System.out.print("\nEnter Withdrawal Amount : ₹");

        int amount = sc.nextInt();

        withdraw(amount);
    }

    // ---------------- REUSABLE WITHDRAW METHOD ----------------

    public static void withdraw(int amount) {

        if (amount <= 0) {

            System.out.println("Invalid Amount.");

        } else if (amount <= balance) {

            balance -= amount;

            System.out.println("Withdrawal Successful.");

            System.out.println("Remaining Balance : ₹" + balance);

            history.add("Withdrawn : ₹" + amount);

        } else {

            System.out.println("Insufficient Balance.");
        }
    }

    // ---------------- PIN CHANGE ----------------

    public static void pinChange() {

        System.out.print("\nEnter New PIN : ");

        pin = sc.next();

        System.out.println("PIN Changed Successfully.");

        history.add("PIN Changed");
    }

    // ---------------- FUNDS TRANSFER ----------------

    public static void fundsTransfer() {

        System.out.print("\nEnter Account Number : ");

        String accountNumber = sc.next();

        System.out.print("Enter Transfer Amount : ₹");

        double amount = sc.nextDouble();

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            System.out.println("Funds Transfer Successful.");

            history.add("Transferred ₹" + amount +
                    " to A/C : " + accountNumber);

        } else {

            System.out.println("Invalid Amount or Insufficient Balance.");
        }
    }
}