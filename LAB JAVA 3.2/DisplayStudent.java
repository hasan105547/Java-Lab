import java.sql.*;

public class DisplayStudent {
    public static void main(String[] args) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:ucanaccess://lab12.accdb"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT [Name], Email, Phone FROM Student");

            System.out.println("Name\t\tEmail\t\t\tPhone");
            System.out.println("-------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getString("Name") + "\t\t" +
                    rs.getString("Email") + "\t\t" +
                    rs.getString("Phone")
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}