package ocp;

import org.example.ocp.Employee;
import org.example.ocp.EmployeeEngineer;
import org.example.ocp.EmployeeManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeShould {

    private static final int BONUS = 100;
    private static final int SALARY = 1000;

    @Test
    void not_add_bonus_to_the_engineer_pay_amount() {
        Employee employee = new EmployeeEngineer(SALARY, BONUS);
        assertThat(employee.payAmount())
                .isEqualTo(SALARY);
    }

    @Test
    void add_bonus_to_the_manager_pay_amount() {
        Employee employee = new EmployeeManager(SALARY, BONUS);
        assertThat(employee.payAmount())
                .isEqualTo(SALARY + BONUS);
    }
}