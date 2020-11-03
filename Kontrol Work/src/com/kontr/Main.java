package com.kontr;
import java.util.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Food f1 = new Food("Картофель-Фри", 55, 8, new HashSet<>(Arrays.asList("Картофель", "Соль")),
                "Грамм", 150);
        Food f2 = new Food("Картофель по деревенски", 65, 5,
                new HashSet<>(Arrays.asList("Картофель", "Соль", "Специи")),
                "Грамм", 150);
        Food f3 = new Food("Летний салат", 100, 6,
                new HashSet<>(Arrays.asList("Помидоры", "Огурцы")),
                "Грамм", 210);
        Drinks f4 = new Drinks("Lipton", 15, 0,
                new HashSet<>(Collections.singletonList("Lipton")),
                "Мл", 210);

        Menu.printMenu();

        System.out.println("------------");

        Order test = new Order(5);

        test.addProduct("Lipton");
        test.addProduct("Картофель по деревенски");
        test.addProduct("Картофель-Фри");
        test.addProduct("Летний салат");
        test.addProduct("Салат Цезарь");

        System.out.println("------------");
        test.printOrder();
        System.out.println(test.getOrderSum());

        System.out.println("------------");
        test.closeTable();

        System.out.println("Меню:");
        Menu.printMenu();

        System.out.println("Стоп Лист:");
        Menu.printStopList();

        Menu.addCount("Lipton", 20);


        System.out.println("------------");
        Menu.printMenu();

        System.out.println("------------");
        Menu.printStopList();
    }
}