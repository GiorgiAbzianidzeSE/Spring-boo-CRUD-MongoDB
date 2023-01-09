package com.example.spring_crude_mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring_crude_mongodb.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>{
    Optional<Task> findByTaskName(String name);
}
