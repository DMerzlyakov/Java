package com.kontr;

public class Branch {
    int value;
    Branch left;
    Branch right;

    Branch (int value) {
        this.value = value;
        left = null;
        right = null;
    }
}