package com.example.ToDoList.Services;

import com.example.ToDoList.Models.Task;
import com.example.ToDoList.Repositories.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    public void saveTask(Task task){
        taskRepo.save(task);
    }

    public Task getTaskById(Integer id){
        return taskRepo.findById(id).get();
    }

    public void deleteTaskById(Integer id){taskRepo.deleteById(id);}

    public List<Task> getTaskByName(String name) {
        return taskRepo.findByName(name);
    }

}
