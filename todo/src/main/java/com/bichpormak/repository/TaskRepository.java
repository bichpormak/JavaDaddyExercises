package com.bichpormak.repository;

import com.bichpormak.model.Task;

import java.util.List;

public interface TaskRepository {

    void deleteTask(Task task);
    void createTask(Task task);
    void editTask(Task oldTask, Task newTask);
    List<Task> getAllTasks();

}
