package com.yanhanqi.taskhub.repository;

import com.yanhanqi.taskhub.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
