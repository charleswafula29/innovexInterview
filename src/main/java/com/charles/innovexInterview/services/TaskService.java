package com.charles.innovexInterview.services;

import com.charles.innovexInterview.models.CreateTask;
import com.charles.innovexInterview.models.StatusModel;
import com.charles.innovexInterview.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task create(CreateTask task);

    StatusModel ClearDatabase();


}
