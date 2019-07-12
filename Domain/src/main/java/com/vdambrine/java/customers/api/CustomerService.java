package com.vdambrine.java.customers.api;

import com.vdambrine.java.customers.Customer;
import io.vavr.control.Option;

public interface CustomerService {

    Customer signUp(String login);

    Option<Customer> findCustomer(String login);

    Customer fillProductInCart(String login, String productCode);

    Customer emptyCart(String login);
}
