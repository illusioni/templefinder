package com.dd.templefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.dd.templefinder")
public class TemplefinderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TemplefinderApplication.class, args);
	}
	
}
