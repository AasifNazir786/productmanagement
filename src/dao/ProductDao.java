package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utility.DBUtil;

public class ProductDao {
    private DBUtil db = new DBUtil();
    private Connection con = null;

    //save new products in the databases
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
            con.close();
            pstmt.close();
            System.out.println("product saving successfully.");
        } catch (Exception e) {
            System.out.println("Error saving product: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //fetching all the data from the database
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, expiry from products"; 
        con = db.getConnection();
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
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection: " + e.getMessage());
            }
        }
        return products;
    } 
    

    //fetching the data by their names
    public Product getByName(String name) throws SQLException{
        String query = "select * from products where name = ?";
        Product product = null;
        con = db.getConnection();
        if (con == null || con.isClosed()) {
            System.out.println("Failed to fetch product: No active database connection.");
            return product;
        }
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                product = new Product();
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPlace(rs.getString(4));
                product.setExpiry(rs.getInt(5 ));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection: " + e.getMessage());
            }
        }
        return product;
    }

   public Product updateProduct(String name, Product product) {
        String query = "UPDATE products SET type = ?, place = ?, expiry = ? WHERE name = ?";
        Product updatedProduct = null;
        con = db.getConnection();
        if (con == null) {
            System.out.println("Failed to update product: No active database connection.");
            return updatedProduct;
        }
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, product.getType());
            pstmt.setString(2, product.getPlace());
            pstmt.setInt(3, product.getExpiry());
            pstmt.setString(4, name);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                updatedProduct = product;
                System.out.println("Product updated successfully.");
            }
        } catch (SQLException e) {
            System.out.println("SQL error occurred: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection: " + e.getMessage());
            }
        }
        return updatedProduct;
    }

    public void deleteProduct(String name){
        String query = "DELETE FROM products WHERE name = ?";
        con = db.getConnection();
        if(con == null){
            System.out.println("Failed to fetch product: No active database connection.");
            return;
        }
        try {
           PreparedStatement pstmt = con.prepareStatement(query);
           pstmt.setString(1, name);
           int rowsAffected = pstmt.executeUpdate();
           if(rowsAffected > 0){
            System.out.println("product deleted successfully.");
           }else{
            System.out.println("No product found with the name: " + name);
           }

        } catch (SQLException e) {
            System.out.println("SQL error occurred: " + e.getMessage());
            e.printStackTrace();   
        }finally{
            try {
                if(con != null && !con.isClosed()){
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("failed to close the connection "+ e.getMessage());
            }
        }
    }
}

