package com.varundev.task.controller;

import com.varundev.task.domain.CreateTaskRequest;
import com.varundev.task.domain.UpdateTaskRequest;
import com.varundev.task.domain.dto.CreateTaskRequestDto;
import com.varundev.task.domain.dto.TaskDto;
import com.varundev.task.domain.dto.UpdateTaskRequestDto;
import com.varundev.task.domain.entity.Task;
import com.varundev.task.mapper.TaskMapper;
import com.varundev.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// methods to represent the endpoints of our REST API
@RestController //telling Spring to look for various endpoints of our REST API, works like @component bean and injects
@RequestMapping(path = "/api/v1/tasks") // base path for all endpoints in this controller
public class TaskController {

    private final TaskService taskService; // to interact with service layer
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    // each endpoint is represented by a method
    @PostMapping
    public ResponseEntity<TaskDto> createTask(
        // added requestBody as creatTaskRequestDto will be in the body of the request
        // valid is added to enforce the validations we declared in the CreateTaskRequestDto, spring should look at them
        @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto){

        CreateTaskRequest createTaskRequest = taskMapper.fromDTO(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDTO(task);

        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDTO).toList();
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
    ){
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDTO(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto taskDto = taskMapper.toDTO(task);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping(path="/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
