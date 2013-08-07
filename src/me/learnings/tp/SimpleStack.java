package me.learnings.tp;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 24/06/13
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.LinkedList;



public class SimpleStack<K> implements Stack<K> {

    private LinkedList<K> list;

    public SimpleStack(){

        list = new LinkedList<K>();

    }

    public K push(K item) {list.addFirst(item); return item;}
    public K pop() {return list.removeFirst();}
    public K peek() {return list.getFirst();}
    public int size() {return list.size();}
    public boolean isEmpty() {return list.isEmpty();}
}