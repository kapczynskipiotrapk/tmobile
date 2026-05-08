package org.example.testdata;


import org.example.testdata.pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductPageTestData {

    public static List<Product> productsTestData = new ArrayList<>();

    public static void saveProductData(String productName, String productPrice) {
        Product product = new Product(productName, productPrice);
        productsTestData.add(product);
        System.out.println("[INFO] Product " + productName + " added to productsTestData collector list");}

    public static Product getProductByName(String name) {
        return productsTestData.stream().filter(k -> k.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalStateException("Product not exist in product page test data"));
    }
}
