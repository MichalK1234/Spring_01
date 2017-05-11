package com.spring1.classes;

import com.spring1.Interfaces.Customers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Michal on 19.04.2017.
 */
public class CustomersManual implements Customers {


    private Set<Customer> customers = new TreeSet<>((c1, c2) -> Double.compare(c1.calculateTotalPriceOfProducts(), c2.calculateTotalPriceOfProducts()));


    @Override
    public void addCustomer(Customer c) {

        customers.add(c);

    }

    @Override
    public void removeCustomer(Customer c) {

        customers.remove(c);

    }

    @Override
    public Customer findCustomerByName(String name) {


        if (customers.stream().filter(c -> c.getName().equals(name)).findFirst().isPresent()) {

            return customers.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }

        return null;


    }

    @Override
    public Customer findCustomerBySurname(String surname) {

        if (customers.stream().filter(c -> c.getSurname().equals(surname)).findFirst().isPresent()) {

            return customers.stream().filter(c -> c.getSurname().equals(surname)).findFirst().get();
        }


        return null;
    }

    @Override
    public Customer findCustomerByCash(double cash) {

        if (customers.stream().filter(c -> c.getCash() >= 0).findFirst().isPresent()) {

            return customers.stream().filter(c -> c.getCash() >= 0).findFirst().get();
        }

        return null;
    }

    @Override
    public List<Customer> sortCustmersByName() {

        return customers.stream().sorted((c1, c2) -> c2.getName().compareTo(c1.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortCustmersBySurname() {
        return customers.stream().sorted((c1, c2) -> c2.getSurname().compareTo(c1.getSurname())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortCustmersByCash() {

        return customers.stream().sorted((c1, c2) -> Double.compare(c2.getCash(), c1.getCash())).collect(Collectors.toList());
    }

    @Override
    public double calculateBasketValue() {


        return customers.stream().collect(Collectors.summarizingDouble(c -> c.calculateTotalPriceOfProducts())).getSum();


    }

    public CustomersManual(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomersManual{" +
                "customers=" + customers +
                '}';
    }
}
