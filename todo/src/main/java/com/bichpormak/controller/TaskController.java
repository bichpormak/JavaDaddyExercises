package com.bichpormak.controller;

import com.bichpormak.model.Task;

import java.time.OffsetDateTime;

public interface TaskController {

    void addTask(String name, String description, OffsetDateTime startOfTerm, OffsetDateTime endOfTerm);

    void listTasks();

    void editTask(Task task,
                  String name,
                  String description,
                  OffsetDateTime startOfTerm,
                  OffsetDateTime endOfTerm,
                  Task.Status status);

    void deleteTask(Task task);

    void filterTasksByStatus();
    void sortTasks();
    void exitFromApplication();

}
