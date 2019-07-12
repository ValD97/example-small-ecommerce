package com.vdambrine.java.customers.spi;

import com.vdambrine.java.customers.Customer;
import io.vavr.control.Option;

public interface CustomerRepository {

    Customer save(Customer customer);

    Option<Customer> findByLogin(String login);
}
