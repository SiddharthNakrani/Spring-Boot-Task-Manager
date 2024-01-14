package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Person;
import com.example.taskmanager.entity.Status;
import com.example.taskmanager.repository.StatusRepository;
import com.example.taskmanager.repository.TaskRepository;
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

//    @PostMapping(value = "/status")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void AddStatus(@RequestBody Status newStatus){
//        statusRepository.save(newStatus);
//    }
//
//    @DeleteMapping(value = "/status/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void DeleteStatus(@PathVariable(value = "id") Integer id){
//        statusRepository.deleteById(id);
//    }
//
//    @PutMapping("/status/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void StatusUpdate(@RequestBody Status updatedStatus,@PathVariable(value = "id") Integer id){
//        updatedStatus.setId(id);
//        statusRepository.save(updatedStatus);
//    }
}
