package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public interface InfoService {
    void inform(User user, LocalDateTime orderTime, Supplier supplier);
//    default void emailContents(User user, LocalDateTime orderTime, Supplier supplier){
//        System.out.println("This is MailService from " + supplier.getName());
//        System.out.println("Buyer: " + user.getName() + " " + user.getLastName());
//        System.out.println("Product: " + supplier.getQuantity() + " of " + supplier.getProduct() );
//    }
}
