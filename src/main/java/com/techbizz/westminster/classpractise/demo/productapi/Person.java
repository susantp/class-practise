package com.techbizz.westminster.classpractise.demo.productapi;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private Date birthDate;

    String getName(){
        return this.name;
    }
//    public String buysProduct(Product product){
//        return this.name + " buys " + product.getName() + " amount total: " + product.calculateTotal();
//    }
}
