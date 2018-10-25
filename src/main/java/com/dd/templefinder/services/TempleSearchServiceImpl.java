package com.dd.templefinder.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dd.templefinder.models.TempleModel;
import com.dd.templefinder.repository.TempleRepositoryI;

/**
 * @author aditya
 *
 */
@Service
public class TempleSearchServiceImpl implements TempleSearchServiceI {
	
	@Autowired
	private TempleRepositoryI templeRepository;
	
	private List<TempleModel> templeModelList = new ArrayList<TempleModel>();
	/* (non-Javadoc)
	 * @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	@Override
	public List<TempleModel> getAllTemples() throws IOException {
		TempleModel templeModel = templeRepository.getAllTempleDetails();
		templeModelList.add(templeModel);
		return templeModelList;
	}
	
    /* (non-Javadoc)
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemplesByName(java.lang.String)
	 */
    @Override
	public List<TempleModel> searchTemplesByName(String searchString){
    	return null;
    }
	
}
