package com.dd.templefinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.dd.templefinder.SumClass;

@SpringBootTest(classes = SumClass.class)
public class TempleSearchServiceImplTest extends AbstractTestNGSpringContextTests {
	
	   @Autowired
	   SumClass sumclass;
	
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

	
}


