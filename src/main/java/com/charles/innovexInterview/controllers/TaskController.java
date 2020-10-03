package com.charles.innovexInterview.controllers;

import com.charles.innovexInterview.models.CreateTask;
import com.charles.innovexInterview.services.TaskService;
import com.charles.innovexInterview.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public Task create(@RequestBody CreateTask createTask) {
        return taskService.create(createTask);
    }

    @GetMapping(value = "getAllTasks")
    public List<Task> findTasks(){
        return taskService.findAll();
    }

}
