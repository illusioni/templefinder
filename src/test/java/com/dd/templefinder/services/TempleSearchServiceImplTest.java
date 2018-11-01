package com.dd.templefinder.services;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.templefinder.models.Temple;
import com.dd.templefinder.repository.TempleRepositoryI;

@SpringBootTest(classes=TempleSearchServiceImpl.class)
@WebAppConfiguration
@ContextConfiguration
public class TempleSearchServiceImplTest  {

	@Mock
	TempleRepositoryI templeRepository;	

	@InjectMocks
	TempleSearchServiceImpl templeSearchServiceImpl;

	@Spy 
	List<Temple> mockTemples = new ArrayList<Temple>();

	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockTemples = getTempleList();
	}

	@BeforeMethod
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockTemples = getTempleList();
	}

	/*
	 * Data provider function to inject the List of Temples
	 */
	public List<Temple> getTempleList(){
		Temple templeOne = new Temple();
		templeOne.setTempleName("Ganesh Temple");
		templeOne.setTempleTimings("15:00-17:00");
		Temple templeTwo = new Temple();
		templeTwo.setTempleName("Krishna Center");
		templeTwo.setTempleTimings("10:00-12:00");
		mockTemples.add(templeOne);
		mockTemples.add(templeTwo);
		return mockTemples;
	}

	/**
	 * To test the Default search of find all the temples in the city
	 * This data provider is to test the getAll Temple Details
	 * 
	 */
	@DataProvider(name="templeModelProvider")
	Object[][] setTempleDetails(){
		Object[][] res = new Object[2][2];
		Temple templeOne = new Temple();
		templeOne.setTempleName("Ganesh Temple");
		templeOne.setTempleTimings("15:30-18:00");
		Temple templeTwo = new Temple();
		templeTwo.setTempleName("Krishna Center");
		templeTwo.setTempleTimings("10:00-12:00");
		res[0] = new Object[] 
				{mockTemples.get(0),templeOne};
		res[1] = new Object[]
				{mockTemples.get(1),templeTwo};
		return res;
	}

	/** TODO: Need to discuss about the usage of DataProvider
	 * Test to Fetch all the temples data
	 * @throws IOException 

	@Test(dataProvider="templeModelProvider")
	void testGetAllTemples(Temple mockTempleObject,Temple expectedModelObject) throws IOException {
		when(templeRepository.getAllTemples()).thenReturn(mockTemples);
		List<Temple> jsonTemples = templeSearchServiceImpl.getAllTemples();
		Assert.assertEquals(jsonTemples, expectedModelObject.getTempleName());
		Assert.assertEquals(templeSearchServiceImpl.getAllTemples(), mockTemples);

	} */

	/*
	 * To Test the getAllTemples in the service
	 */
	@Test
	void testGetAllTemples() throws IOException {
		when(templeRepository.getAllTemples()).thenReturn(mockTemples);
		Assert.assertEquals(templeSearchServiceImpl.getAllTemples(), mockTemples);
		verify(templeRepository, atLeastOnce()).getAllTemples();
	} 
}
