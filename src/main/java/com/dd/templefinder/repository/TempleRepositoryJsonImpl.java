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

		LOG.debug("Repository:getAllTemples()::invoked");

		ObjectMapper objectMapper = new ObjectMapper();
		List<Temple> allTempleList = new ArrayList<Temple>();
		long lStartTime = System.currentTimeMillis();
		File file = ResourceUtils.getFile("classpath:templeData.json");
		allTempleList =  Arrays.asList(objectMapper.readValue(file, Temple[].class));
		allTempleList.stream()
					 .forEach(temple -> { temple.normalize(); });
		long elapsedTime = System.currentTimeMillis() - lStartTime;
		if(LOG.isDebugEnabled()) {
			LOG.debug("Elapsed time in milliseconds to read the JSON file->>" + elapsedTime);
			LOG.debug("File read successfull with ->>" + allTempleList + " temples and the data is::" + allTempleList);
		}

		LOG.info("Repository sucessfully read the temples data");
		LOG.debug("Repository:getAllTemples()::completed");

		return allTempleList;
	}

}
