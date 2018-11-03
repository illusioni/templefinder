package com.dd.templefinder.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.templefinder.models.Temple;
import com.dd.templefinder.repository.TempleRepositoryI;

/**
 * @author aditya
 *
 */
@Service
public class TempleSearchServiceImpl implements TempleSearchServiceI {


	@Autowired
	public TempleRepositoryI templeRepository;

	/**
	 *  This method will return all the temples data that is
	 *  available in the database
	 *
	 *  @return list of all temples
	 *  @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	
	
	@Override
	public List<Temple> getAllTemples()  {
		List<Temple> allTempleList = new ArrayList<Temple>();
		try {
			allTempleList = templeRepository.getAllTemples();
		} catch (IOException e) {
			// TODO: Need to implement custom Exception class
			e.printStackTrace();
		}
		return allTempleList;
	}

	/**
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemples(Temple)
	 */
	@Override
	public List<Temple> searchTemples(String searchString) throws IOException {
		Stream<Temple> allTemplesStream = templeRepository.getAllTemples().stream();
		Stream<Temple> filteredStream = allTemplesStream
				.filter(t -> (t.getTempleName().toLowerCase()).contains(searchString.toLowerCase()));
		return filteredStream.collect(Collectors.toList());
	}
}
