package com.kontr;


// Пример из файла с заданиями

class Recursion {
    int aValues[];
    StringBuilder sb = new StringBuilder();

    // Конструктор
    Recursion(int i) {
        aValues = new int[i];
    }

    // Рекурсивное отображение элементов массива
    String printArray(int i) {
        if (i == 0) {
            return "";
            // не забываем про выход из метода
        } else {
            printArray(i - 1);

            String output = "[" + (i - 1) + "]" + aValues[i - 1] + "\n";
            sb.append(output);
            return sb.toString();
        }
    }
}

