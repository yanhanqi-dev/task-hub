package com.yanhanqi.taskhub.controller;

import com.yanhanqi.taskhub.model.Task;
import com.yanhanqi.taskhub.model.CreateTaskRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody CreateTaskRequest request) {
        String title = request.getTitle();
        if (title == null || title.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "任务标题不能为空");
        }

        long id = tasks.size() + 1L;
        Task task = new Task(id, title, false);
        tasks.add(task);
        return task;
    }

    @PatchMapping("/api/tasks/{id}/complete")
    public Task completeTask (@PathVariable Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.markCompleted();
                return task;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "任务不存在");
    }

    @DeleteMapping("/api/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask (@PathVariable Long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                tasks.remove(i);
                return;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "任务不存在");
    }
}
