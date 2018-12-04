package com.egtinteractive;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.egtinteractive.binarytree.Tree;
import com.egtinteractive.list.GenericList;
import com.egtinteractive.map.Map;

public class Generator {

    /*
     * [WARNING] author ivailozd
     * 
     * What's the problem here?
     * 
     */
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

    public void fillMapWithString(int size, Map<Integer, String> map) {
	for (int i = 0; i < size; i++) {
	    int key = ThreadLocalRandom.current().nextInt();
	    String value = UUID.randomUUID().toString();
	    map.put(key, value);
	}
    }

    public void fillTreeWithIntegers(Tree<Integer> tree) {
	int[] numbers = { 38, 13, 51, 10, 12, 40, 84, 25, 89, 37, 66, 95 };
	for (int i : numbers) {
	    tree.add(i);
	}
    }
}
