package com.task_3;

import java.util.ArrayList;

import java.util.LinkedList;

public class task_2 {

    public static void compare() {

        ArrayList<Double> array = new ArrayList<>();
        LinkedList<Double> linked = new LinkedList<>();
        int N = 1000000;
        int takeN = 100000;
        for (int i = 0; i < N; i++) {
            array.add(Math.random());
            linked.add(Math.random());
        }

        //Время arrayList
        long startArray = System.currentTimeMillis();
        for (int i = 0; i < takeN; i++) {
            System.out.println(i);
            array.get((int) (Math.random() * (N - 1)));
        }
        long timeArray = System.currentTimeMillis() - startArray;
        System.out.println("arrayList время = " + timeArray);

        //Время linkedList
        long startLinked = System.currentTimeMillis();
        for (int i = 0; i < takeN; i++) {
            linked.get((int) (Math.random() * (N - 1)));
        }
        long timeLinked = System.currentTimeMillis() - startLinked;
        System.out.println("linkedList время = " + timeLinked);

        // Сравнение
        // arrayList намного быстрее
        if (timeArray > timeLinked) {
            System.out.println("linkedList быстрее на =>" + (timeArray - timeLinked));
        } else if (timeArray == timeLinked) {
            System.out.println("Время выполнения равно");
        } else {
            System.out.println("arrayList быстрее на =>" + (timeLinked - timeArray));
        }
    }
}
