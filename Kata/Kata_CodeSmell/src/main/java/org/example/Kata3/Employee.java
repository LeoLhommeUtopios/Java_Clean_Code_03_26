package org.example.Kata3;

public abstract class Employee {
    protected final int hoursWorked;
    private final EmployeeRole role;

    public Employee(int hoursWorked,EmployeeRole role) {
        if(hoursWorked <0){
            throw new IllegalArgumentException("Les heures travaillées ne peuvent etre négatives");
        }
        this.hoursWorked = hoursWorked;
        this.role =role;
    }

    public abstract double calculateSalary();

    public abstract String getSalaryBreakDown();

    public int getHoursWorked() {
        return hoursWorked;
    }

    public EmployeeRole getRole() {
        return role;
    }

    protected double calculatBaseSalary(double hourlyRate){
        return hoursWorked * hourlyRate;
    }
}