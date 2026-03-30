package CRUD_Operations;
import java.sql.*;
public class ViewTransaction {
    public static void main(String[] args) {
        try {

            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "username",
                    "password");

            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM TRANSACTIONS");
            while (rs.next()){
                System.out.println(
                        rs.getInt("txn_id") + " " +
                                rs.getInt("amount") + " " +
                                rs.getString("category"));
            }


            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}
