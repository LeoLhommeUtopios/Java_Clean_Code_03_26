package org.example.service;


import org.example.entity.Employee;
import org.example.entity.Task;
import org.example.entity.TaskStatus;

public interface NotificationService {
    void notifyTaskStatusChanged(Task task, TaskStatus oldStatus, TaskStatus newStatus);
    void notifyTaskAssigned(Task task, Employee previousEmployee, Employee newEmployee);
    void notifyTaskUpdate(int taskId);
}
