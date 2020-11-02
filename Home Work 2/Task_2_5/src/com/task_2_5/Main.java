package com.task_2_5;

public class Main {

    public static void main(String[] args) {

        int[] values = {1, 2, 3};
        int[] weights = {1, 2, 10};

        Random returner = new Random(values, weights);
        int returnValue = returner.getNumber();
        System.out.println("Возвращенное значение: "+returnValue);
    }

}