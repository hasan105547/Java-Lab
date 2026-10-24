import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/LAB12";
        String user = "root";
        String password = "hasan105547";

        try {
            Connection con = DriverManager.getConnection(
                url, user, password
            );

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Insert Student");
                System.out.println("2. Show Students");
                System.out.println("3. Edit Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    String sql = "INSERT INTO Student(name,email,phone) VALUES(?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, phone);
                    ps.executeUpdate();

                    System.out.println("Student inserted!");

                } else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM Student");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("email") + " | " +
                            rs.getString("phone")
                        );
                    }

                } else if (choice == 3) {
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter new phone: ");
                    String phone = sc.nextLine();

                    String sql = "UPDATE Student SET name=?, email=?, phone=? WHERE id=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, phone);
                    ps.setInt(4, id);

                    int rows = ps.executeUpdate();
                    System.out.println(rows > 0 ? "Student updated!" : "ID not found!");

                } else if (choice == 4) {
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM Student WHERE id=?"
                    );
                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();
                    System.out.println(rows > 0 ? "Student deleted!" : "ID not found!");

                } else if (choice == 5) {
                    con.close();
                    sc.close();
                    System.out.println("Program ended.");
                    break;

                } else {
                    System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}