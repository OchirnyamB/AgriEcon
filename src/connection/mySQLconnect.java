package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bazarsad on 11/2/2016.
 */
public class mySQLconnect {
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","yulya");

        }catch(Exception ex) {
            System.out.println("Database.getConnection() Error-->: " + ex.getMessage());
        }finally{
            return con;
        }
    }
    public static void close(Connection con){
        try{
            con.close();
        }catch(Exception ex){
            System.out.println("Connection close failed" + ex.getMessage());
        }

    }
}
