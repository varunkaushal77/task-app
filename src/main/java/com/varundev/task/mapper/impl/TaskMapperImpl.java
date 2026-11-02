package com.varundev.task.mapper.impl;

import com.varundev.task.domain.CreateTaskRequest;
import com.varundev.task.domain.UpdateTaskRequest;
import com.varundev.task.domain.dto.CreateTaskRequestDto;
import com.varundev.task.domain.dto.TaskDto;
import com.varundev.task.domain.dto.UpdateTaskRequestDto;
import com.varundev.task.domain.entity.Task;
import com.varundev.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

// there is map struct library that handles it automatically but just created it for our understanding.
@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDTO(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDTO(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDTO(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
