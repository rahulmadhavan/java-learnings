package me.learnings.spoj;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 22/06/13
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeNumberGenerator{


    public static boolean isNumberPrime(int number){

        //divisibility by 2
        if(number == 2)
            return true;
        if(number % 2 == 0){
            return false;
        }else{

            double halfTheNumberd = Math.sqrt(number);
            int halfTheNumber  = (int)Math.round(halfTheNumberd);
            int checkpoint =   halfTheNumber % 2 == 0? halfTheNumber - 1: halfTheNumber;

            for(int i = 3; i <= checkpoint ; i+=2){
                if( number%i == 0 ){
                    return false;
                }
            }
        }

        //number si prime
        return true;
    }


    public static void generatePrimeNumbers3(int number1, int number2){

        int[] is_primes = new int[number2 - number1  + 1];
        // by default all numbers are marked prime

        //simulate sieve form number1 to number2
        for(int p = 2; p * p <= number2; p++){
            int less = number1 / p;
            less = p * less;

            for(int i = less; i <= number2  ;i+=p){
                if(i >= number1 && i != p)
                    is_primes[i - number1] = 1;
            }

        }

        for(int i = 0; i < number2 - number1 + 1;i++){
            if(number1 + i != 1 && is_primes[i] == 0)
                System.out.println(number1 + i);
        }

    }

    public static void generatePrimeNumbers2(int number1, int number2){

        if(number1 <= 3){
            if(number1 <= 2 && number2 >= 2){
                System.out.println(2);
            }
            for(int i = 3; i <= number2 ; i+=2){
                if(isNumberPrime(i)){
                    if(i >= number1)
                        System.out.println(i);
                }
            }

        }else{
            number1  = number1 % 2 == 0? number1 + 1: number1;

            for(int i = number1 ; i <= number2 ; i+=2){
                if(isNumberPrime(i)){
                    if(i >= number1)
                        System.out.println(i);
                }
            }
        }

    }


    public static void generatePrimeNumbers(int number1,int number2){


        for(int i = number1 ; i <= number2; i++){

            if(isNumberPrime(i)){

                System.out.println(i);

            }
        }

    }

    public static void parseInputAndGeneratePrimeNumbers(Scanner scan){

        String inputLine = scan.nextLine();
        String[] inputStringNumbers = inputLine.split(" ");



        int number1 = Integer.parseInt(inputStringNumbers[0]);
        int number2 = Integer.parseInt(inputStringNumbers[1]);

        if(number1 > number2){
            int hold = number1;
            number1 = number2;
            number2 =  hold;
        }

        //generatePrimeNumbers(number1,number2);
        generatePrimeNumbers3(number1,number2);

    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        //scan number of test cases
        int testCounter = 0;
        int numberOfTEstCases = scan.nextInt();
        String inputLine = scan.nextLine();

        while(testCounter < numberOfTEstCases){

            parseInputAndGeneratePrimeNumbers(scan);

            testCounter++;

            if(testCounter < numberOfTEstCases)
                System.out.println();

        }

    }

}
