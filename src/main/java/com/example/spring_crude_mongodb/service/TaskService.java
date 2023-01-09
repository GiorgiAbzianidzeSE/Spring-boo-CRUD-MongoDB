package com.example.spring_crude_mongodb.service;

import java.util.List;
import java.util.Optional;

import com.example.spring_crude_mongodb.model.Task;

public interface TaskService {

    Task addTask(Task task);

    Task getTask(String id);

    List<Task> getAllTask();  

    Task updateTask(String id, Task task);

    Task removeTask(String id);

    Optional<Task> findByTaskName(String name);


    
}
