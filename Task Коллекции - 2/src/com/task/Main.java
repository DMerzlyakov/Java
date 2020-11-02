package com.task;

import java.util.Iterator;

public class Main{

    public static void main(String[] args) {

        //Итератор по двумерному массиву
        Integer[][] array = {{1, 2, 3}, {3, 2, 1}};
        Array2DIterator<Integer> li = new Array2DIterator<>(array);

        for (int i = 0; i < 8; i++){
            System.out.println(li.next());
        }
    }
}
