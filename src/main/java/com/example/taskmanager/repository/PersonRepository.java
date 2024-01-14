package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}