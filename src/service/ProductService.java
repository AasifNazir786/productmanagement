package service;

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

    public Product getProductByName(String name){

        return dao.getByName(name);

    }
}
