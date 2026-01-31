package com.Jan2426Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Jan2426CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jan2426CrudApplication.class, args);
	}

}
