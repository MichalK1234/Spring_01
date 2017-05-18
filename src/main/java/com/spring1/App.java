package com.spring1;

import com.spring1.classes.Clerk;
import com.spring1.classes.ClerksSet;
import com.spring1.classes.Customer;
import com.spring1.classes.CustomersManual;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        //PROGRAM WYKONANY W RAMACH SZKOLENIA KM-PROGRAMS
        //http://km-programs.pl/


        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);


        CustomersManual customersManual = (CustomersManual) context.getBean("customersManual");
        System.out.println(customersManual);
        System.out.println(customersManual.findCustomerByCash(120));


        Clerk clerk1 = (Clerk) context.getBean("clerk1");
        System.out.println(clerk1);
        Clerk clerk2 = (Clerk) context.getBean("clerk2");
        System.out.println(clerk2);
        Clerk clerk3 = (Clerk) context.getBean("clerk3");
        System.out.println(clerk3);
        Clerk clerk4 = (Clerk) context.getBean("clerk4");
        System.out.println(clerk4);
        System.out.println(clerk1.carryOutTransaction() + "<++ transaction result");
        ClerksSet clerksSet = (ClerksSet) context.getBean("clerksSet");
        System.out.println(clerksSet);
        System.out.println(clerksSet.findClerkWithMaxDailyBalance());
        System.out.println(clerksSet.findClerkWithMinDailyBalance());
        System.out.println(clerksSet.soryByDailyBalanceAsc());
        System.out.println("==========================");
        System.out.println(clerksSet.upgradeClerks());
        System.out.println("==========================");
        context.close();


    }
}
