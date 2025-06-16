package com.bichpormak.service;

import com.bichpormak.model.Task;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public interface TaskService {

    void createTask(String name,
                    String description,
                    OffsetDateTime startOfTerm,
                    OffsetDateTime endOfTerm);

    void deleteTask(Task task);

    void editTask(Task oldTask,
                  String name,
                  String description,
                  OffsetDateTime startOfTerm,
                  OffsetDateTime endOfTerm,
                  Task.Status status);

    Map<Task.Status, List<Task>> filterTasksByStatus();

    List<Task> sortTasksByDueDate();

    List<Task> getAllTasks();

}
