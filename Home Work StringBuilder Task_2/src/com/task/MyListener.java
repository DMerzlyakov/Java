package com.task;

class MyListener implements stringBuilderListener {
    public void onChange(stringBuilder stringBuilder) {
        System.out.println("CHANGED: " + stringBuilder.toString());
    }
}