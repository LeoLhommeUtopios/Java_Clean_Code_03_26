package org.example.Kata3;

public class Intern extends Employee {
    private static final double HOURLY_RATE = 20;

    public Intern(int hoursWorked) {
        super(hoursWorked,EmployeeRole.INTERN);
    }

    @Override
    public double calculateSalary() {
        return calculatBaseSalary(PayrollConfiguration.INTERN_HOURLY_RATE);
    }

    @Override
    public String getSalaryBreakDown() {
        double salary = calculateSalary();
        return String.format("Salaire stagiare : %.2f €(%d heures x %.2f€",
                salary,hoursWorked,PayrollConfiguration.INTERN_HOURLY_RATE);
    }
}