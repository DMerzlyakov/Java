package com.kontr;
import java.util.*;

public class Drinks extends Menu {
    public Drinks(String name, double price, int count, HashSet<String> component, String typeWeight, double weight) {

        if (count == 0) {stopListed.put(name, this);}

        this.name = name;
        this.price = price;
        this.count = count;
        this.components = component;
        this.typeWeight = typeWeight;
        this.weight = weight;
        menu.add(this);
        menuWithName.put(name, this);
    }
}
