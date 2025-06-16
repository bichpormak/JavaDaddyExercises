package com.bichpormak.repository;

import com.bichpormak.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private static final List<Task> tasks = new ArrayList<>();

    @Override
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void createTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void editTask(Task oldTask, Task newTask) {
        tasks.set(tasks.indexOf(oldTask), newTask);
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }


}
