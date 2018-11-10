package com.dd.templefinder.repository;

import com.dd.templefinder.models.Temple;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aditya
 * Reads json files and loads it to the models
 */
@Repository
public class TempleRepositoryDummyImpl implements TempleRepositoryI {

	/** (non-Javadoc)
	 * @see TempleRepositoryI#getAllTemples()
	 */
	@Override
	public List<Temple> getAllTemples() throws IOException {
		return createDummyTemples();
	}

	private List<Temple> createDummyTemples(){
		Temple templeOne = new Temple("Ganesh Temple","02:00-18:00","Bahnhof Strasse");
		Temple templeTwo = new Temple("Hindu Temple","15:00-19:00","Schwarz Straße");
		List<Temple> dummyTemples = new ArrayList<>();
		dummyTemples.add(templeOne);
		dummyTemples.add(templeTwo);
		dummyTemples.stream()
		 .forEach(temple -> {temple.normalize(); });
		return dummyTemples;
	}

}
