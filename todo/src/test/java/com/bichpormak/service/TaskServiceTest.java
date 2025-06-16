package com.bichpormak.service;

import com.bichpormak.model.Task;
import com.bichpormak.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;

    @BeforeEach
    public void setUp() {
        task = Task.builder()
                .name("abobus")
                .description("abobus top")
                .startOfTerm(OffsetDateTime.now())
                .endOfTerm(OffsetDateTime.now().plusHours(1))
                .build();
    }


    @Nested
    @DisplayName("Class for testing task creation")
    public class CreationTaskServiceTest {
        @Test
        @DisplayName("Valid task")
        public void givenTask_whenCreateNewTask_thenTaskAddToRepository() {

            taskService.createTask(task.getName(), task.getDescription(), task.getStartOfTerm(), task.getEndOfTerm());

            verify(taskRepository).createTask(task);

        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Name is null or empty")
        public void givenTaskWithoutName_whenCreateNewTask_thenThrowException(String name) {

            assertThrows(RuntimeException.class,
                    () -> taskService.createTask(name, task.getDescription(), task.getStartOfTerm(), task.getEndOfTerm()));

            verify(taskRepository, times(0)).createTask(task);

        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Description is null or empty")
        public void givenTaskWithoutDescription_whenCreateNewTask_thenThrowException(String description) {

            assertThrows(RuntimeException.class,
                    () -> taskService.createTask(task.getName(), description, task.getStartOfTerm(), task.getEndOfTerm()));

            verify(taskRepository, times(0)).createTask(task);

        }

        @ParameterizedTest
        @NullSource
        @DisplayName("Start of term is null")
        public void givenTaskWithoutStartOfTerm_whenCreateNewTask_thenThrowException(OffsetDateTime startOfTerm) {

            assertThrows(RuntimeException.class,
                    () -> taskService.createTask(task.getName(), task.getDescription(), startOfTerm, task.getEndOfTerm()));

            verify(taskRepository, times(0)).createTask(task);

        }

        @ParameterizedTest
        @NullSource
        @DisplayName("End of term is null")
        public void givenTaskWithoutEndOfTerm_whenCreateNewTask_thenThrowException(OffsetDateTime endOfTerm) {

            assertThrows(RuntimeException.class,
                    () -> taskService.createTask(task.getName(), task.getDescription(), task.getStartOfTerm(), endOfTerm));

            verify(taskRepository, times(0)).createTask(task);

        }

    }

    @Test
    @DisplayName("Deleting a task that is in the repository")
    public void givenTask_whenDeleteTask_thenTaskDeleteFromRepository() {

        when(taskRepository.getAllTasks()).thenReturn(List.of(task));

        taskService.deleteTask(task);

        verify(taskRepository).deleteTask(task);

    }

    @Test
    @DisplayName("Deleting a task that is not in the repository")
    public void givenTask_whenDeleteTask_thenThrowException() {

        when(taskRepository.getAllTasks()).thenReturn(new ArrayList<>());

        assertThrows(IllegalStateException.class, () -> taskService.deleteTask(task));

        verify(taskRepository, times(0)).deleteTask(task);

    }

    @Test
    @DisplayName("Editing an existing task")
    public void givenTask_whenEditingTask_thenTaskEditingInRepository() {

        when(taskRepository.getAllTasks()).thenReturn(List.of(task));

        Task newTask = Task.builder()
                .name("roma")
                .description("way")
                .startOfTerm(OffsetDateTime.now())
                .endOfTerm(OffsetDateTime.now().plusHours(1))
                .build();

        taskService.editTask(task, newTask.getName(), newTask.getDescription(), newTask.getStartOfTerm(), newTask.getEndOfTerm(), newTask.getStatus());

        verify(taskRepository).editTask(task, newTask);

    }

    @Test
    @DisplayName("Editing an no existing task")
    public void givenTask_whenEditingTask_thenThrowException() {

        when(taskRepository.getAllTasks()).thenReturn(new ArrayList<>());

        Task newTask = Task.builder()
                .name("roma")
                .description("way")
                .startOfTerm(OffsetDateTime.now())
                .endOfTerm(OffsetDateTime.now().plusHours(1))
                .build();

        assertThrows(IllegalStateException.class,
                () -> taskService.editTask(task, newTask.getName(), newTask.getDescription(), newTask.getStartOfTerm(), newTask.getEndOfTerm(), newTask.getStatus()));

        verify(taskRepository, times(0)).editTask(task, newTask);

    }

    @Test
    @DisplayName("Filter tasks by status")
    public void givenTasks_whenFilterTasksByStatus_thenReturnFilteredList() {

        Task secondTask = Task.builder()
                .name("aboba")
                .description("description")
                .startOfTerm(OffsetDateTime.now())
                .endOfTerm(OffsetDateTime.now().plusHours(1))
                .status(Task.Status.IN_PROGRESS)
                .build();

        when(taskRepository.getAllTasks()).thenReturn(List.of(task, secondTask));

        Map<Task.Status, List<Task>> tasksByStatus = taskService.filterTasksByStatus();

        int sizeMap = 2;
        assertEquals(sizeMap, tasksByStatus.size());

        assertIterableEquals(tasksByStatus.get(Task.Status.CREATED), List.of(task));
        assertIterableEquals(tasksByStatus.get(Task.Status.IN_PROGRESS), List.of(secondTask));

    }

    @Test
    @DisplayName("Sort tasks by due date")
    public void givenTasks_whenSortTasks_thenReturnSortedList() {

        Task secondTask = Task.builder()
                .name("aboba")
                .description("description")
                .startOfTerm(task.getStartOfTerm().minusHours(1))
                .endOfTerm(task.getEndOfTerm())
                .build();

        when(taskRepository.getAllTasks()).thenReturn(List.of(task, secondTask));

        assertIterableEquals(taskService.sortTasksByDueDate(), List.of(secondTask, task));

    }




}
