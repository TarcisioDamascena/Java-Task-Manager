package com.damascena.Java.Task.Manager.service;

import com.damascena.Java.Task.Manager.model.Task;
import com.damascena.Java.Task.Manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updateTask) {
        return taskRepository.findById(id)
                .map(
                        task -> {
                            task.setTitle(updateTask.getTitle());
                            task.setDescription(updateTask.getDescription());
                            task.setCompleted(updateTask.getCompleted());
                            return taskRepository.save(task);
                        }
                )
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}