package com.egtinteractive.list;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.egtinteractive.map.GenericMap;

public class Generator {

    public void fillListWithIntegers(int size, GenericList<Integer> list) {
	for (int i = 0; i < size; i++) {
	    list.add(ThreadLocalRandom.current().nextInt(1, 100));
	}
    }

    public void fillListWithStrings(int size, GenericList<String> list) {
	for (int i = 0; i < size; i++) {
	    list.add(UUID.randomUUID().toString());
	}
    }

    public void fillMapWithString(int size, GenericMap<Integer, String> map) {
	for (int i = 0; i < size; i++) {
	    int key = ThreadLocalRandom.current().nextInt();
	    String value = UUID.randomUUID().toString();
	    map.put(key, value);
	}
    }
}
