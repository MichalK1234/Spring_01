package com.spring1.classes;

import com.spring1.Interfaces.Customers;
import com.spring1.Interfaces.Transaction;

/**
 * Created by Michal on 20.04.2017.
 */
public class TransactionOrdinary implements Transaction {
    @Override
    public double payment(Customers customers) {


        return customers.calculateBasketValue();
    }

    @Override
    public String toString() {
        return "TransactionOrdinary{}";
    }
}
