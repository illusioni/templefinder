package com.dd.templefinder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dd.templefinder.repository.TempleRepositoryI;

@SpringBootApplication
@ComponentScan("com.dd.templefinder")
public class TemplefinderApplication {

	private static final Logger LOG = LogManager.getLogger(TemplefinderApplication.class);

	@Value("${spring.profiles.active}")
	String profile;

	@Autowired
	TempleRepositoryI repo;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TemplefinderApplication.class, args);
		LOG.debug("Temple Finder app bootstraped successfully");
	}
}
