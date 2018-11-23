package com.egtinteractive.map;

import org.testng.annotations.Test;

import com.egtinteractive.Generator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

public class HashCodeTest extends Generator {
  
  GenericMap<Integer, String> map;
  GenericMap<Integer, String> map1;


  @BeforeClass
  public void beforeClass() {
	map = new GenericMap<>();
	map1 = new GenericMap<>();
	fillMapWithString(10, map);
	for (MapEntry<Integer, String> entry : map) {
	    map1.put(entry.getKey(), entry.getValue());
	}
  }
  
  @Test
  public void hashCode_shouldReturnSameCode_forEqualMaps() {
      //Act
      int hash = map.hashCode();
      int hash1 = map1.hashCode();
      
      //Assert
      assertEquals(hash, hash1);
  }
}
