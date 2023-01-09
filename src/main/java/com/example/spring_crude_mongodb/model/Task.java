package com.example.spring_crude_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
@Document(collection = "tasks")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Task {

    @Id
    private String taskId;
    private String taskName;
    private String description;
    
    public Task(final String taskName ,final String description){
        this.taskName = taskName;
        this.description = description;
    }

    public void setId(String id){
        taskId = id;
    }
}
