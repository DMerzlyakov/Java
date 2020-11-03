package com.task;


public class Smartphone {
    public double money;

    public Smartphone() {
        this.money = 0;
    }

    public void addmoney(double n, Atm t) {
        if (t.money < n) {
            System.out.println("Not enough money");
        } else {
        this.money += n; 
        t.money -= n;
        }
    }
}
