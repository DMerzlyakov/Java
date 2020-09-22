package com.task_2_4;

class Box extends Shape {

    public boolean add(Shape shape) {
        if (getVolume() < shape.getVolume()) {
            return false;
        } else {
            double freeVolume = this.getVolume() - shape.getVolume();
            setVolume(freeVolume);
            return true;
        }
    }
}