package com.kontr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Menu {

    String name;
    double price;
    int count;
    HashSet<String> components;
    String typeWeight;
    double weight;
    static HashMap<String, Menu> stopListed = new HashMap<>();
    static ArrayList<Menu> menu = new ArrayList<>();
    static HashMap<String, Menu> menuWithName = new HashMap<>();

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setComponents(HashSet<String> consistency) {
        this.components = components;
    }
    public void setTypeWeight(String type) {
        this.typeWeight = type;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void addCount(String name, int count) {
        if (Menu.menuWithName.containsKey(name)) {
            Menu.menuWithName.get(name).setCount(Menu.menuWithName.get(name).count + count);
            Menu.stopListed.remove(name);
        }
    }

    @Override
    public String toString() {
        return "Меню{" +
                "Название ='" + name + '\'' +
                ", Цена =" + price + "Руб." +
                ", Количество =" + count +
                ", Состав =" + components +
                ", вес =" + weight + " "+ typeWeight +
                '}';
    }

    public static void printMenu() {
        for (Menu product : menu) {
            System.out.println(product.toString());
        }
    }

    public static void printStopList() {
        for (String product: stopListed.keySet()) {
            System.out.println(stopListed.get(product));
        }
    }
}

