package com.task;


public class Main {
    public static void main(String[] strings) {
        stringBuilder tested = new stringBuilder();
        tested.setListen(new MyListener());
        tested.append("Тест  ");
        tested.append("Тест 2  ");
        tested.append("Тест 3  ");
    }
}