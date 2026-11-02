package com.varundev.task.domain.dto;

import com.varundev.task.domain.entity.TaskPriority;
import com.varundev.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

// it can be used as a generic response for multiple endpoints, better to decouple if needed.
// defines what fields do we need to see in our api responses.
// no need of adding validation annotations as we are going to return our responses using it, not accept it from the caller.
public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
