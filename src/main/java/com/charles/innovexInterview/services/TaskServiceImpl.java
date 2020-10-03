package com.charles.innovexInterview.services;

import com.charles.innovexInterview.models.CreateTask;
import com.charles.innovexInterview.repositories.TaskRepository;
import com.charles.innovexInterview.models.Task;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Random;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task create(CreateTask createTask) {
        Task task = new Task();
        task.setProgramTime(createTask.getTime());
        task.setTasksEnum(createTask.getEvent());
        Random random = new Random();
        int servers = 0;
        int activeServers = taskRepository.findActiveServers();
        String message = "";
        String displayMessage = "";
        switch (createTask.getEvent()) {
            case START:
                servers = random.nextInt(20 - 10 + 1) + 10;
                message = "Start " + servers + " servers";
                displayMessage = createTask.getTime() + " - " + message;
                break;
            case STOP:
                servers = random.nextInt(activeServers - 5 + 1) + 5;
                message = "Stop " + servers + " servers";
                displayMessage = createTask.getTime() + " - " + message;
                break;
            case REPORT:
                servers = taskRepository.findActiveServers();
                message = "Report " + servers + " servers running";
                displayMessage = createTask.getTime() + " - " + message;
        }
        task.setServers(servers);
        task.setMessage(message);
        task.setDisplayMessage(displayMessage);
        task.setColor(generateRandomColor(createTask.getColor()));
        return taskRepository.save(task);
    }

    String generateRandomColor(String oldColor) {
        Color color;
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = 0.9f;
        final float luminance = 1.0f;
        color = Color.getHSBColor(hue, saturation, luminance);
        String newColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
        if(newColor.equals(oldColor))
            generateRandomColor(oldColor);
        return newColor;
    }
}
