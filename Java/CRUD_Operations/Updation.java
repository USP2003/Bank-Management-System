package CRUD_Operations;
import java.sql.*;
public class Updation {
    public static void main(String[] args) {
        try {

            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026");
            CallableStatement cs= con.prepareCall("{call DETECT_RISK()}");
            cs.execute();
            System.out.println("Risk Detection executed");

            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}
