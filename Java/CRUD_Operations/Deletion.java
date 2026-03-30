package CRUD_Operations;
import java.sql.*;
public class Deletion {
    public static void main(String[] args) {
        try {

            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026");

            PreparedStatement pr=con.prepareStatement("DELETE FROM TRANSACTIONS WHERE AMOUNT=?");
            pr.setInt(1,5000);
            int rows=pr.executeUpdate();
            if(rows>0){
                System.out.println("Data deleted successfully!!");
            }else {
                System.out.println("Data Not Found");
            }

            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}
