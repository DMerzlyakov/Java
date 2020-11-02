package com.task_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Task.task_1();
        Task.task_2();
        Task.task_3();
        Task.task_4();
        Task.task_5();
        Task.task_6();
        Task.task_7();
        Task.task_8();
        Task.task_9(new int[] {3, 5, 10, 31});
        Task.task_10(3, 8);
        Task.task_11(3, 7);
        Task.task_12(1.0f,1.0f,4.0f, 5.0f );
        System.out.println("Введите " + " строку через пробел:");
        String str = in.nextLine();
        System.out.println(str);
    }
}
