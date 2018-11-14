package com.dd.templefinder.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.templefinder.commons.AppUtils;
import com.dd.templefinder.controllers.TempleSearchController;
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

	private static final Logger LOG = LogManager.getLogger(TempleSearchServiceImpl.class);

	/**
	 *  This method will return all the temples data that is
	 *  available in the database
	 *
	 *  @return list of all temples
	 *  @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	@Override
	public List<Temple> getAllTemples()  throws IOException{
		List<Temple> allTempleList = templeRepository.getAllTemples();

		if(LOG.isDebugEnabled()) {
			LOG.debug("Repository call is successfull with->>" +allTempleList.size()+" temples and the data is::" + allTempleList);
		}
		return allTempleList;
	}

	/**
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemples(Temple)
	 */
	@Override
	public List<Temple> searchTemples(String searchString) throws IOException {
		String[] searchWords = AppUtils.splitSearch(searchString.trim());
		
		Stream<Temple> allTemplesStream = templeRepository.getAllTemples().stream();
		Stream<Temple> filteredStream = allTemplesStream
				.filter(t -> (this.containsSearchWord(t, searchWords)));
		
		return filteredStream.collect(Collectors.toList());
	}

	private boolean containsSearchWord(Temple t, String[] searchWords) {
		return Arrays.asList(searchWords).stream().anyMatch(w -> t.getNormalizedString().contains(w));
	}
}
