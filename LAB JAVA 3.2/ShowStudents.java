import java.sql.*;

public class ShowStudents {
    public static void main(String[] args) {
        String url = "jdbc:ucanaccess://C:/Database/ICE_PUST.accdb";   // change to your file path

        try (Connection con = DriverManager.getConnection(url);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM Student")) {

            System.out.println("Name\tEmail\t\t\tPhone");
            System.out.println("-------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t"
                        + rs.getString("Email") + "\t"
                        + rs.getString("Phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}