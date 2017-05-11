package com.spring1.classes;

import com.spring1.Interfaces.Customers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 10.05.2017.
 */
public class TransactionAdvanced extends TransactionOrdinary {


    @Override
    public double payment(Customers customers) {

        double basePrice = super.payment(customers);
        if (basePrice > 1000) {

            return 1.05 * basePrice;

        }
        return super.payment(customers);
    }

    @Override
    public String toString() {
        return "TransactionAdvanced{}";
    }
}
