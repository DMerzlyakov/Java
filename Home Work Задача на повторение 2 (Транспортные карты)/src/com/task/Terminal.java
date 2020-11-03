package com.task;
import java.util.*;

public class Terminal {
    public int numbers;
    public double money;
    public int people;

    public Terminal() {
        this.numbers = 0;
        this.money = 0;
        this.people = 0;
    }

    public void put(Card card) {
        Date date = new Date();
        if (card.month) {
            System.out.println("Open");
        } else {
            card.month = false;
            if (card.numbers > 0) {
                card.numbers -= 1;
                System.out.println("Open");
            } else if (card.money >= 60) {
                card.money -= 60;
                System.out.println("Open");
            } else {
                System.out.println("Not enough money");
            }
        }
    }
}
