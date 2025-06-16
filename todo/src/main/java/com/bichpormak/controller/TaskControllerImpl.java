package com.bichpormak.controller;

import com.bichpormak.model.Task;
import com.bichpormak.service.TaskService;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;


    @Override
    public void addTask(String name, String description, OffsetDateTime startOfTerm, OffsetDateTime endOfTerm) {

        try {

            taskService.createTask(name, description, startOfTerm, endOfTerm);
            System.out.println("Задача успешно создана и добавлена в репозиторий");

        } catch (IllegalStateException e) {
            System.out.println("Некорректные данные для сохранения задачи");
        }
    }

    @Override
    public void listTasks() {
        System.out.println(taskService.getAllTasks());
    }

    @Override
    public void editTask(Task task, String name, String description, OffsetDateTime startOfTerm, OffsetDateTime endOfTerm, Task.Status status) {

        try {
            taskService.editTask(task, name, description, startOfTerm, endOfTerm, status);
            System.out.println("Задача успешно редактирована");
        } catch (IllegalStateException | ConstraintViolationException e) {
            System.out.println("Ошибка при сохранении");
        }
    }

    @Override
    public void deleteTask(Task task) {

        try {
            taskService.deleteTask(task);
        } catch (IllegalStateException e) {
            System.out.println("Не нашлось такой задачи, ошибка");
        }

    }

    @Override
    public void filterTasksByStatus() {
        System.out.print("Отфильтрованный список по статусу: " + taskService.filterTasksByStatus());
    }

    @Override
    public void sortTasks() {
        System.out.println("Отсортированный список по началу задачи: " + taskService.sortTasksByDueDate());
    }

    @Override
    public void exitFromApplication() {
        System.out.println("Приятно было поработать");
        System.exit(0);
    }

}
