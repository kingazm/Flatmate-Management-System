package com.kingazm.com.flatmate.system;

public class ShoppingItem {

    private String name;
    private int amount;

    private String destination; //personal or shared shopping list

    ShoppingItem(){
        this.name = "None";
        this.amount = 0;
        this.destination = "None";
    }

    ShoppingItem(String name, int amount){
        this.name = name;
        this.amount = amount;
        this.destination = "Not disclosed";
    }

    ShoppingItem(String name, int amount, String destination){
        this.name = name;
        this.amount = amount;
        this.destination = destination;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString(){
        return (this.name + " : (" + this.amount + ")");
    }

}
