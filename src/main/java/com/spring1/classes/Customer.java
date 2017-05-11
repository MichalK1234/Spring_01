package com.spring1.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Michal on 19.04.2017.
 */
@Component
public class Customer {


    private String name;
    private String surname;
    private double cash;
    private Set<Product> basket;

    private static double discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Set<Product> getBasket() {
        return basket;
    }

    public void setBasket(Set<Product> basket) {

        Set<Product> productSet = new LinkedHashSet<>();

        double priceSum = 0;


        for (Product b : basket) {

            priceSum += b.getAmount() * b.getPrice();

            if (priceSum <= cash) {

                productSet.add(b);


            } else {

                priceSum -= b.getAmount() * b.getPrice();//jezeli poprzedni produktz listy byl za drogi to moze na nastepny bedzie klienta stac

            }

        }




     /* LinkedHashSet<Product> productSet1 = new LinkedHashSet<>(basket.stream().sorted((c1,c2) -> Double.compare(c1.getPrice(), c2.getPrice())).collect(Collectors.toList()));
        for (Product p : productSet1)
        {
            if (priceSum + p.getPrice() >= cash)
            {
                break;
            }
            priceSum += p.getPrice();
            productSet.add(p);
        }*/

        this.basket = productSet;
    }


    //wartosc ustalana z pliku properties
    public static double getDiscount() {
        return discount;
    }

    @Value("${discount}")
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Customer(String name, String surname, double cash, Set<Product> basket) {
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        setBasket(basket);
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cash=" + cash +
                ", basket=" + basket +
                '}';
    }

    public double calculateTotalPriceOfProducts() {


        double sum = 0;

        for (Product p : basket) {


            sum += p.getAmount() * p.getPrice();


        }

        return ((100 - discount) / 100) * sum;


    }

}
