package com.hotel.hotel.controllers;

import com.hotel.hotel.models.Facilities;
import com.hotel.hotel.models.Level;
import com.hotel.hotel.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @GetMapping("/")
    public List<Level> getAllLevels() { return levelService.getAllLevels(); }

    @GetMapping("/{id}")
    public ResponseEntity<Level> get(@PathVariable Integer id){
        try{
            Level level = levelService.getLevelById(id);
            return new ResponseEntity<Level>(level, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Level>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ levelService.deleteLevel(id); }

    @PostMapping("/")
    public void add(@RequestBody Level level) { levelService.saveLevel(level); }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Level level, @PathVariable Integer id) {
        try{
            levelService.getLevelById(id);
            level.setId(id);
            levelService.saveLevel(level);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Level>(HttpStatus.NOT_FOUND);
        }
    }
}
