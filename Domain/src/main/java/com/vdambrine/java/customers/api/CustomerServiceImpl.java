package com.vdambrine.java.customers.api;

import com.vdambrine.java.customers.Customer;
import com.vdambrine.java.customers.spi.CustomerRepository;
import com.vdambrine.java.products.Product;
import com.vdambrine.java.products.spi.ProductRepository;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;

import static io.vavr.API.List;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Override
    public Option<Customer> findCustomer(String login) {
        return customerRepository.findByLogin(login);
    }

    @Override
    public Customer signUp(String login) {
        if (login.isBlank()) {
            throw new IllegalArgumentException("Customer's login can't be empty !");
        }
        if (customerRepository.findByLogin(login).isDefined()) {
            throw new IllegalArgumentException("This login already exists !");
        }
        return customerRepository.save(new Customer().withLogin(login));
    }

    @Override
    public Customer fillProductInCart(String login, String productCode) {
        Customer customer = customerRepository.findByLogin(login)
                .getOrElseThrow(() -> new IllegalArgumentException("The customer doesn't exist !"));
        Product product = productRepository.findByProductCode(productCode).getOrElseThrow(() -> new IllegalArgumentException("You can't add an unknown product !"));

        Customer customerToUpdate = customer.withCart(customer.getCart().append(product));
        return customerRepository.save(customerToUpdate);
    }

    @Override
    public Customer emptyCart(String login) {
        Customer customerToUpdate = customerRepository.findByLogin(login)
                .map(customer -> customer.withCart(List()))
                .getOrElseThrow(() -> new IllegalArgumentException("The customer doesn't exist !"));

        return customerRepository.save(customerToUpdate);
    }
}
