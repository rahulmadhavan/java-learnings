package me.learnings.oracle.concurrency.runners;

import me.learnings.oracle.concurrency.threads.ThreadTest;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 09/06/13
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadRunner {

    public static void main(String[] args){

        new ThreadTest().start();
        System.out.println("Inside Main Class");


    }
}
