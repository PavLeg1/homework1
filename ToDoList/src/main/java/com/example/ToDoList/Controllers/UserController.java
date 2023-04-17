package com.example.ToDoList.Controllers;

import com.example.ToDoList.Models.User;
import com.example.ToDoList.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public void save(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){
        try{
            User new_user = userService.getUserById(id);
            new_user.updateUser(user);
            userService.saveUser(new_user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
