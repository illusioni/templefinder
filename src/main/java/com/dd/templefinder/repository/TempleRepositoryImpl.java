package com.dd.templefinder.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.dd.templefinder.models.Temple;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 * Reads json files and loads it to the models
 */
@Repository
public class TempleRepositoryImpl implements TempleRepositoryI {

	/** (non-Javadoc)
	 * @see com.dd.templefinder.repository.TempleRepositoryI#getAllTempleDetails()
	 */
	@Override
	public List<Temple> getAllTemples() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Temple> allTempleList = new ArrayList<Temple>();
		File file = ResourceUtils.getFile("classpath:templeData.json");
		allTempleList =  Arrays.asList(objectMapper.readValue(file, Temple[].class));
		return allTempleList; 
	}

}
