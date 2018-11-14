package com.dd.templefinder.repository;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.templefinder.models.Temple;

@SpringBootTest(classes=TempleRepositoryJsonImpl.class)
public class TempleRepositoryJsonImplTest extends AbstractTestNGSpringContextTests{
	
	@Mock
	TempleRepositoryJsonImpl templeRepositoryJsonImpl;
	
	private List<Temple> mockTemples;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockTemples = createTestTempleList();
	}

	private List<Temple> createTestTempleList(){
		List<Temple> temples = new ArrayList<>();
		temples.add(new Temple("Vishnu Temple","Goethe Straße","02:00-18:00","vishnutemplegoethestraße02:00-18:00"));
		temples.add(new Temple("Srirama Temple","Augsburger Str","15:00-19:00","sriramatempleaugsburgerstr15:00-19:00"));
		temples.add(new Temple("Hanuman Temple","Munchner Strasse","16:00-19:00","hanumantemplemunchnerstrasse16:00-19:00"));
		return temples;
	}
	
	@DataProvider(name = "getTemplesDP")
	Object[][] searchDataProvider() {
		Object[][] res = new Object[][] {
			{mockTemples.get(0),"vishnutemplegoethestraße02:00-18:00"},
			{mockTemples.get(1),"sriramatempleaugsburgerstr15:00-19:00"},
			{mockTemples.get(2),"hanumantemplemunchnerstrasse16:00-19:00"},
	};
		return res;
	}

	@Test(dataProvider = "getTemplesDP")
	void testGetAllTemples(Temple temple, String expectedStr) throws IOException {
		when(templeRepositoryJsonImpl.getAllTemples()).thenReturn(mockTemples);
		Assert.assertEquals(templeRepositoryJsonImpl.getAllTemples(), mockTemples);
		Assert.assertEquals(temple.getNormalizedString(), expectedStr);
	}
}
