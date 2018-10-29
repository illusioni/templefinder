package com.dd.templefinder.services;

import java.io.IOException;
import java.util.List;

import com.dd.templefinder.models.TempleModel;

public interface TempleSearchServiceI {

	List<TempleModel> getAllTemples() throws IOException;

	TempleModel searchTemplesByName(TempleModel searchModel) throws IOException;

}