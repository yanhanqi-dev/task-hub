package com.yanhanqi.taskhub.controller;

import com.yanhanqi.taskhub.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/api/tasks")
    public List<Task> listTasks() {
        return List.of(
                new Task(1L, "完成 Day 11", false),
                new Task(2L, "学习 REST API", true)
        );
    }
}
