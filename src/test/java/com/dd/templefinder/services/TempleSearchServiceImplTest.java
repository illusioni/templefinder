package com.dd.templefinder.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.templefinder.models.TempleModel;

@SpringBootTest(classes=TempleSearchServiceImpl.class)
public class TempleSearchServiceImplTest extends AbstractTestNGSpringContextTests {

	@Autowired
	TempleSearchServiceI templeSearchServiceImpl ;
	
	List<TempleModel> templeModelList = new ArrayList<TempleModel>();
	/**
	 * To test the Default search of find all the temples in the city
	 * This data provider is to test the getAll Temple Details
	 * 
	 */

	@DataProvider(name="templeModelProvider")
	Object[][] setTempleDetails(){
		Object[][] res = new Object[1][1];
		TempleModel expedctedModel = new TempleModel();
		expedctedModel.setTempleName("Ganesh Temple");
		expedctedModel.setTempleTimings("15:30-18:00");
		res[0] = new Object[] 
				{
						expedctedModel
				};
		return res;
	}
	/**
	 * Test to Fetch all the temples data
	 */
	@Test(dataProvider="templeModelProvider")
	void testGetAllTemples(TempleModel expectedModelObject) {
		try {
			templeModelList = templeSearchServiceImpl.getAllTemples();
			TempleModel tempModel = templeModelList.get(0);
			Assert.assertEquals(tempModel.getTempleName(), expectedModelObject.getTempleName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
