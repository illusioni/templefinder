package com.dd.templefinder;

import com.dd.templefinder.repository.TempleRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;


@SpringBootApplication
@ComponentScan("com.dd.templefinder")
public class TemplefinderApplication {


	@Value("${spring.profiles.active}")
	String profile;

	@Autowired
	TempleRepositoryI repo;

	@PostConstruct
	public void printProfileInfo() {
		System.out.println(">>>> " + profile);
		System.out.println(">>>> " + repo.getClass().getName());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TemplefinderApplication.class, args);
	}
}
