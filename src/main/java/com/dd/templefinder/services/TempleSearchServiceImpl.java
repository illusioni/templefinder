package com.dd.templefinder.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.dd.templefinder.models.TempleModel;

@Service
public class TempleSearchServiceImpl implements TempleSearchServiceI {
	
	/* (non-Javadoc)
	 * @see com.dd.templefinder.services.TempleSearchServiceI#getAllTemples()
	 */
	@Override
	public List<TempleModel> getAllTemples() {
		return null;
	}
	
    /* (non-Javadoc)
	 * @see com.dd.templefinder.services.TempleSearchServiceI#searchTemplesByName(java.lang.String)
	 */
    @Override
	public List<TempleModel> searchTemplesByName(String searchString){
    	return null;
    }
	
}
