package com.app.Todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Todoapp.models.Task;
import com.app.Todoapp.service.TodoServices;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    
    private final TodoServices todoServices;

    public TaskController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }
     
    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = todoServices.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // renders tasks.html
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        todoServices.createTask(title);
        return "redirect:/tasks"; // was /task (typo)
    }
     
    @GetMapping("/{id}/delete")     
    public String deleteTask(@PathVariable Long id){
        todoServices.deleteTask(id);
        return "redirect:/tasks"; // fixed
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        todoServices.toggleTask(id);
        return "redirect:/tasks"; // fixed
    }
}
