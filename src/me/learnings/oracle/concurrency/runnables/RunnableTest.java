package me.learnings.oracle.concurrency.runnables;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 09/06/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class RunnableTest implements Runnable {

    public RunnableTest(){

    }

    @Override
    public void run() {
        System.out.println("Printing from the thread!!!");
    }


}
