package com.vdambrine.java.products.api;

import com.vdambrine.java.products.Product;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface ProductService {

    Product createProduct(Product product);

    Product deleteProduct(String productCode);

    List<Product> getAllProducts();

    Option<Product> findByProductCode(String productCode);
}
