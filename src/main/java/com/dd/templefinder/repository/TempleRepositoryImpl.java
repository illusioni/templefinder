package com.dd.templefinder.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private Temple templeModel;
	
	/* (non-Javadoc)
	 * @see com.dd.templefinder.repository.TempleRepositoryI#getTempleModel()
	 */
	@Override
	public Temple getTemple() {
		return templeModel;
	}

	/** (non-Javadoc)
	 * @see com.dd.templefinder.repository.TempleRepositoryI#getAllTempleDetails()
	 */
	@Override
	public Temple getAllTempleDetails() throws IOException {
		 ObjectMapper objectMapper = new ObjectMapper();
		 File file = ResourceUtils.getFile("classpath:templesData.json");
		 templeModel = objectMapper.readValue(file, Temple.class);
		 return templeModel; 
	}

}
