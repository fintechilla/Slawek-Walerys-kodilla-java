package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public class MailService implements InfoService{
    public MailService() {
    }
    public void sendEmail(User user, LocalDateTime orderTime, Supplier supplier){

    }
    public void inform(User user, LocalDateTime orderTime, Supplier supplier){
        System.out.println("This is MailService for " + supplier.getName());
        System.out.println("Buyer: " + user.getName() + " " + user.getLastName());
        System.out.println("Product: " + supplier.getQuantity() + " of " + supplier.getProduct()
                + ". Order from supplier: " + supplier.getName());


    }
}
