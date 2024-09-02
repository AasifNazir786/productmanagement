package model;

public class Product {
    private String name;
    private String type;
    private String place;
    private int expiry;

    public Product() {}
    
    public Product(String name, String type, String place, int expiry) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", type=" + type + ", place=" + place + ", expiry=" + expiry + "]";
    } 
    
}
