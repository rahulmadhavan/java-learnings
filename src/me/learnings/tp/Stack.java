package me.learnings.tp;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 24/06/13
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Stack<K> {

    /**
     * Adds the given item to the top of the stack.
     */
    K push(K item);

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    K pop();

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    K peek();

    /**
     * Returns the number of items currently in the stack.
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty();
}