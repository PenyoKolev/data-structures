package com.egtinteractive.map;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.egtinteractive.Generator;

@Test(groups = "map-tests")
public class ClearTest extends Generator {
    
    @DataProvider(name = "maps")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>() } };
    }
    
    @Test(dataProvider = "maps")
    public void clearShouldEmptyMap(Map<Integer, String> map) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	
	//Act
	map.clear();
	int MapSize = map.size();
	
	//Assert
	assertEquals(MapSize, 0);
    }
}
