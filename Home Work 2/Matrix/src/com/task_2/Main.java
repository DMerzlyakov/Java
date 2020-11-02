package com.task_2;

import java.util.Scanner;

public class Main {

    static int operat;
    static Matrix matrix_1, matrix_2, answer_matrix;
    static Calculator calc;


    public static void main(String[] args) {
        System.out.println("Выберите операцию: ");
        System.out.println("1 - Сложение матриц");
        System.out.println("2 - Вычитание матриц");
        System.out.println("3 - Умножение матрицы на число");
        System.out.println("4 - Произведение двух матриц");
        System.out.println("5 - Транспонированная матрица");
        System.out.println("6 - Возведение матрицы в степень");
        System.out.print("Введите числовое значени:");
        Scanner in = new Scanner(System.in);
        operat = in.nextInt();
        switch (operat) {
            case 1:
                matrix_1 = new Matrix();
                matrix_2 = new Matrix();
                if (matrix_1.getRows() == matrix_2.getRows() && matrix_1.getCols() == matrix_2.getCols()) {
                    answer_matrix = calc.sumMatrix(matrix_1, matrix_2);
                    answer_matrix.showMatrix();
                } else {
                    System.out.println("Не возможно выполнить сложение");
                }
                break;
            case 2:
                matrix_1 = new Matrix();
                matrix_2 = new Matrix();
                if (matrix_1.getRows() == matrix_2.getRows() && matrix_1.getCols() == matrix_2.getCols()) {
                    answer_matrix = calc.minMatrix(matrix_1, matrix_2);
                    answer_matrix.showMatrix();
                } else {
                    System.out.println("Не возможно выполнить сложение");
                }
                break;
            case 3:
                matrix_1 = new Matrix();
                System.out.print("Введите число для умножения: ");
                answer_matrix = calc.multMatrix_to_ch(matrix_1, in.nextInt());
                answer_matrix.showMatrix();
                break;
            case 4:
                matrix_1 = new Matrix();
                matrix_2 = new Matrix();
                if (matrix_1.getCols() == matrix_2.getRows()) {
                    answer_matrix = calc.multMatrix_to_Matrix(matrix_1, matrix_2);
                    answer_matrix.showMatrix();
                } else {
                    System.out.println("Невозможно выполнить операцию");
                }
                break;
            case 5:
                matrix_1 = new Matrix();
                answer_matrix = calc.transMatrix(matrix_1);
                answer_matrix.showMatrix();
                break;
            case 6:
                matrix_1 = new Matrix();
                answer_matrix = calc.multMatrix_to_Matrix(matrix_1, matrix_1);
                answer_matrix.showMatrix();
                break;
        }

    }
}

