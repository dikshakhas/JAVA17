import java.sql.*;
import java.util.Scanner;

public class VulnerableApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vulnerability #1: Insecure Input Handling (User input not sanitized)
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Vulnerability #2: SQL Injection
        // This is vulnerable to SQL injection attacks because user input is directly used in a SQL query.
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password")) {
            String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "';";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Vulnerability #3: Weak Authentication
        // Passwords should never be stored in plain text.
        System.out.println("Stored password: " + password);

        // Vulnerability #4: No session management
        // This example doesn't use any session management to track user state after login.
        System.out.println("No session management implemented.");
    }
}
