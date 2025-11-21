package com.app.Todoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Todoapp.models.Task;
import com.app.Todoapp.repository.TaskRepository;

@Service
public class TodoServices {
    private final TaskRepository taskRepository ;
 
   public TodoServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   public List<Task> getAllTasks(){
     return taskRepository.findAll();
   }

   public void createTask(String title) {
    Task task=new Task();
    task.setTitle(title);
    task.setCompleted(false);
    taskRepository.save(task);

   }

   public void deleteTask(Long id) {
      taskRepository.deleteById(id);
   }

   public void toggleTask(Long id) {
    Task task=taskRepository.findById(id)
             .orElseThrow(() -> new IllegalArgumentException("invalid task id"));
     task.setCompleted(!task.isCompleted());
     taskRepository.save(task);

   }
}
