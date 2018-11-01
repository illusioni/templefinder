package com.dd.templefinder.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dd.templefinder.models.Temple;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 *
 */
@Service
public class TempleSearchServiceImpl implements TempleSearchServiceI {

	ObjectMapper objectMapper = new ObjectMapper();
	/** 
	 * @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	@Override
	public List<Temple> getAllTemples() throws IOException {
		List<Temple> templeList = new ArrayList<Temple>();
		File file = ResourceUtils.getFile("classpath:templeData.json");		
		templeList = Arrays.asList(objectMapper.readValue(file, Temple[].class));
		return templeList;
	}

	/** 
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemples(java.lang.String)
	 */
	@Override
	public Temple searchTemples(Temple searchModel) throws IOException{
		List<Temple> templeList = new ArrayList<Temple>();
		File file = ResourceUtils.getFile("classpath:templeData.json");	
		templeList = Arrays.asList(objectMapper.readValue(file, Temple[].class));
		Collections.sort(templeList);
		int index = Collections.binarySearch(templeList, searchModel);
		return templeList.get(index);
	}

}
