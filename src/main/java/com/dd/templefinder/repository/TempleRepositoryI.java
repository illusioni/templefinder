package com.dd.templefinder.repository;

import java.io.IOException;
import java.util.List;

import com.dd.templefinder.models.Temple;

public interface TempleRepositoryI {

	List<Temple> getAllTemples() throws IOException;

}