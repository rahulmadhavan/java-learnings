package me.learnings.spoj;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 25/06/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransformExpression {

    public static void evaluateExpression(String expression){

        //initialize stack of strings
        Stack<String> stackOfStrings = new Stack<String>();

        char[] expressionArray = expression.toCharArray();
        //traverse each character as a string in the expression
        for( int i = 0; i < expressionArray.length; i++ ){


            if(expressionArray[i] == ')'){

                //if the character is ")" pop 4 times

                //pop get second operand
                String secondOperand = stackOfStrings.pop();
                //pop get operator
                String operator = stackOfStrings.pop();
                //pop get first operand
                String firstOperand = stackOfStrings.pop();
                //pop and remove the "(" character
                stackOfStrings.pop();

                //make result = append first and second operand
                String result = firstOperand+""+secondOperand+""+operator;

                //push result in stack
                stackOfStrings.push(result);

            }else{

                //if the String is not ")" push in stack
                //push sting in stack
                stackOfStrings.push(String.valueOf(expressionArray[i]));

            }

        }

       //pop and return result from stack
       System.out.println(stackOfStrings.pop());

    }


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        //scan number of test cases
        int testCounter = 0;
        int numberOfTEstCases = scan.nextInt();
        String inputLine = scan.nextLine();

        while(testCounter < numberOfTEstCases){

            //scan expressions for all case
            String expression = scan.nextLine();

            // evaluate each expression
            evaluateExpression(expression);

            testCounter++;

        }
    }

}

/*

3
(a+(b*c))
((a+b)*(z+x))
((a+t)*((b+(a+c))^(c+d)))

*/
