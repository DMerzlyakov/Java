package com.vect;

import java.util.Scanner;

public class Vector {

    double x, y, z;
    static Scanner in = new Scanner(System.in);

    Vector(Double ... args) {
        if (args.length == 0) {
            System.out.print("Введите переменную 'x': ");
            x = in.nextDouble();
            System.out.print("Введите переменную 'y': ");
            y = in.nextDouble();
            System.out.print("Введите переменную 'z': ");
            z = in.nextDouble();
        }
        else {
            x = args[0];
            y = args[1];
            z = args[2];
        }
    }
    public double lenVect() {
        double len = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
        return len;
    }

    public double scalVect(Vector b) {
        double[] b_xyz = b.getVector();
        double answer = x * b_xyz[0] + y * b_xyz[1] + z * b_xyz[2];
        return answer;
    }

    public Vector multVect_to_Vect(Vector b) {
        double[] b_xyz = b.getVector();
        double new_x = y*b_xyz[2] - z*b_xyz[1];
        double new_y = z*b_xyz[0] - x*b_xyz[2];
        double new_z = x*b_xyz[1] - y*b_xyz[0];
        Vector answer = new Vector(new_x, new_y, new_z);
        return answer;
    }

    public Double angleVect_to_Vect(Vector a, Vector b) {
        double[] a_xyz = a.getVector();
        double[] b_xyz = b.getVector();
        double answer = a.scalVect(b) / (Math.abs(a.lenVect()) * Math.abs(b.lenVect()));
        answer =Math.toDegrees(Math.acos(answer));
        return answer;
    }

    public Vector sumVect_to_Vect(Vector b) {
        double[] b_xyz = b.getVector();
        Vector answer = new Vector(x+b_xyz[0], y+b_xyz[1], z+b_xyz[2]);
        return answer;
    }

    public Vector minusVect_to_Vect(Vector b) {
        double[] b_xyz = b.getVector();
        Vector answer = new Vector(x-b_xyz[0], y-b_xyz[1], z-b_xyz[2]);
        return answer;
    }

    public static Vector[] getRandVect(int n) {
        Vector[] answer = new Vector[n];
        for(int i=0; i<n; i++) {
            answer[i] = new Vector(Math.random()*100,Math.random()*100, Math.random()*100);
        }
        return answer;
    }


    public double[] getVector() {
        return new double[]{x, y, z};
    }

    public void showVect() {
        System.out.print("X = " + x);
        System.out.print("; Y = " + y);
        System.out.print("; Z = " + z);
        System.out.println();

    }
}
