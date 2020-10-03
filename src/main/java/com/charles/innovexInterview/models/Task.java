package com.charles.innovexInterview.models;

import com.charles.innovexInterview.constants.TasksEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;

    private String programTime;

    @Enumerated(EnumType.STRING)
    private TasksEnum tasksEnum;

    private Integer servers;

    private String message;

    private String color;

    @JsonIgnore
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date actualTime;

    private String displayMessage;


    public Task() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramTime() {
        return programTime;
    }

    public void setProgramTime(String programTime) {
        this.programTime = programTime;
    }

    public TasksEnum getTasksEnum() {
        return tasksEnum;
    }

    public void setTasksEnum(TasksEnum tasksEnum) {
        this.tasksEnum = tasksEnum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public Integer getServers() {
        return servers;
    }

    public void setServers(Integer servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", programTime='" + programTime + '\'' +
                ", tasksEnum=" + tasksEnum +
                ", servers=" + servers +
                ", message='" + message + '\'' +
                ", actualTime=" + actualTime +
                ", displayMessage='" + displayMessage + '\'' +
                '}';
    }
}
