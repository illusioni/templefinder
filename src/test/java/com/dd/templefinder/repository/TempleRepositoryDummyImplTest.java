package com.dd.templefinder.repository;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.templefinder.models.Temple;

@SpringBootTest(classes=TempleRepositoryDummyImpl.class)
public class TempleRepositoryDummyImplTest {

	@Mock
	TempleRepositoryDummyImpl templeRepositoryDummyImpl;

	private List<Temple> mockTemples;

	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockTemples = createTestTempleList();
	}

	private List<Temple> createTestTempleList(){
		List<Temple> temples = new ArrayList<>();
		temples.add(new Temple("Vishnu Temple","02:00-18:00","Goethe Straße","vishnutemplegoethestraße02:00-18:00"));
		temples.add(new Temple("Srirama Temple","15:00-19:00","Augsburger Str","sriramatempleaugsburgerstr15:00-19:00"));
		temples.add(new Temple("Hanuman Temple","16:00-19:00","Munchner Strasse","hanumantemplemunchnerstrasse16:00-19:00"));
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
		when(templeRepositoryDummyImpl.getAllTemples()).thenReturn(mockTemples);
		Assert.assertEquals(templeRepositoryDummyImpl.getAllTemples(), mockTemples);
		Assert.assertEquals(temple.getNormalizedString(), expectedStr);
	}

}
