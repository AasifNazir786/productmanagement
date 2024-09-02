package service;

import dao.ProductDao;
import model.Product;

public class ProductService {
    
    ProductDao dao = new ProductDao();

    public void addProduct(Product p){
        dao.save(p);
    } 
}
