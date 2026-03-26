package org.example.Kata3;

import java.util.Arrays;

public class Payroll {
    public double calculateSalary(Employee employee) {
        if(employee == null){
            throw new IllegalArgumentException("L'employe ne peut etre null");
        }
        return employee.calculateSalary();
    }

    public void printPayrollReport(Employee employee){
        System.out.println("=== Fiche de Paie ===");
        System.out.println("Role :"+employee.getRole().getDisplayName());
        System.out.println(employee.getSalaryBreakDown());
        System.out.println("================");
    }

    public double  calculateTotalPayRoll(Employee... employees){
        return Arrays.stream(employees).mapToDouble(Employee::calculateSalary).sum();
    }
}