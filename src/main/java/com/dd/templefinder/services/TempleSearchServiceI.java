package com.dd.templefinder.services;

import java.util.List;

import com.dd.templefinder.models.TempleModel;

public interface TempleSearchServiceI {

	List<TempleModel> getAllTemples();

	List<TempleModel> searchTemplesByName(String searchString);

}