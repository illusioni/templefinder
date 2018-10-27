package com.dd.templefinder.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.dd.templefinder.models.TempleModel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 * Reads json files and loads it to the models
 */
@Repository
public class TempleRepositoryImpl implements TempleRepositoryI {
	
	private TempleModel templeModel;
	
	/* (non-Javadoc)
	 * @see com.dd.templefinder.repository.TempleRepositoryI#getTempleModel()
	 */
	@Override
	public TempleModel getTempleModel() {
		return templeModel;
	}

	/** (non-Javadoc)
	 * @see com.dd.templefinder.repository.TempleRepositoryI#getAllTempleDetails()
	 */
	@Override
	public TempleModel getAllTempleDetails() throws IOException {
		 ObjectMapper objectMapper = new ObjectMapper();
		 File file = ResourceUtils.getFile("classpath:templesData.json");
		 templeModel = objectMapper.readValue(file, TempleModel.class);
		 return templeModel; 
	}

}
