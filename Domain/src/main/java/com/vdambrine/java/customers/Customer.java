package com.vdambrine.java.customers;

import com.vdambrine.java.products.Product;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.UUID;

import static io.vavr.API.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Wither
public class Customer {

    private UUID id = UUID.randomUUID();
    private String login = "";
    private List<Product> cart = List();
}
