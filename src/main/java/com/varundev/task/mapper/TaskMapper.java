package com.varundev.task.mapper;

import com.varundev.task.domain.CreateTaskRequest;
import com.varundev.task.domain.UpdateTaskRequest;
import com.varundev.task.domain.dto.CreateTaskRequestDto;
import com.varundev.task.domain.dto.TaskDto;
import com.varundev.task.domain.dto.UpdateTaskRequestDto;
import com.varundev.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDTO(CreateTaskRequestDto dto);
    UpdateTaskRequest fromDTO(UpdateTaskRequestDto dto);

    TaskDto toDTO(Task task);
}
