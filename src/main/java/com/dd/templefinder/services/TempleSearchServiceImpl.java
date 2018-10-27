package com.dd.templefinder.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dd.templefinder.models.TempleModel;
import com.dd.templefinder.repository.TempleRepositoryI;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 *
 */
@Service
public class TempleSearchServiceImpl implements TempleSearchServiceI {


	private List<TempleModel> templeModelList = new ArrayList<TempleModel>();
	/** 
	 * @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	@Override
	public List<TempleModel> getAllTemples() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = ResourceUtils.getFile("classpath:templesData.json");
		TempleModel templeModel = objectMapper.readValue(file, TempleModel.class);
		templeModelList.add(templeModel);
		return templeModelList;
	}

	/** 
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemplesByName(java.lang.String)
	 */
	@Override
	public List<TempleModel> searchTemplesByName(String searchString){
		return null;
	}

}
