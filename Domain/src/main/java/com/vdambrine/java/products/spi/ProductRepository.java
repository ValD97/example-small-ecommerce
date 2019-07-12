package com.vdambrine.java.products.spi;

import com.vdambrine.java.products.Product;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface ProductRepository {
    Option<Product> findByProductCode(String productCode);

    Product save(Product product);

    Product delete(Product product);

    List<Product> findAll();
}
