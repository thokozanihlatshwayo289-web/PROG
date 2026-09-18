
package poe.prog;

import java.util.Scanner;
// Main application execution class
public class PROG {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- ACCOUNT REGISTRATION ---");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        Login userLogin = new Login(firstName, lastName);

        String registrationResult = "";

        while (true) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            System.out.print("Enter SA Cell Phone Number (+27...): ");
            String cellNumber = scanner.nextLine();

            registrationResult = userLogin.registerUser(username, password, cellNumber);
            System.out.println("\n" + registrationResult + "\n");

            if (registrationResult.contains("successfully added")) {
                break;
            }
        }

        System.out.println("--- LOGIN ACCOUNT ---");
        System.out.print("Enter Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        boolean isSuccess = userLogin.loginUser(loginUsername, loginPassword);
        System.out.println(userLogin.returnLoginStatus(isSuccess));

        scanner.close();
    }
}