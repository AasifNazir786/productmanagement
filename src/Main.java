import java.sql.SQLException;
import java.util.List;

import model.Product;
import service.ProductService;

public class Main {
    public static void main(String[] args) throws SQLException {

        ProductService ps = new ProductService();
        
        // ps.addProduct(new Product("Blender", "Home Appliance", "Kitchen", 2026));
        // ps.addProduct(new Product("Vacuum Cleaner", "Home Appliance", "Storage Room", 2028));
        // ps.addProduct(new Product("Iron", "Home Appliance", "Laundry Room", 2024));
        // ps.addProduct(new Product("Printer", "Electronics", "Office", 2027));
        // ps.addProduct(new Product("Smart Lock", "Electronics", "Entrance", 2030));

        // ps.addProduct(new Product("Smartwatch", "Electronics", "Bedroom", 2027));
        // ps.addProduct(new Product("Bluetooth Speaker", "Electronics", "Living Room", 2023));
        // ps.addProduct(new Product("Gaming Console", "Electronics", "Living Room", 2029));
        // ps.addProduct(new Product("Camera", "Electronics", "Office", 2025));
        // ps.addProduct(new Product("Headphones", "Electronics", "Bedroom", 2024));
        
        System.out.println("========================================================================================");
        System.out.println("Fetching all the products from the database");
        System.out.println("========================================================================================");
        List<Product> products = ps.getAllProducts();
        for(Product product : products){
            System.out.println(product);
        }
        
        System.out.println("========================================================================================");
        System.out.println("Fetching a Product by Name");
        System.out.println("========================================================================================");
        Product p = ps.getProductByName("Iron");
        System.out.println(p);

        System.out.println("========================================================================================");
        System.out.println("update a Product by Name");
        System.out.println("========================================================================================");
        Product prod = new Product("Iron", "Electronics", "LivingRoom", 2024);
        String name = "Iron";
        Product pr = ps.updateProduct(name, prod);
        System.out.println(pr);

        System.out.println("========================================================================================");
        System.out.println("delete a Product by Name");
        System.out.println("========================================================================================");
        String name1 = "Blender";
        ps.deleteProduct(name1);


        System.out.println("========================================================================================");
        System.out.println("List of products after deletion");
        System.out.println("========================================================================================");
        List<Product> prods = ps.getAllProducts();
        for(Product product : prods){
            System.out.println(product);
        }
    }
}
