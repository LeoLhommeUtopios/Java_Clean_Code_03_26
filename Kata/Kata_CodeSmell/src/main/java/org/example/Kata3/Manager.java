package org.example.Kata3;

public class Manager extends Employee {
    private int teamSize;

    public Manager(int hoursWorked, int teamSize) {
        super(hoursWorked,EmployeeRole.MANAGER);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        double baseSalary = calculatBaseSalary(PayrollConfiguration.DEVELOPER_HOURLY_RATE);
        return baseSalary + calculateTeamSizeBonus();

    }

    private double calculateTeamSizeBonus(){
        return teamSize > PayrollConfiguration.MANAGER_TEAM_SIZE_THRESHOLD ?
                PayrollConfiguration.MANAGER_BONUS : 0;
    }

    @Override
    public String getSalaryBreakDown() {
        double baseSalary = calculatBaseSalary(PayrollConfiguration.DEVELOPER_HOURLY_RATE);
        double bonus = calculateTeamSizeBonus();

        StringBuilder breakdown = new StringBuilder();
        breakdown.append(String.format("Salaire de base : %.2f€ (%d heures x %2f€)%n",
                baseSalary,hoursWorked,PayrollConfiguration.DEVELOPER_HOURLY_RATE));

        if(bonus > 0){
            breakdown.append(String.format("Bonus equipe : %.2f€ ",
                    bonus));
        }

        breakdown.append(String.format("Total : %.2f€",calculateSalary()));
        return breakdown.toString();
    }
}