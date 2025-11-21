package com.app.Todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Todoapp.models.Task;

@Repository 
public interface TaskRepository extends JpaRepository<Task,Long>{

}
