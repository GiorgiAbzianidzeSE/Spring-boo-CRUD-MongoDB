package com.example.spring_crude_mongodb.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.spring_crude_mongodb.model.Task;
import com.example.spring_crude_mongodb.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;

    public TaskServiceImpl(final TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public Task addTask(Task task) {
        task.setId(UUID.randomUUID().toString().split("-")[0]);
        return this.repository.save(task);
    }

    @Override
    public Task getTask(String id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("no such id: " + id));
    }

    @Override
    public List<Task> getAllTask() {
        return this.repository.findAll();
    }

    @Override
    public Task updateTask(String id, Task task) {
        this.repository.findById(id).orElseThrow(() -> new RuntimeException("no such id: " + id));; //validation
        task.setId(id);
        return this.repository.save(task);
    }

    @Override
    public Task removeTask(String id) {
        Task task = this.getTask(id);
        this.repository.deleteById(id);
        return task;
    }

    @Override
    public Optional<Task> findByTaskName(String name) {
        return this.repository.findByTaskName(name);
    }

    
}
