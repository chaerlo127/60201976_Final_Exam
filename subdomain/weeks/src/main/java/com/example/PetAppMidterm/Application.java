package com.example.PetAppMidterm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableAspectJAutoProxy

public class Application {	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}

