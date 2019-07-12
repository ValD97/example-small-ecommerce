package com.vdambrine.java.products.api;

import com.vdambrine.java.products.Product;
import com.vdambrine.java.products.spi.ProductRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;

import static java.math.BigDecimal.ZERO;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        if (product.getCode().isBlank()) {
            throw new IllegalArgumentException("A product needs a code !");
        }
        if (product.getPrice().compareTo(ZERO) <= 0) {
            throw new IllegalArgumentException("The price can't be lesser or equal to 0");
        }
        Option<Product> productById = productRepository.findByProductCode(product.getCode());
        if (productById.isDefined()) {
            throw new IllegalArgumentException("You can't create this product, the code '" + product.getCode() + "' already exists !");
        }
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(String productCode) {
        Product product = productRepository.findByProductCode(productCode)
                .getOrElseThrow(() -> new IllegalArgumentException("You can't delete a product which does not exist !"));
        return productRepository.delete(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Option<Product> findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }
}
