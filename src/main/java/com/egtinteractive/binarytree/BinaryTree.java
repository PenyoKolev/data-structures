package com.egtinteractive.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    private enum Direction {
	GET_LEFT, GET_RIGHT;
    }

    private static class Node<T> {
	private T value;
	private Node<T> left;
	private Node<T> right;

	public Node(T value) {
	    this.value = value;
	    this.left = null;
	    this.right = null;
	}

	public T getValue() {
	    return value;
	}

	public void setValue(T value) {
	    this.value = value;
	}

	public Node<T> getLeft() {
	    return left;
	}

	public void setLeft(Node<T> left) {
	    this.left = left;
	}

	public Node<T> getRight() {
	    return right;
	}

	public void setRight(Node<T> right) {
	    this.right = right;
	}

    }

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
	} else if (current.getValue().compareTo(value) == 0) {
	    size--;
	}
	return current;
    }

    @Override
    public boolean remove(T element) {
	int sizeBefore = size;
	delete(root, element);
	size--;
	return sizeBefore > size;
    }

    private Node<T> delete(Node<T> current, T value) {
	if (current == null) {
	    return current;
	}
	if (current.getValue() == value) {
	    if (current.getLeft() == null && current.getRight() == null) {
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
	Node<T> node = getNode(e);
	if (isValid(node.getLeft())) {
	    node = node.getLeft();
	    return poll(node, Direction.GET_RIGHT);
	} else {
	    node = getParent(e, root, root);
	    while (e.compareTo(node.getValue()) < 0) {
		node = getParent(node.getValue(), root, root);
		if (node == root) {
		    return null;
		}
	    }
	}
	return node.getValue();
    }

    @Override
    public T higher(T e) {
	Node<T> node = getNode(e);
	if (isValid(node.getRight())) {
	    node = node.getRight();
	    return poll(node, Direction.GET_LEFT);
	} else {
	    node = getParent(e, root, root);
	    while (e.compareTo(node.getValue()) > 0) {
		node = getParent(node.getValue(), root, root);
		if (node == root) {
		    if (e.compareTo(node.getValue()) < 0) {
			return node.getValue();
		    }
		    return null;
		}
	    }
	}
	return node.getValue();
    }

    @Override
    public T pollFirst() {
	if (!isValid(root)) {
	    return null;
	}
	T result = poll(root, Direction.GET_LEFT);
	remove(result);
	return result;
    }

    @Override
    public T pollLast() {
	if (!isValid(root)) {
	    return null;
	}
	T result = poll(root, Direction.GET_RIGHT);
	remove(result);
	return result;
    }

    private T poll(Node<T> node, Direction direction) {
	if (direction == Direction.GET_LEFT) {
	    while (node.getLeft() != null) {
		node = node.getLeft();
	    }
	}
	if (direction == Direction.GET_RIGHT) {
	    while (node.getRight() != null) {
		node = node.getRight();
	    }
	}
	return node.getValue();
    }

    @Override
    public boolean contains(T o) {
	Node<T> node = getNode(o);
	if (node != null) {
	    return true;
	}
	return false;
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public void clear() {
	root = null;
	size = 0;
    }

    @Override
    public Iterator<T> iterator() {
	return (new MyIterator(this));
    }

    private class MyIterator implements Iterator<T> {
	private List<T> list = new ArrayList<>();
	int index = -1;

	public MyIterator(BinaryTree<T> tree) {
	    dfs(root, list);
	}

	@Override
	public boolean hasNext() {
	    return index < list.size() - 1;
	}

	@Override
	public T next() {
	    return list.get(++index);
	}

	@Override
	public void remove() {
	    BinaryTree.this.remove(list.get(index));
	}
    }

    @Override
    public boolean equals(Object otherObject) {
	if (this == otherObject) {
	    return true;
	}
	if (otherObject == null) {
	    return false;
	}
	if (!(otherObject instanceof Tree)) {
	    return false;
	}
	@SuppressWarnings("unchecked")
	Tree<T> tree = (Tree<T>) otherObject;
	if (tree.size() != size) {
	    return false;
	}
	Iterator<T> it = tree.iterator();
	while (it.hasNext()) {
	    T current = it.next();
	    if (!contains(current)) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public int hashCode() {
	int result = 17;
	Iterator<T> it = iterator();
	while (it.hasNext()) {
	    result = result * 31 + it.next().hashCode();
	}
	return result + Objects.hashCode(size);
    }

    // Helpers

    private void dfs(Node<T> node, List<T> list) {
	if (node == null) {
	    return;
	}
	dfs(node.getLeft(), list);
	list.add(node.getValue());
	dfs(node.getRight(), list);
    }

    private Node<T> getNode(T value) {
	Node<T> node = root;
	while (isValid(node)) {
	    if (value.compareTo(node.getValue()) < 0) {
		node = node.getLeft();
	    } else if (value.compareTo(node.getValue()) > 0) {
		node = node.getRight();
	    } else if (value.compareTo(node.getValue()) == 0) {
		return node;
	    }
	}
	return null;
    }

    private Node<T> getParent(T value, Node<T> node, Node<T> parent) {
	if (!isValid(node)) {
	    return null;
	}
	if (value.compareTo(node.getValue()) < 0) {
	    return getParent(value, node.getLeft(), node);
	} else if (value.compareTo(node.getValue()) > 0) {
	    return getParent(value, node.getRight(), node);
	} else {
	    return parent;
	}
    }

    private boolean isValid(Node<T> node) {
	if (node != null && node.getValue() != null) {
	    return true;
	}
	return false;
    }
}
