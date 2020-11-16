package com.kontr;

public class task_3 {
    public static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double equation(double first, double second) {

        //Останавливаем рекусрию по нашему алгоритму
        if (second - first <= 0.001) {
            return first;
        }

        double x_middle = first + (second - first) / 2;  //Взял алгоритм деления отрезка пополам на cyclowiki.org

        if (f(first) * f(x_middle) < 0) {
            return equation(first, x_middle);
        } else {
            return equation(x_middle, second);
        }
    }

    public static void main() {
        System.out.println(equation(0, 10));
    }
}
