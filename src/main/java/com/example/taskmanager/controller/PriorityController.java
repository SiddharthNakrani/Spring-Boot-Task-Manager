package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Priority;
import com.example.taskmanager.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class PriorityController {

    @Autowired
    private PriorityRepository priorityRepository;

    @GetMapping(value = "/priority")
    @ResponseStatus(HttpStatus.OK)
    public List<Priority> priorities(){
        List<Priority> priorities = priorityRepository.findAll();
        return priorities;
    }
    @GetMapping(value = "/priority/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Priority> priority(@PathVariable(value = "id") Integer priorityId){
        return priorityRepository.findById(priorityId);
    }


}
