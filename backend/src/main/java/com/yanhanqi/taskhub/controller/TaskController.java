package com.yanhanqi.taskhub.controller;

import com.yanhanqi.taskhub.model.Task;
import com.yanhanqi.taskhub.model.CreateTaskRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private final List<Task> tasks =  new ArrayList<>(List.of(
            new Task(1L, "学习 Day 11", false),
            new Task(2L, "学习 REST API", true)
    ));


    @GetMapping("/api/tasks")
    public List<Task> listTasks() {
        return tasks;
    }

    @PostMapping("/api/tasks")
    public Task createTask(@RequestBody CreateTaskRequest request) {
        long id = tasks.size() + 1L;
        Task task = new Task(id, request.getTitle(), false);
        tasks.add(task);
        return task;
    }
}
