package com.techbizz.westminster.classpractise.demo.products;

public class Address {
    int id;
    String city;
    String province;
    String country;

    Address(int id, String city, String province, String country){
        this.id = id;
        this.city = city;
        this.province = province;
        this.country = country;
    }
    public String getFullAddress(){
        return String.join(",", this.city, this.province, this.country);
    }
}
