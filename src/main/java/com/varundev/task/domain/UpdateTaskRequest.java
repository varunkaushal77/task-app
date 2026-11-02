package com.varundev.task.domain;

import com.varundev.task.domain.entity.TaskPriority;
import com.varundev.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
