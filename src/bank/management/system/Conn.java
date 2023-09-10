
package bank.management.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
           
            String dbUrl = "jdbc:mysql://bankmanagementsystem.cfhtjcorodku.ap-south-1.rds.amazonaws.com:3306/bankmanagementsystem";
            String dbUser = "admin";
            String dbPassword = "Atiqur786";

            c = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
