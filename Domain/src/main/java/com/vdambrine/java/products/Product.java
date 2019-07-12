package com.vdambrine.java.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String code = "";
    private String label = "";
    private BigDecimal price = BigDecimal.ZERO;
}
