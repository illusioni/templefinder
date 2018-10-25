package com.dd.templefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.dd.templefinder.SumService;

@SpringBootTest(classes = SumService.class)
public class SumServiceImplTest extends AbstractTestNGSpringContextTests {

	@Autowired
	SumService sumclass;

	@Test
	void TestAddNos() {
		int result = sumclass.addNos();
		Assert.assertEquals(result, 5);
	}

	@Test
	void multiplyThem() {
		String stringResult = sumclass.multiplyThem();
		Assert.assertEquals(stringResult, "This is my String");
	}

	@DataProvider(name="addProvider")
	Object[][] addInputs(){
		return new Object[][] {
			{0,0,0},
			{0,1,1},
			{1,1,2},
		};
	}

	@Test(dataProvider="addProvider")
	void addTwoNos(int num1, int num2, int expectedRes) {
		int result = sumclass.addNos(num1, num2);
		Assert.assertEquals(result, expectedRes);
	}
}


