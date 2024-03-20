package electricity.billing.system;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conn {
Connection c;
Statement s;
     public Conn()
    {
        try
        {
            c = DriverManager.getConnection("jdbc:mysql:///electricitybillingsystem","root", "123456");
            s=c.createStatement();
            System.out.println("Successfully connected");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Conn();
    }
}
