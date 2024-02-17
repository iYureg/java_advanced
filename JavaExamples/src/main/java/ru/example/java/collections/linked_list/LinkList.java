package ru.example.java.collections.linked_list;

import java.util.Collection;
import java.util.Iterator;

public class LinkList implements Collection<Integer> {
    private ListNode head, tail;
    private int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail && tail == null;
    }

    @Override
    public boolean contains(Object o) {
        // ...
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        // ...
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer value) {
        if(head == null) {
            head = new ListNode(value, null, null);
            tail = head;
        } else {
            ListNode currentNode = new ListNode(value, head, null);
            ListNode previous = tail;
            tail.setNext(currentNode);
            tail = currentNode;
            tail.setPrevious(previous);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public static void main(String[] args) {
        LinkList myList = new LinkList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println(myList.head.getPrevious());
        System.out.println(myList.head.getValue());
        System.out.println(myList.head.getNext().getValue());

        for (int i = 0; i < 3; i++) System.out.println(".");

        System.out.println(myList.tail.getPrevious().getValue());
        System.out.println(myList.tail.getValue());
        System.out.println(myList.tail.getNext());
    }
}
