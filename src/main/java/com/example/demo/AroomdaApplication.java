package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class AroomdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AroomdaApplication.class, args);
	}

}