package com.dd.templefinder.repository;

import java.io.IOException;

import com.dd.templefinder.models.Temple;

public interface TempleRepositoryI {

	Temple getTemple();

	/**
	 * 
	 */
	Temple getAllTempleDetails() throws IOException;

}