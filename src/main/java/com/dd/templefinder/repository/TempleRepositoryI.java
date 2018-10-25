package com.dd.templefinder.repository;

import java.io.IOException;

import com.dd.templefinder.models.TempleModel;

public interface TempleRepositoryI {

	TempleModel getTempleModel();

	/**
	 * 
	 */
	TempleModel getAllTempleDetails() throws IOException;

}