package com.charles.innovexInterview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.charles.innovexInterview.models.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();

    @Query(value = "SELECT IFNULL((sum(if(tasks_enum = 'START', servers, 0)) - sum(if(tasks_enum = 'STOP', servers, 0))),0) " +
            "as currentServers from tasks ", nativeQuery = true)
    Integer findActiveServers();
}