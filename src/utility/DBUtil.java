package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private Connection con;
    private String url = "jdbc:postgresql://localhost:5432/product-management";
    private String uName = "postgres";
    private String password = "njasm786";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            con = DriverManager.getConnection(url, uName, password);
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
    
}
