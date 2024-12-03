package com.damascena.Java.Task.Manager.repository;

import com.damascena.Java.Task.Manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
