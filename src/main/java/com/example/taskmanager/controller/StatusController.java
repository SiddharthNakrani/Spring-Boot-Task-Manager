package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Status;
import com.example.taskmanager.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;


    @GetMapping(value = "/status")
    @ResponseStatus(HttpStatus.OK)
    public List<Status> status(){
        List<Status> status = statusRepository.findAll();
        return status;
    }

    @GetMapping(value = "/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Status> status(@PathVariable(value = "id") Integer statusId){
        return statusRepository.findById(statusId);
    }
}
