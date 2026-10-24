import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:ucanaccess://DUD_RAKIB.accdb"
            );

            String sql = "INSERT INTO Student ([Name], Email, Phone) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Name: ");
            ps.setString(1, sc.nextLine());

            System.out.print("Enter Email: ");
            ps.setString(2, sc.nextLine());

            System.out.print("Enter Phone: ");
            ps.setString(3, sc.nextLine());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Student data inserted successfully.");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}