package com.spring1.Interfaces;

import com.spring1.classes.Customer;

import java.util.List;

/**
 * Created by Michal on 19.04.2017.
 */
public interface Customers {

    public void addCustomer(Customer c);

    public void removeCustomer(Customer c);

    public Customer findCustomerByName(String name);

    public Customer findCustomerBySurname(String surname);

    public Customer findCustomerByCash(double cash);

    public List<Customer> sortCustmersByName();

    public List<Customer> sortCustmersBySurname();

    public List<Customer> sortCustmersByCash();

    public double calculateBasketValue();


}
