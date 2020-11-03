package com.task;

public class FixedPriceEmployee  extends Employee {
    private String name ;
    private double salary ;
    public FixedPriceEmployee(int i, String name, double salary )  {
        this.setSalary(salary);
        this.name=name;
    }
    @Override
    double getSalary() {

        return salary;
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
        this.salary = salary;
    }
    @Override
    String getType() {
        return "FixedPriceEmployee";
    }
}
