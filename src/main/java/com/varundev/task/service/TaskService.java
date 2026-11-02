package com.varundev.task.service;

import com.varundev.task.domain.CreateTaskRequest;
import com.varundev.task.domain.UpdateTaskRequest;
import com.varundev.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    // can also return a dedicated service layer object instead of returning an entity directly i.e. createTaskResponse
    // for more separation which has more benefits and decoupling
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
