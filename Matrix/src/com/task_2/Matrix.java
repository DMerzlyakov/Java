package com.task_2;

import java.util.Scanner;

public class Matrix {

    private int rows, cols;
    int[][] matrix;
    Scanner in = new Scanner(System.in);
    static Matrix matrix_new;


    Matrix(int ...rows_and_cols) {
        if (rows_and_cols.length == 0) {
            System.out.println("Введите количетсво строк в матрице:");
            rows = in.nextInt();
            System.out.println("Введите количетсво столбцов в матрице:");
            cols = in.nextInt();
            in.nextLine();
            create_Matrix_by_in();
        }
        else {
            rows = rows_and_cols[0];
            cols = rows_and_cols[1];
            matrix = new int[rows][cols];
        }


    }

    private void create_Matrix_by_in() {
        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.out.println("Введите " + (i+1) + " строку через пробел:");
            String str = in.nextLine();
            matrix[i] = str_to_int(str.split(" "));

        }
    }

    public void addLine_to_Matrix(int numb_line, int[] line) {
        matrix[numb_line] = line;
    }


    private int[] str_to_int(String[] str) {
        int[] _rows = new int[cols];
        for (int i = 0; i < cols; i++) {
            _rows[i] = Integer.parseInt(str[i]);
        }
        return _rows;
    }

    public int getRows() {
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public int getElem(int r, int c) {
        return matrix[r][c];
    }

    public void showMatrix() {
        System.out.println("\nОтвет:");
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                System.out.print('/');
            }
            else if (i == rows - 1) {
                System.out.print("\\");
            }
            else {
                System.out.print("|");
            }
            for (int j = 0; j < cols-1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print(matrix[i][matrix[i].length-1]);
            if (i == 0) {
                System.out.println('\\');
            }
            else if (i == rows - 1) {
                System.out.println("/");
            }
            else {
                System.out.println("|");
            }
        }
    }
}

