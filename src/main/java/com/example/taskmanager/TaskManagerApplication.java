package com.example.taskmanager;

import com.example.taskmanager.entity.Person;
import com.example.taskmanager.entity.Status;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  java.sql.*;
@SpringBootApplication
public class 	TaskManagerApplication {



	public static void main(String[] args) {

		SpringApplication.run(TaskManagerApplication.class, args);


	}

//	Status st = new Status(5, "DEAD");


}
