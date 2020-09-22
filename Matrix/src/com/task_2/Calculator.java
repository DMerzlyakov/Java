package com.task_2;

public class Calculator {

    static Matrix matrix_new;

    public static Matrix sumMatrix(Matrix matrix_1, Matrix matrix_2) {
        matrix_new = new Matrix(matrix_1.getRows(),matrix_1.getCols());
        for (int i = 0; i < matrix_1.getRows(); i++) {
            int[] line = new int[matrix_1.getCols()];
            for (int j = 0; j < matrix_1.getCols(); j ++) {
                line[j] = matrix_1.getElem(i, j) + matrix_2.getElem(i, j);
            }
            matrix_new.addLine_to_Matrix(i, line);
        }
        return matrix_new;
    }
    public static Matrix minMatrix(Matrix matrix_1, Matrix matrix_2) {
        matrix_new = new Matrix(matrix_1.getRows(),matrix_1.getCols());
        for (int i = 0; i < matrix_1.getRows(); i++) {
            int[] line = new int[matrix_1.getCols()];
            for (int j = 0; j < matrix_1.getCols(); j ++) {
                line[j] = matrix_1.getElem(i, j) - matrix_2.getElem(i, j);
            }
            matrix_new.addLine_to_Matrix(i, line);
        }
        return matrix_new;
    }

    public static Matrix multMatrix_to_ch(Matrix matrix_1,int number) {
        matrix_new = new Matrix(matrix_1.getRows(),matrix_1.getCols());
        for (int i = 0; i < matrix_1.getRows(); i++) {
            int[] line = new int[matrix_1.getCols()];
            for (int j = 0; j < matrix_1.getCols(); j ++) {
                line[j] = matrix_1.getElem(i, j) * number;
            }
            matrix_new.addLine_to_Matrix(i, line);
        }
        return matrix_new;
    }

    public static Matrix multMatrix_to_Matrix(Matrix matrix_1,Matrix matrix_2) {
        matrix_new = new Matrix(matrix_1.getRows(),matrix_2.getCols());
        for (int i = 0; i < matrix_1.getRows(); i++) {
            int[] line = new int[matrix_1.getRows()];
            for (int j = 0; j < matrix_2.getCols(); j++){
                int sum = 0;
                for (int k = 0; k <matrix_2.getRows(); k++) {
                     sum += matrix_1.getElem(i,k) * matrix_2.getElem(k, j);
                }
                line[j] = sum;
            }
            matrix_new.addLine_to_Matrix(i, line);
        }
        return matrix_new;
    }

    public static Matrix transMatrix(Matrix matrix_1) {
        matrix_new = new Matrix(matrix_1.getRows(), matrix_1.getCols());
        for (int i = 0; i < matrix_1.getCols(); i++) {
            int[] line = new int[matrix_1.getRows()];
            for (int j = 0; j < matrix_1.getRows(); j++) {
                line[j] = matrix_1.getElem(j, i);
            }
            matrix_new.addLine_to_Matrix(i, line);
        }
        return matrix_new;
    }
}
