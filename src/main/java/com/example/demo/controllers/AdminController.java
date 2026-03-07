package com.example.demo.controllers;

import com.example.demo.entity.Task;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Only ADMIN can access
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return adminService.getAllTasks();
    }

    // Only ADMIN can delete any task
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        adminService.deleteTask(id);
        return "Task deleted by ADMIN";
    }
}