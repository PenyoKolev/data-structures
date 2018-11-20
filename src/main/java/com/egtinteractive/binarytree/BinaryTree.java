package com.egtinteractive.binarytree;

import java.util.Iterator;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    public BinaryTree() {
	root = null;
	size = 0;
    }

    @Override
    public void add(T element) {
	root = insert(root, element);
	size++;
    }

    private Node<T> insert(Node<T> current, T value) {
	if (current == null) {
	    return new Node<T>(value);
	}
	if (current.getValue().compareTo(value) > 0) {
	    current.setLeft(insert(current.getLeft(), value));
	} else if (current.getValue().compareTo(value) < 0) {
	    current.setRight(insert(current.getRight(), value));
	}
	return current;
    }

    @Override
    public boolean remove(T element) {
	int sizeBefore = size;
	delete(root, element);
	return sizeBefore > size ? true : false;
    }

    private Node<T> delete(Node<T> current, T value) {
	if (current.getValue() == value) {
	    if (current.getLeft() == null && current.getRight() == null) {
		size--;
		return null;
	    } else if (current.getLeft() == null) {
		current = current.getRight();
		current.setRight(null);
	    } else if (current.getRight() == null) {
		current = current.getLeft();
		current.setLeft(null);
	    } else {
		Node<T> smallest = smallest(current.getRight());
		current.setValue(smallest.getValue());
		current.setRight(delete(current.getRight(), smallest.getValue()));
	    }
	    size--;
	    return current;
	}
	if (value.compareTo(current.getValue()) < 0) {
	    current.setLeft(delete(current.getLeft(), value));
	} else {
	    current.setRight(delete(current.getRight(), value));
	}
	return current;
    }

    private Node<T> smallest(Node<T> rightTree) {
	if (rightTree.getLeft() == null) {
	    return rightTree;
	} else {
	    return smallest(rightTree.getLeft());
	}
    }

    @Override
    public T lower(T e) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public T higher(T e) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public T pollFirst() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public T pollLast() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean contains(T o) {
	return containsNode(root, o);
    }

    private boolean containsNode(Node<T> current, T value) {
	if (current == null) {
	    return false;
	}
	if (current.getValue() == value) {
	    return true;
	}
	return value.compareTo(current.getValue()) < 0 
		? containsNode(current.getLeft(), value)
		: containsNode(current.getRight(), value);
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public void clear() {
	// TODO Auto-generated method stub
    }

    @Override
    public Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean equals(Object otherObject) {
	// TODO
	return false;
    }

    @Override
    public int hashCode() {
	// TODO
	return 0;
    }

    // Helpers

    
}
