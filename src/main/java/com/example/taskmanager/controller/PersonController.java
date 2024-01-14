package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Person;
import com.example.taskmanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> persons(@RequestParam (value = "name", required = false) String name){
        if(name == null){
            return personRepository.findAll();
        } else{
            //List<Person> temp = personRepository.findAll().stream().filter(x -> x.getLastName().contains("Nakrani")).f().stream().toList();

            List<Person> temp = personRepository.findAll().stream()
                    .filter(person -> person.getFirstName().toLowerCase().contains(name.toLowerCase())
                                || person.getLastName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());

            return temp;
        }

    }

    @GetMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Person> person(@PathVariable(value = "id") Integer personId){
    return personRepository.findById(personId);
    }

    @PostMapping(value = "/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Person AddPerson(@RequestBody Person person){
        personRepository.save(person);
        return person;
    }

    @DeleteMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeletePerson(@PathVariable(value = "id") Integer id){
        personRepository.deleteById(id);
    }


    @PutMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void PersonUpdate(@RequestBody Person updatedPerson,@PathVariable(value = "id") Integer id){
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

}
