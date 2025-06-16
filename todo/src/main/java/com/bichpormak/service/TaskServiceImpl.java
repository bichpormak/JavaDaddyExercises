package com.bichpormak.service;

import com.bichpormak.model.Task;
import com.bichpormak.repository.TaskRepository;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;


    @Override
    public void createTask(String name, String description, OffsetDateTime startOfTerm, OffsetDateTime endOfTerm) {

        Task task = Task.builder()
                .name(name)
                .description(description)
                .startOfTerm(startOfTerm)
                .endOfTerm(endOfTerm)
                .build();

        createValidator(task);

        taskRepository.createTask(task);

    }

    @Override
    public void deleteTask(Task task) {

        List<Task> tasks = taskRepository.getAllTasks();

        if (tasks.contains(task)) {
            taskRepository.deleteTask(task);
        } else {
            throw new IllegalStateException("Not found task");
        }

    }

    @Override
    public void editTask(Task oldTask, String name, String description, OffsetDateTime startOfTerm, OffsetDateTime endOfTerm, Task.Status status) {

        if (taskRepository.getAllTasks().contains(oldTask)) {

            Task newTask = Task.builder()
                    .name(name)
                    .description(description)
                    .startOfTerm(startOfTerm)
                    .endOfTerm(endOfTerm)
                    .build();

            createValidator(newTask);

            taskRepository.editTask(oldTask, newTask);
        } else {
            throw new IllegalStateException("Not found task");
        }

    }

    @Override
    public Map<Task.Status, List<Task>> filterTasksByStatus() {

        return taskRepository.getAllTasks().stream()
                .collect(Collectors.groupingBy(Task::getStatus));

    }

    @Override
    public List<Task> sortTasksByDueDate() {

        return taskRepository.getAllTasks().stream()
                .sorted(Comparator.comparing(Task::getStartOfTerm))
                .toList();

    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    private void createValidator(Task task) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
