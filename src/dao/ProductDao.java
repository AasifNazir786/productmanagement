package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, expiry from products"; 
        if (con == null) {
            System.out.println("Failed to fetch product: No active database connection.");
            return new ArrayList<>();
        }
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setExpiry(rs.getInt(4));
                products.add(p);
            }    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return products;
    } 
    
    public Product getByName(String name) {
        String query = "select * from products where name = ?";
        Product product = null;
        if (con == null) {
            System.out.println("Failed to fetch product: No active database connection.");
            return product;
        }
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                product = new Product();
                product.setName(rs.getString(2).toLowerCase());
                product.setType(rs.getString(3).toLowerCase());
                product.setPlace(rs.getString(4).toLowerCase());
                product.setExpiry(rs.getInt(5 ));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return product;
    }
    
}
