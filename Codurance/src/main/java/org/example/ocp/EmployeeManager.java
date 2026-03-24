package org.example.ocp;

public class EmployeeManager extends Employee{
    public EmployeeManager(int salary, int bonus) {
        super(salary, bonus);
    }

    @Override
    public int payAmount() {
        return salary+bonus;
    }
}
