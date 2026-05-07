package org.example.testdata.pojo;

public class Product {
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    String name;
    String price;
}
