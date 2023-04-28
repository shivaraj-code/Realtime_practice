package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;



@EnableElasticsearchRepositories
@ComponentScan
@SpringBootApplication
public class RpmcptCodeSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpmcptCodeSearchApplication.class, args);
	}
	 

}
