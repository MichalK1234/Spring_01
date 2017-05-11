package com.spring1.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Michal on 10.05.2017.
 */
public class ClerksSet {

    private List<Clerk> clerkList = new ArrayList<>();

    public void addClerk(Clerk clerk) {

        clerkList.add(clerk);

    }

    public List<Clerk> upgradeClerks() {


        clerkList.stream().forEach(c -> {
            c.setDailyBalance(c.getDailyBalance() + c.getTransaction().payment(c.getCustomers()));
        });


        return clerkList;

    }

    public List<Clerk> findClerkWithMaxDailyBalance() {

        Clerk clerkWithMaxBalance = clerkList.stream().sorted((c1, c2) -> Double.compare(c2.getDailyBalance(), c1.getDailyBalance())).findFirst().get();

        List<Clerk> max = new ArrayList<>();

        for (Clerk clerk : clerkList) {

            if (clerkWithMaxBalance.getDailyBalance() == clerk.getDailyBalance()) {

                max.add(clerk);
            }


        }
        return max;//bo moze byc wiecej niz jeden sprzedawca z takim balansem

    }

    public List<Clerk> findClerkWithMinDailyBalance() {

        Clerk clerkWithMinBalance = clerkList.stream().sorted((c1, c2) -> Double.compare(c1.getDailyBalance(), c2.getDailyBalance())).findFirst().get();

        List<Clerk> min = new ArrayList<>();

        for (Clerk clerk : clerkList) {

            if (clerkWithMinBalance.getDailyBalance() == clerk.getDailyBalance()) {

                min.add(clerk);
            }


        }
        return min;//bo moze byc wiecej niz jeden sprzedawca z takim balansem

    }

    public List<Clerk> soryByDailyBalanceDsc() {//malejaco

        return clerkList.stream().sorted((c1, c2) -> Double.compare(c2.getDailyBalance(), c1.getDailyBalance())).collect(Collectors.toList());

    }

    public List<Clerk> soryByDailyBalanceAsc() {//rosnaco

        return clerkList.stream().sorted((c1, c2) -> Double.compare(c1.getDailyBalance(), c2.getDailyBalance())).collect(Collectors.toList());

    }


    public ClerksSet(List<Clerk> clerkList) {
        this.clerkList = clerkList;
    }

    @Override
    public String toString() {
        return "ClerksSet{" +
                "clerkList=" + clerkList +
                '}';
    }
}
