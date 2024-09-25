package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import model.Product;

public class ProductService {
    
    ProductDao dao = new ProductDao();

    public void addProduct(Product p){
        dao.save(p);
    } 
    public List<Product> getAllProducts() {

       return dao.getAll();
    }

    public Product getProductByName(String name)throws SQLException{

        return dao.getByName(name);
    }
    public Product updateProduct(String name, Product product){
        return dao.updateProduct(name, product);
    }

    public void deleteProduct(String name){
        if(name == null || name == ""){
            System.out.println("can't delete a product please enter a valid name");
            return;
        }
        dao.deleteProduct(name);
    }
}
