package org.example.service.impl;


import org.example.dao.EmployeeDAO;
import org.example.dao.ProjectDAO;
import org.example.dao.TaskDAO;
import org.example.entity.Employee;
import org.example.entity.Project;
import org.example.entity.Task;
import org.example.entity.TaskStatus;
import org.example.exception.EmployeeNotFoundException;
import org.example.exception.ProjectNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.service.NotificationService;
import org.example.service.TaskService;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    private final TaskDAO taskDAO;
    private final ProjectDAO projectDAO;
    private final EmployeeDAO employeeDAO;
    private final NotificationService notificationService;


    public TaskServiceImpl(TaskDAO taskDAO, ProjectDAO projectDAO,
                           EmployeeDAO employeeDAO, NotificationService notificationService) {
        this.taskDAO = taskDAO;
        this.projectDAO = projectDAO;
        this.employeeDAO = employeeDAO;
        this.notificationService = notificationService;
    }

    @Override
    public Task createTask(String name, int projectId) {
        return createTask(name, null, projectId);
    }

    @Override
    public Task createTask(String name, String description, int projectId) {
        Project project = projectDAO.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Projet avec ID " + projectId + " non trouvé"));

        Task task = project.addTask(name, description);
        taskDAO.save(task);
        projectDAO.update(project);

        return task;
    }

    @Override
    public void updateTaskStatus(int taskId, TaskStatus status) {
        Task task = taskDAO.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Tâche avec ID " + taskId + " non trouvée"));

        TaskStatus oldStatus = task.getStatus();
        task.updateStatus(status);
        taskDAO.update(task);

        if (task.getAssignedEmployee() != null) {
            notificationService.notifyTaskStatusChanged(task, oldStatus, status);
        }
    }

    @Override
    public void assignEmployeeToTask(int taskId, int employeeId) {
        Task task = taskDAO.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Tâche avec ID " + taskId + " non trouvée"));

        Employee employee = employeeDAO.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employé avec ID " + employeeId + " non trouvé"));

        Employee previousEmployee = task.getAssignedEmployee();
        task.assignTo(employee);
        taskDAO.update(task);

        notificationService.notifyTaskAssigned(task, previousEmployee, employee);
    }

    @Override
    public Optional<Task> findTaskById(int taskId) {
        return taskDAO.findById(taskId);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskDAO.findAll();
    }

    @Override
    public List<Task> findTasksByProject(int projectId) {
        return taskDAO.findByCriteria(task ->
                task.getProject() != null && task.getProject().getId() == projectId);
    }

    @Override
    public List<Task> findTasksByStatus(TaskStatus status) {
        return taskDAO.findByCriteria(task -> task.getStatus() == status);
    }

    @Override
    public void deleteTask(int taskId) {
        Task task = taskDAO.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Tâche avec ID " + taskId + " non trouvée"));

        if (task.getProject() != null) {
            task.getProject().removeTask(task);
            projectDAO.update(task.getProject());
        }

        taskDAO.delete(task);
    }
}