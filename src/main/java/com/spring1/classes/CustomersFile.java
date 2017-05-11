package com.spring1.classes;

import com.spring1.Interfaces.Customers;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Michal on 19.04.2017.
 */
public class CustomersFile implements Customers {

    Set<Customer> customers = new TreeSet<>((c1, c2) -> c1.getSurname().compareTo(c2.getSurname()));


    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public static String[] readFile(String filename) {

        File file = new File("./src/main/resources/" + filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split(";");

                return arr;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public CustomersFile() {

        Set<Product> products1 = new HashSet<>();
        Set<Product> products2 = new HashSet<>();

        String[] a1 = readFile("product1");
        String[] a2 = readFile("product2");
        String[] a3 = readFile("product3");

        String[] ac1 = readFile("customer1");
        String[] ac2 = readFile("customer2");

        Product p1 = new Product(a1[0], Double.parseDouble(a1[1]), Integer.parseInt(a1[2]));
        Product p2 = new Product(a2[0], Double.parseDouble(a2[1]), Integer.parseInt(a2[2]));
        Product p3 = new Product(a3[0], Double.parseDouble(a3[1]), Integer.parseInt(a3[2]));


        Collections.addAll(products1, p1, p2);
        Collections.addAll(products2, p3, p2);

        Customer c1 = new Customer(ac1[0], ac1[1], Double.parseDouble(ac1[2]), products1);
        Customer c2 = new Customer(ac2[0], ac2[1], Double.parseDouble(ac2[2]), products2);

        Set<Customer> customers = new HashSet<>();

        Collections.addAll(customers, c1, c2);

        setCustomers(customers);

        customers.forEach(System.out::println);


    }

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

    @Override
    public String toString() {
        return "CustomersFile{" +
                "customers=" + customers +
                '}';
    }
}
