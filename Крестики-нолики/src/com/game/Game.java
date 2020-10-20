package com.game;

import java.util.Random;
import java.util.Scanner;

public class Game {

    final char type_x = 'x';
    final char type_y = '0';
    final char type_null = ' ';
    char[][] table;
    Random random;
    Scanner scanner;

    Game() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot &&
                            table[2][i] == dot))
                return true;
        if ((table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot &&
                        table[0][2] == dot))
            return true;
        return false;
    }

    boolean EndOfTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == type_null)
                    return false;
        return true;
    }

    void PcTurn() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!ValidOfCell(x, y));
        table[y][x] = type_y;
    }

    boolean ValidOfCell(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3)
            return false;
        return table[y][x] == type_null;
    }

    void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите x и y координаты (от 1 до 3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!ValidOfCell(x, y));
        table[y][x] = type_x;
    }

    void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                if(col!=2) {
                    System.out.print(table[row][col] + "|");
                }
                else {
                    System.out.print(table[row][col] + " ");
                }
            System.out.println();
        }
    }

    void createTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = type_null;
    }

    void game() {
        createTable();
        while (true) {
            playerTurn();
            if (checkWin(type_x)) {
                System.out.println("Ты победил!");
                break;
            }
            if (EndOfTable()) {
                System.out.println("Ничья!");
                break;
            }
            PcTurn();
            printTable();
            if (checkWin(type_y)) {
                System.out.println("Пк победил!");
                break;
            }
            if (EndOfTable()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Конец игровой сессии");
        printTable();
    }
}
