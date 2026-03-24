package org.example.ocp;

public class EmployeeEngineer extends Employee{

    public EmployeeEngineer(int salary, int bonus) {
        super(salary, bonus);
    }

    @Override
    public int payAmount() {
        return salary;
    }
}
