package com.egtinteractive.binarytree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

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
	Node<T> node = getNode(e);
	if (isValid(node.getLeft())) {
	    node = node.getLeft();
	    node = pollL(node);
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
	    node = pollF(node);
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
	Node<T> node = root;
	if (!isValid(node)) {
	    return null;
	}
	while (node.getLeft() != null) {
	    node = node.getLeft();
	}
	T result = node.getValue();
	remove(result);
	return result;
    }

    private Node<T> pollF(Node<T> node) {
	if (!isValid(node)) {
	    return null;
	}
	while (node.getLeft() != null) {
	    node = node.getLeft();
	}
	Node<T> result = node;
	return result;
    }

    @Override
    public T pollLast() {
	Node<T> node = root;
	if (!isValid(node)) {
	    return null;
	}
	while (node.getRight() != null) {
	    node = node.getRight();
	}
	T result = node.getValue();
	return result;
    }

    private Node<T> pollL(Node<T> node) {
	if (!isValid(node)) {
	    return null;
	}
	while (node.getRight() != null) {
	    node = node.getRight();
	}
	Node<T> result = node;
	return result;
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
	private BinaryTree<T> tree = null;
	private Node<T> last = null;
	private Queue<Node<T>> queue = new ArrayDeque<>();

	public MyIterator(BinaryTree<T> tree) {
	    this.tree = tree;
	    if (tree.root != null) {
		queue.add(tree.root);
	    }
	}

	@Override
	public boolean hasNext() {
	    if (queue.size() > 0) {
		return true;
	    }
	    return false;
	}

	@Override
	public T next() {
	    while (hasNext()) {
		Node<T> n = queue.poll();
		if (n.getLeft() != null) {
		    queue.add(n.getLeft());
		}
		if (n.getRight() != null) {
		    queue.add(n.getRight());
		}
		last = n;
		return n.getValue();
	    }
	    return null;
	}

	@Override
	public void remove() {
	    tree.remove(last.getValue());
	}

    }

    @Override
    public boolean equals(Object otherObject) {
	// TODO
	return false;
    }

    @Override
    public int hashCode() {
	int result = 17;
	Iterator<T> it = iterator();
	while (it.hasNext()) {
	    result = result * 31 + it.next().hashCode();
	}
	return result;
    }

    // Helpers

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
