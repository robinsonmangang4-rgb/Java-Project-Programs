import java.util.Scanner;

public class login {
    public static void main(String[] args) throws InterruptedException {
        try (Scanner sc = new Scanner(System.in)) {
            String username, password;
            int attempts = 0;
            final int MAX_ATTEMPTS = 4;
System.out.println( "                  ''Login program by java'' ");

            while (true) {

                while (attempts < MAX_ATTEMPTS) {
                    System.out.print("Enter username: ");
                    username = sc.nextLine();

                    System.out.print("Enter password: ");
                    password = sc.nextLine();

                    if (username.equals("robin") && password.equals("robin@1234")) {
                        System.out.println("Login successful!");
                        sc.close();
                        return;
                    } else {
                        attempts++;
                        System.out.println("Invalid credentials. Attempts left: "
                                + (MAX_ATTEMPTS - attempts) + "\n");
                    }
                }

                // Lock with countdown
                System.out.println("Too many failed attempts!");
                System.out.println("Account locked for 15 seconds...");

                int totalSeconds = (1 * 60)/4;

                while (totalSeconds > 0) {
                    int minutes = totalSeconds / 60;
                    int seconds = totalSeconds % 60;

                    System.out.printf("Time remaining: %02d:%02d\r", minutes, seconds);

                    extracted();
                    totalSeconds--;
                }

                System.out.println("\nYou can try again now. Good luck\n");

                attempts = 0; // reset attempts
            }
        }
    }

    private static void extracted() throws InterruptedException {
        Thread.sleep(1000);
    }
}
