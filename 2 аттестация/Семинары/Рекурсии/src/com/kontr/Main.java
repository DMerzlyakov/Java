package com.kontr;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
//        System.out.println(factorial(3));
//        task_2();
        task_3.main();
        Task_4.main();
    }

    //Task 1
    public static int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        return factorial(x-1)*x;
        }


        //Task 2
    public static void task_2() {
        int[] list = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            list[i] = (int) (Math.random()*1000);
        }
        long startBinary = System.currentTimeMillis();
        int searchBinary = Arrays.binarySearch(list, 50);
        long timeBinary = System.currentTimeMillis() - startBinary;
        long startDefault = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            if (list[i] == 50) {
                int searchDefault = i;
                break;
            }
        }
        System.out.println(searchBinary);

        long timeDefault = System.currentTimeMillis() - startDefault;
        System.out.println(timeBinary + " = Бинарный");
        System.out.println(timeDefault + " = Default");
    }

}
