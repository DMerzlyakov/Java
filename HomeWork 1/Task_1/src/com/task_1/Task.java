package com.task_1;

import org.w3c.dom.ls.LSOutput;

public class Task {

    public static void task_1() {
        System.out.println("Task 1: Hello world");
    }

    public static void task_2() {
        int a = 9999999;
        System.out.println("Task 2: " + a);
    }

    public static void task_3() {
        int a = 5;
        a++;
        a += 1;
        System.out.println("Task 3: " + a);
    }
    public static void task_4() {
        int a = 3;
        int b = 5;
//        a = a + b - (b = a);
        int c = a;
        a = b;
        b = c;
        System.out.println("Task 4: " + a +" "+ b);
    }

    public static void task_5() {
        int a = 3;
        int b = 4;
        System.out.println("Task 5: "+ Math.sqrt(Math.pow((double) a, (double) 2) +
                + Math.pow((double) b, (double) 2)));
    }

    public static void task_6() {
        int a = 12345;
        System.out.println("Task 6: " + (a%=10));
    }

    public static void task_7() {
        int a =432567;
        System.out.println("Task 7: " + (a / 10) % 10);
    }

    public static void task_8() {
        int a = -13;
        System.out.println("Task 8: " + (a / -10) % 10);
    }

    public static void task_9(int[] a) {
        int b = 21;
        System.out.println("Task 9:");
        for (int i: a) {
            System.out.println("Разница между " + i + " и " + b +" = " + Math.abs(b-i));
        }
    }

    public static void task_10(int a, int b) {
        System.out.println("Task 10: \nСреднее арифметическое между " + a + " и " + b +" = " + (a + b)/ 2.0 );
    }


    public static void task_11(int a, int b) {
        System.out.println("Task 11:\nСреднее геометрическое между " + a + " и " + b +" = " + Math.sqrt(a * b));
    }

    public static void task_12(float a_x, float a_y, float b_x, float b_y) {
        double len = Math.sqrt((Math.pow((double)(b_x-a_x),2.0) + Math.pow((double) (b_y - a_y), 2.0)));
        System.out.println("Task 12:\nРасстояние = " + len);
    }
}
