package com.vect;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Vector vect, vect_2, answer_2;
    static double answer;
    static int N;

    public static void main(String[] args) {
        System.out.println("Выберите операцию из списка:");
        System.out.println("1 - Вычислить длину вектора");
        System.out.println("2 - Вычислить скалярное произведение");
        System.out.println("3 - Вычислить векторное произведение");
        System.out.println("4 - Вычислить угол между векторами");
        System.out.println("5 - Вычислить сумму векторов");
        System.out.println("6 - Вычислить разность векторов");
        System.out.println("7 - Создать массив векторов длиной N");
        System.out.print("Введите число: ");
        switch (in.nextInt()) {
            case 1:
                System.out.println("Задайте вектор");
                vect = new Vector();
                answer = vect.lenVect();
                System.out.println("Длина = " + answer);
                break;
            case 2:
                System.out.println("Задайте первый вектор");
                vect = new Vector();
                System.out.println("Задайте второй вектор");
                vect_2 = new Vector();
                answer = vect.scalVect(vect_2);
                System.out.println("Скалярное произведение: " + answer);
                break;
            case 3:
                System.out.println("Задайте первый вектор");
                vect = new Vector();
                System.out.println("Задайте второй вектор");
                vect_2 = new Vector();
                answer_2 = vect.multVect_to_Vect(vect_2);
                answer_2.showVect();
                break;
            case 4:
                System.out.println("Задайте первый вектор");
                vect = new Vector();
                System.out.println("Задайте второй вектор");
                vect_2 = new Vector();
                answer = vect.angleVect_to_Vect(vect, vect_2);
                System.out.println("Угол = " + answer);
                break;
            case 5:
                System.out.println("Задайте первый вектор");
                vect = new Vector();
                System.out.println("Задайте второй вектор");
                vect_2 = new Vector();
                answer_2 = vect.sumVect_to_Vect(vect_2);
                System.out.println("Полученный вектор:");
                answer_2.showVect();
                break;
            case 6:
                System.out.println("Задайте первый вектор");
                vect = new Vector();
                System.out.println("Задайте второй вектор");
                vect_2 = new Vector();
                answer_2 = vect.minusVect_to_Vect(vect_2);
                System.out.println("Полученный вектор:");
                answer_2.showVect();
                break;
            case 7:
                System.out.print("Введите необходимое кол-во веторов: ");
                N = in.nextInt();
                Vector[] answer_3 = Vector.getRandVect(N);
                for (Vector i: answer_3) {
                    i.showVect();
                }
                break;
        }
        }
}
