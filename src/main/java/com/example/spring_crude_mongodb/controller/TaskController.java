package com.example.spring_crude_mongodb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_crude_mongodb.model.Task;
import com.example.spring_crude_mongodb.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    

    private final TaskService service;

    public TaskController(final TaskService service){
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTask(){
        return this.service.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") final String id){
        return this.service.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody final Task task){
        return this.service.addTask(task);
    }

    @PutMapping("{id}")
    public Task updateTask(@RequestBody final Task task , @PathVariable("id") String id){
        return this.service.updateTask(id, task);
    }

    @DeleteMapping("{id}")
    public Task deleteTask(@PathVariable("id") final String id){
        return this.service.removeTask(id);
    }

    @GetMapping("/name/{name}")
    public Task findByTaskName(@PathVariable("name") String name){
        return this.service.findByTaskName(name).orElseThrow(() -> new RuntimeException("no such name: " + name));
    }

}
