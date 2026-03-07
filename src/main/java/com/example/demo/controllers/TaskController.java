package com.example.demo.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.TaskRequest;
import com.example.demo.entity.Task;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final JwtUtil jwtUtil;

    public TaskController(TaskService taskService, JwtUtil jwtUtil) {
        this.taskService = taskService;
        this.jwtUtil = jwtUtil;
    }

    // CREATE TASK
    @PostMapping
    public Task createTask(@RequestBody TaskRequest request,
                           HttpServletRequest httpRequest) {

        String token = httpRequest.getHeader("Authorization").substring(7);

        String username = jwtUtil.extractUsername(token);

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());

        return taskService.createTask(username, task);
    }

    // GET USER TASKS
    @GetMapping
    public Page<Task> getTasks(
            Pageable pageable,
            HttpServletRequest httpRequest) {

        String token = httpRequest.getHeader("Authorization").substring(7);

        String username = jwtUtil.extractUsername(token);

        return taskService.getTasksByUser(username, pageable);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody TaskRequest request) {

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());

        return taskService.updateTask(id, task);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }
}