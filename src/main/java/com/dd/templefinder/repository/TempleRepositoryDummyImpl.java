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
		Temple templeOne = new Temple();
		templeOne.setTempleName("Ganesh Temple");
		templeOne.setTempleTimings("15:00-17:00");
		Temple templeTwo = new Temple();
		templeTwo.setTempleName("Krishna Center");
		templeTwo.setTempleTimings("10:00-12:00");
		List<Temple> dummyTemples = new ArrayList<>();
		dummyTemples.add(templeOne);
		dummyTemples.add(templeTwo);
		return dummyTemples;
	}

}
