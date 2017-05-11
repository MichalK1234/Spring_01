package com.spring1;

import com.spring1.Interfaces.Customers;
import com.spring1.Interfaces.Transaction;
import com.spring1.classes.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Michal on 19.04.2017.
 */
@Configuration
@ComponentScan("com.spring1")
@PropertySource(value = {"discount.properties"})
@ImportResource("config.xml")
public class AppConfiguration {


    @Bean
    public Customers customers() {

        return new CustomersFile();
    }

    @Bean
    public Clerk clerk1() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Customers customers = (CustomersManual) context.getBean("customersManual");
        Transaction transaction = (TransactionAdvanced) context.getBean("transaction1");

        return new Clerk("Janek", "Dzbanek", 0, customers, transaction);
    }

    @Bean
    public Clerk clerk2() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Customers customers = (CustomersManual) context.getBean("customersManual");
        Transaction transaction = (TransactionOrdinary) context.getBean("transaction2");

        return new Clerk("Jurek", "Ogorek", 0, customers, transaction);
    }

    @Bean
    public Clerk clerk3() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Transaction transaction = (TransactionAdvanced) context.getBean("transaction1");

        return new Clerk("Ania", "Kowalska", 0, customers(), transaction);
    }

    @Bean
    public Clerk clerk4() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Transaction transaction = (TransactionOrdinary) context.getBean("transaction2");

        return new Clerk("Jan", "Janusz", 0, customers(), transaction);
    }

    @Bean
    public ClerksSet clerksSet() {

        List<Clerk> clerks = new ArrayList<>();
        Collections.addAll(clerks, clerk1(), clerk2(), clerk3(), clerk4());

        return new ClerksSet(clerks);
    }
}
