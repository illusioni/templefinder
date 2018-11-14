package com.dd.templefinder.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.templefinder.models.Temple;


@Test
public class TempleTest {

	private List<Temple> mockTemples;

	@Mock
	Temple temple;

	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockTemples = createTestTempleList();
	}

	private List<Temple> createTestTempleList(){
		List<Temple> temples = new ArrayList<>();
		temples.add(new Temple("Ganesh Temple","Goethe Straße","02:00-18:00","ganeshtemplegoethestraße02:00-18:00"));
		temples.add(new Temple("Krisna Center","Augsburger Str","15:00-19:00","krisnacenteraugsburgerstr15:00-19:00"));
		temples.add(new Temple("Shivh Temple","Munchner Strasse","16:00-19:00","shivhtemplemunchnerstrasse16:00-19:00"));
		return temples;
	}

	@DataProvider(name = "templesDP")
	Object[][] searchDataProvider() {
		List<Temple> expectedForH_Temple = new ArrayList<>();
		expectedForH_Temple.add(mockTemples.get(0));
		expectedForH_Temple.add(mockTemples.get(2));

		List<Temple> expectedForA = new ArrayList<>();
		expectedForA.add(mockTemples.get(1));


		Object[][] res = new Object[][] {
			{mockTemples.get(0), "ganeshtemplegoethestraße02:00-18:00"},
			{mockTemples.get(1), "krisnacenteraugsburgerstr15:00-19:00"}

		};
		return res;
	}

	@Test(dataProvider = "templesDP")
	void testNormalizeTemple(Temple temple, String expectedStr) throws IOException {
		temple.normalize();
		Assert.assertEquals(temple.getNormalizedString(), expectedStr);
	}
}
