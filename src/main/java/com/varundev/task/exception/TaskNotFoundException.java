package com.varundev.task.exception;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {

    //we want to show the ID in the exception
    private final UUID id;
    public TaskNotFoundException(UUID id) {
        super(String.format("Task with id '%s' does not exist", id));
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
