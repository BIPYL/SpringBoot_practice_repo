package com.example.LeeDowon.FinalProject.entity;



public class CarDAO {
    private static int carCountr = 1;
    private final int Id;
    private String name;
    private double price;
    private String owner;
    private int year;


    public CarDAO(String name, double price, String owner, int year) {
        this.Id = carCountr++;
        setName(name);
        setPrice(price);
        setOwner(owner);
        setYear(year);
    }


    //Setter
    public void setName(String name) {
        if (!name.isEmpty() & !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }
    public void setOwner(String owner) {
        if (!owner.isEmpty() && !owner.trim().isEmpty()) {
            this.owner = owner;
        }
    }
    public void setYear(int year) {
        if (year > 1950) {
            this.year = year;
        }
    }

    //Getter
    public long getId (){
        return Id;
    }
    public String getName (){
        return name;
    }
    public double getPrice (){
        return price;
    }
    public String getOwner(){
        return owner;
    }
    public int getYear(){
        return year;
    }






}

