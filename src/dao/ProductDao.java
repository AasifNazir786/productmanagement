package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Product;
import utility.DBUtil;

public class ProductDao {
    private DBUtil db = new DBUtil();
    private Connection con = null;
    public void save(Product p) {
        String query = "insert into products(name, type, place, expiry) values (?, ?, ?, ?)";
        try {
            con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getType());
            pstmt.setString(3, p.getPlace());
            pstmt.setInt(4, p.getExpiry());
            pstmt.execute();
            System.out.println("product saving successfully.");
        } catch (Exception e) {
            System.out.println("Error saving product: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
