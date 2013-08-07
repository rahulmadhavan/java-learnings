package me.learnings.tp;




/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 24/06/13
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */



public class ReverseStack {

    public static void reverseStack(Stack<Integer> stack){

        if(stack.size() == 0){
            System.out.println("Stack is empty");
            return;
        }
        if(stack.size() == 1){
            System.out.println("Only one element");
            return;
        }
        reverseStackWrapper(stack, -1, stack.size(), stack.size());


    }

    public static void reverseStackWrapper(Stack<Integer> stack,int element,int vsize,int csize){

        if(csize == 1)
            return;
        else
            reverseStackInside(stack,-1,csize,csize);
            reverseStackWrapper(stack,-1,csize - 1, csize -1);
    }

    public static void reverseStackInside(Stack<Integer> stack,int element,int vsize,int csize){

        if(vsize == 1){

            int popEl = stack.pop();
            stack.push(element);
            stack.push(popEl);

        }else{
            int popEl = stack.pop();
            if(element == -1){
                reverseStackInside(stack,popEl,vsize - 1,csize);
            }else{
                reverseStackInside(stack, element, vsize - 1, csize);
                stack.push(popEl);
            }
        }

    }

    public static void printStack(Stack<Integer> stack){
        System.out.println("Size of stack "+ stack.size());

        printStackElements(stack);
        System.out.println();
    }

    public static void printStackElements(Stack<Integer> stack){

        if(stack.isEmpty())
            return;
        else{
            int element = stack.pop();
            System.out.print(element+" ");
            printStackElements(stack);
            stack.push(element);

        }

    }


    public static void main(String[] args){

        Stack<Integer> stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);



        printStack(stack);
        reverseStack(stack);
        printStack(stack);

    }

}

