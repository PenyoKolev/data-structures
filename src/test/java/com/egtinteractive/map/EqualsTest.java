package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;
import com.egtinteractive.list.GenericArrayList;
import com.egtinteractive.list.GenericLinkedList;
import com.egtinteractive.map.GenericMap.Node;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

@Test(groups = "map-tests")
public class EqualsTest extends Generator {

    @DataProvider(name = "lists")
    public Object[][] createData() {
	return new Object[][] { { new GenericMap<>(), new GenericMap<>() } };
    }
    
    @Test(dataProvider = "lists")
    public void equalsShouldReturnTrueIfMapsAreEquals(Map<Integer, String> map, Map<Integer, String> map1) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	for (Node<Integer, String> node : map) {
	    map1.put(node.getKey(), node.getValue());
	}
	
	//Act
	boolean isEquals = map.equals(map1);
	
	//Assert
	assertTrue(isEquals);
    }
    
    @Test(dataProvider = "lists")
    public void equalsShouldReturnFalseIfMapsAreNotEquals(Map<Integer, String> map, Map<Integer, String> map1) {
	//Arrange
	int size = ThreadLocalRandom.current().nextInt(1, 100);
	fillMapWithString(size, map);
	for (Node<Integer, String> node : map) {
	    map1.put(node.getKey(), node.getValue());
	}
	int key = ThreadLocalRandom.current().nextInt();
	String value = UUID.randomUUID().toString();
	map.put(key, value);
	
	//Act
	boolean isEquals = map.equals(map1);
	
	//Assert
	assertFalse(isEquals);
    }
}
