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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.templefinder.models.Temple;
import com.dd.templefinder.repository.TempleRepositoryI;

@SpringBootTest(classes=TempleSearchServiceImpl.class)
public class TempleSearchServiceImplTest  {

	@Mock
	TempleRepositoryI templeRepository;

	@InjectMocks
	TempleSearchServiceImpl templeSearchServiceImpl;

	private List<Temple> mockTemples;

	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockTemples = createTestTempleList();
	}

	private List<Temple> createTestTempleList(){
		List<Temple> temples = new ArrayList<>();
		temples.add(new Temple("Ganesh Temple"));
		temples.add(new Temple("Krishna Center"));
		temples.add(new Temple("Shivh Temple"));
		return temples;
	}

	@DataProvider(name = "searchDP")
	Object[][] searchDataProvider() {
		List<Temple> expectedForH_Temple = new ArrayList<>();
		expectedForH_Temple.add(mockTemples.get(0));
		expectedForH_Temple.add(mockTemples.get(2));

		List<Temple> expectedForA = new ArrayList<>();
		expectedForA.add(mockTemples.get(0));
		expectedForA.add(mockTemples.get(1));


		Object[][] res = new Object[][] {
				{"h Temple", expectedForH_Temple},
				{"", mockTemples},
				{"a", expectedForA},
				{"NotInAnyName", new ArrayList<>()}
		};
		return res;
	}

	@Test(dataProvider = "searchDP")
	void testSearchTemples(final String searchStr, List<Temple> expected) throws IOException {
		when(templeRepository.getAllTemples()).thenReturn(mockTemples);
		List<Temple> res = templeSearchServiceImpl.searchTemples(new Temple(searchStr));
		Assert.assertEquals(res, expected);
		verify(templeRepository, atLeastOnce()).getAllTemples();
	}

	@Test
	void testGetAllTemples() throws IOException {
		when(templeRepository.getAllTemples()).thenReturn(mockTemples);
		Assert.assertEquals(templeSearchServiceImpl.getAllTemples(), mockTemples);
		verify(templeRepository, atLeastOnce()).getAllTemples();
	}

}
