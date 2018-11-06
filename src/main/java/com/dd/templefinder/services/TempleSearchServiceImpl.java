package com.dd.templefinder.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Temple> getAllTemples()  {
		LOG.debug("Servcie:getAllTemples()::invoked");
		List<Temple> allTempleList = new ArrayList<Temple>();
		try {
			allTempleList = templeRepository.getAllTemples();
			LOG.info("Repository call is successfull and templelist is returned");

		} catch (IOException e) {
			LOG.warn("Service:GetAllTemples failed with->>" + e);
		}

		LOG.debug("Repository call is successfull with->>" +allTempleList.size()+" temples and the data is::" + allTempleList);
		LOG.debug("Servcie:getAlltemples()::completed");
		return allTempleList;
	}

	/**
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemples(Temple)
	 */
	@Override
	public List<Temple> searchTemples(String searchString) throws IOException {
		LOG.debug("Service:searchTemples()::invoked");

		Stream<Temple> allTemplesStream = templeRepository.getAllTemples().stream();
		Stream<Temple> filteredStream = allTemplesStream
				.filter(t -> (t.getTempleName().toLowerCase()).contains(searchString.toLowerCase()));

		LOG.info(" Repository call is successfull Temples filterted successfully with user input");
		LOG.debug("Service:searchTemples()::completed");
		return filteredStream.collect(Collectors.toList());
	}
}
