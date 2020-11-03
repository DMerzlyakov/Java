package com.kontr;
import java.util.*;
public class Food extends Menu {

    public Food(String name, double price, int count, HashSet<String> components, String typeWeight, double weight) {

        this.name = name;
        this.price = price;
        this.count = count;
        this.components = components;
        this.typeWeight = typeWeight;
        this.weight = weight;
        menu.add(this);
        menuWithName.put(name, this);

        if (count == 0)
            stopListed.put(name, this);
    }
}
