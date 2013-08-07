package me.learnings.oracle.concurrency.runners;

import me.learnings.oracle.concurrency.runnables.RunnableTest;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 09/06/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class RunnableRunner {

    public static void main(String[] args){

        new Thread(new RunnableTest()).start();
        System.out.println("Inside Main Runnable");
    }

}
