package org.example.testdata;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.testdata.pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductPageTestData {

    public static List<Product> productsTestData = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger();


    public static void saveProductData(String productName, String productPrice) {
        Product product = new Product(productName, productPrice);
        productsTestData.add(product);
        logger.info("+ productName" + "added to productsTestData collector list");
    }

    public static Product getProductByName(String name) {
        return productsTestData.stream().filter(k -> k.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalStateException("Product not exist in product page test data"));
    }
}
