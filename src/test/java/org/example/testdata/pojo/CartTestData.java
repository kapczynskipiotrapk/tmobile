package org.example.testdata.pojo;


import java.util.ArrayList;
import java.util.List;

public class CartTestData {

    public static List<Product> productsInCart = new ArrayList<>();

    public static void addProductToCartTestData(Product product) {
        productsInCart.add(product);
        System.out.println("Dodano do koszyka produkt " + product.getName());
    }
    
    public static Product getProductByName(String name){
        return productsInCart.stream().filter(k -> k.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalStateException("Product not exist in cart test data"));
    }
}
