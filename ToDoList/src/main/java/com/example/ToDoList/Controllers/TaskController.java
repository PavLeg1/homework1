package com.example.ToDoList.Controllers;

import com.example.ToDoList.Models.Task;
import com.example.ToDoList.Models.User;
import com.example.ToDoList.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public void save(@RequestBody Task task){
        taskService.saveTask(task);
    }

    @GetMapping("")
    public List<Task> getAll(){
        return taskService.getAllTask();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            Task task = taskService.getTaskById(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable Integer id){
        try {
            Task new_task = taskService.getTaskById(id);
            new_task.updateTask(task);
            taskService.saveTask(new_task);
            return new ResponseEntity<>(new_task, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
