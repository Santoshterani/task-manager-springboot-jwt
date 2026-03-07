package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private TaskRepository taskRepository;

    // ADMIN can view all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ADMIN can delete any task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}