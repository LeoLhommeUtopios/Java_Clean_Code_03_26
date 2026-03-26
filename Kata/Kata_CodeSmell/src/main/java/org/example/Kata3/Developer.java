package org.example.Kata3;

public class Developer extends Employee {
    private int yearsOfExperience;

    public Developer(int hoursWorked, int yearsOfExperience) {
        super(hoursWorked,EmployeeRole.DEVELOPER);
        if(yearsOfExperience < 0){
            throw new IllegalArgumentException("L'experience ne peut pas etre negative");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateSalary() {
      double baseSalary = calculatBaseSalary(PayrollConfiguration.DEVELOPER_HOURLY_RATE);
       return baseSalary + calculateExperienceBonus();

    }

    private double calculateExperienceBonus(){
        return yearsOfExperience > PayrollConfiguration.DEVELOPER_EXPERIENCE_THRESHOLD ?
                PayrollConfiguration.DEVELOPER_BONUS : 0;
    }

    @Override
    public String getSalaryBreakDown() {
        double baseSalary = calculatBaseSalary(PayrollConfiguration.DEVELOPER_HOURLY_RATE);
        double bonus = calculateExperienceBonus();

        StringBuilder breakdown = new StringBuilder();
        breakdown.append(String.format("Salaire de base : %.2f€ (%d heures x %2f€)%n",
                baseSalary,hoursWorked,PayrollConfiguration.DEVELOPER_HOURLY_RATE));

        if(bonus > 0){
            breakdown.append(String.format("Bonus Experience : %.2f€ ",
                    bonus));
        }

        breakdown.append(String.format("Total : %.2f€",calculateSalary()));
        return breakdown.toString();
    }
}