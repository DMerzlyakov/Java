package com.kontr;

public class Task_4 {

    public static void main () {
        BynaryTree test = new BynaryTree(3);

        test.addValue(1);
        test.addValue(2);
        test.addValue(4);
        test.addValue(5);
        test.addValue(5);
        test.addValue(2);
        test.addValue(3);
        test.addValue(1);
        test.addValue(9);

        test.findValue(6);
        test.findValue(3);

    }
}


