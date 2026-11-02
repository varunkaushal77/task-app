package com.varundev.task.domain;

import com.varundev.task.domain.entity.TaskPriority;

import java.time.LocalDate;

//coz its a request for the service layer to create a task
public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
){

}
