package com.task;

public class Timed extends Employee {

    private String name ;
    private double salary ;




    public Timed(int i, String name, double salary )  {
        this.salary = salary;
        this.name=name;

    }



    @Override
    double getSalary() {

        return 20.8 * 8 * salary;
    }
    @Override
    String getType() {
        return "Timed";
    }

    @Override
    String getName() {

        return this.name;
    }



    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    void setSalary(double salary) {

    }

}