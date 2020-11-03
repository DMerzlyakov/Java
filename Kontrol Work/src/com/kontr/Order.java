package com.kontr;
import java.util.*;

public class Order {

    int table;
    double orderSum;
    ArrayList<Menu> order = new ArrayList<>();

    public Order(int table) { this.table = table; }

    public void addProduct(String name) {
        if (Menu.menuWithName.containsKey(name)) {
            if (Menu.menuWithName.get(name).count == 0) {
                System.out.println(name +  " - данный продукт закончился");
            } else {
                Menu.menuWithName.get(name).setCount(Menu.menuWithName.get(name).count - 1);
                setOrderSum(Menu.menuWithName.get(name).price);
                order.add(Menu.menuWithName.get(name));
                System.out.println(name + " - Этот продукт был добавлен в ваш заказ");
            }
        } else
            System.out.println(name + " - данного продукта нет в нашем меню");
    }

    public void printOrder() {
        System.out.println("Номер стола: " + table);
        for (Menu value : order) {
            System.out.println(value.toString());
        }
    }

    public void closeTable() {
        order.clear();
        setOrderSum(0);
        System.out.println("Стол номер " + table + " закрыт");
    }

    public void setOrderSum(double orderSum) {
        this.orderSum += orderSum;
    }

    public double getOrderSum() {
        return orderSum;
    }
}
