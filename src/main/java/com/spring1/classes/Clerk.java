package com.spring1.classes;

import com.spring1.Interfaces.Customers;
import com.spring1.Interfaces.Transaction;


/**
 * Created by Michal on 10.05.2017.
 */

public class Clerk {


    private String name;
    private String surname;
    private double dailyBalance;
    private Customers customers;
    private Transaction transaction;

    public Clerk(String name, String surname, double dailyBalance, Customers customers, Transaction transaction) {
        this.name = name;
        this.surname = surname;
        this.dailyBalance = dailyBalance;
        this.customers = customers;
        this.transaction = transaction;
    }

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

    public double getDailyBalance() {
        return dailyBalance;
    }

    public void setDailyBalance(double dailyBalance) {
        this.dailyBalance = dailyBalance;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public double carryOutTransaction() {

        return transaction.payment(customers);

    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dailyBalance=" + dailyBalance +
                ", customers=" + customers +
                ", transaction=" + transaction +
                '}';
    }
}
