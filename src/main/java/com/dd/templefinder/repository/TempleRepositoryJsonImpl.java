package com.dd.templefinder.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.dd.templefinder.models.Temple;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 * Reads json files and loads it to the models
 */
@Repository
public class TempleRepositoryJsonImpl implements TempleRepositoryI {

	private static final Logger LOG = LogManager.getLogger(TempleRepositoryJsonImpl.class);
	/** (non-Javadoc)
	 * @see TempleRepositoryI#getAllTemples()
	 */
	@Override
	public List<Temple> getAllTemples() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = ResourceUtils.getFile("classpath:templeData.json");
		List<Temple> allTempleList =  Arrays.asList(objectMapper.readValue(file, Temple[].class));
		allTempleList.stream()
					 .forEach(temple -> { temple.normalize(); });
		return allTempleList;
	}

}
