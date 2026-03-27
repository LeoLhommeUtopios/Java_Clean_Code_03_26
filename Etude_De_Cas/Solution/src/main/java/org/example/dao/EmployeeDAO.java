package org.example.dao;


import org.example.entity.Employee;

public class EmployeeDAO extends GenericDAO<Employee, Integer> {
    private int currentId = 1;

    @Override
    protected Integer generateId() {
        return currentId++;
    }

    @Override
    protected Integer getId(Employee employee) {
        return employee.getId();
    }

    @Override
    protected void setId(Employee employee, Integer id) {
        employee.setId(id);
    }
}
