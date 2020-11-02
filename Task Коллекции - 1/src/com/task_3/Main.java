package com.task_3;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        // Task 1
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(1);
        System.out.println(ar.size());
        Collection<Integer> coll = task_1.removeDuplicates(ar);
        System.out.println(coll.size());

        // Task2
//        task_2.compare();

        //task_3
        Task_3.buildCountDictionary("явврррряяяаааяяяяяяяяяффффффаааа");
    }
}
