package com.io.codesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.TimeZone;

@EnableSecurity
@SpringBootApplication(scanBasePackages = {"com.io.codesystem"})
public class CodesystemSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodesystemSearchApplication.class, args);
	}

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		System.out.println("Current time "+ LocalDateTime.now());
	}
}
