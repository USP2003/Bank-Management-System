package CRUD_Operations;
import java.sql.*;
public class InsertTransaction {
    public static void main(String[] args) {
        try {

            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026");

           PreparedStatement pr= con.prepareStatement("INSERT INTO transactions VALUES(?,?,?,?,?,SYSDATE,NULL)");
           pr.setInt(1,404);
           pr.setInt(2,103);
           pr.setInt(3,89000);
           pr.setString(4,"DEBIT");
           pr.setString(5,"TRAVEL");
           pr.executeUpdate();
            System.out.println("Data inserted Successfully!");

            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}
