package com.charles.innovexInterview.models;

import com.charles.innovexInterview.constants.TasksEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CreateTask {
    @Enumerated(EnumType.STRING)
    private TasksEnum event;

    private String time;

    private String color;

    public CreateTask() {
    }

    public TasksEnum getEvent() {
        return event;
    }

    public void setEvent(TasksEnum event) {
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CreateTask{" +
                "event='" + event + '\'' +
                ", time='" + time + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
