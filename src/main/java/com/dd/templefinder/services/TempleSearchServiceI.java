package com.dd.templefinder.services;

import java.io.IOException;
import java.util.List;

import com.dd.templefinder.models.Temple;

public interface TempleSearchServiceI {

	List<Temple> getAllTemples() throws IOException;

	Temple searchTemples(Temple searchModel) throws IOException;

}