package Data_Base_Connection;
import java.sql.*;
public class Connection {
    public static void main(String[] args) {
        try {

            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "username",
                    "password");

            Statement stmt = con.createStatement();


            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }

    }
}
