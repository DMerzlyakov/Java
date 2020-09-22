package com.task_2_4;

public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        box.setVolume(300.0);
        Ball ball = new Ball();
        ball.setVolume(150.0);
        System.out.println("Объём коробки: " + box.getVolume());
        boolean answer = box.add(ball);
        System.out.println("Успех добавления объекта: " + answer);
        System.out.println("Обновленный объём коробки: " + box.getVolume());
        Pyramid pyramid= new Pyramid();
        pyramid.setVolume(1000);
        answer = box.add(pyramid);
        System.out.println("Успех добавления объекта: " + answer);
        System.out.println("Обновленный объём коробки: " + box.getVolume());
    }
}