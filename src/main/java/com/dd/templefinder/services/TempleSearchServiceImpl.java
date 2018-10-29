package com.dd.templefinder.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dd.templefinder.models.TempleModel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 *
 */
@Service
public class TempleSearchServiceImpl implements TempleSearchServiceI {


	private List<TempleModel> templeModelList = new ArrayList<TempleModel>();
	ObjectMapper objectMapper = new ObjectMapper();
	/** 
	 * @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	@Override
	public List<TempleModel> getAllTemples() throws IOException {
		File file = ResourceUtils.getFile("classpath:templeData.json");		
		templeModelList = Arrays.asList(objectMapper.readValue(file, TempleModel[].class));
		return templeModelList;
	}

	/** 
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemplesByName(java.lang.String)
	 */
	@Override
	public TempleModel searchTemplesByName(TempleModel searchModel) throws IOException{
		File file = ResourceUtils.getFile("classpath:templeData.json");	
		templeModelList = Arrays.asList(objectMapper.readValue(file, TempleModel[].class));
		Collections.sort(templeModelList);
		int index = Collections.binarySearch(templeModelList, searchModel);
		System.out.println(templeModelList.get(index).getAddressModel().getStreetName());
		return templeModelList.get(index);
	}

}
