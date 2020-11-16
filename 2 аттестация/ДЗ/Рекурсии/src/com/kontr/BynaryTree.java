package com.kontr;


public class BynaryTree {

    public Branch tree;

    public BynaryTree (int value) {
        tree = new Branch(value);
    }

    private Branch add(Branch branch, int value) {
        if (branch == null) {
            return new Branch(value);
        }

        if (value < tree.value) {
            branch.left = add(branch.left, value);
        } else if (value > branch.value) {
            branch.right = add(branch.right, value);
        } else {
            return branch;
        }

        return branch;
    }
    public void addValue(int value) {
        tree = add(tree, value);
    }

    private boolean findPrivateValue(Branch branch, int value) {
        if (branch == null) {
            return false;
        }
        else if (branch.value == value) {
            return true;
        }

        return value > branch.value ? findPrivateValue(branch.right, value) : findPrivateValue(branch.left, value);
    }

    public void findValue(int value) {
        if (findPrivateValue(tree, value) == true) {
            System.out.println("Значение " + value + " найдено");
        }
        else {System.out.println("Значение " + value + " не найдено");}
    }
}

