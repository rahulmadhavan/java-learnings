package me.learnings.spoj;


import java.lang.String;
import java.lang.System;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 23/07/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class BigPalindromeGenerator2 {

    static boolean extraDigit = false;

    public static char[] incrementNextPalindrome(char[] nextPalindromeCharacters, int aDigit, int aValue){

        int length = nextPalindromeCharacters.length - 1;
        boolean carry;
        int digit = aDigit;
        int value = aValue;

        do{

            int number = (int)nextPalindromeCharacters[digit] - 48;

            if(digit == length){
                extraDigit = true;
                number = 0;
            }

            if((number + value) > 9){
                carry = true;
                nextPalindromeCharacters[digit++] = (char)(((number + value) % 10)+ 48);
                value = 1;
            }else{
                nextPalindromeCharacters[digit] = (char)(number + value  + 48);
                carry = false;
            }



        }while(carry);

        return nextPalindromeCharacters;

    }

    public static char[] equalizeMirrorDigits(char[] nextPalindromeCharacters, int aDigit){

        int number = (int)nextPalindromeCharacters[aDigit] - 48;

        int mirrorNumber = (int)nextPalindromeCharacters[nextPalindromeCharacters.length - 1 - aDigit] - 48;

        if(!extraDigit){
            mirrorNumber  = (int)nextPalindromeCharacters[nextPalindromeCharacters.length - 2 - aDigit] - 48;
        }

        if(number == mirrorNumber){

            if(extraDigit){
                if(aDigit + 1 > (nextPalindromeCharacters.length - 1)/2){
                    return nextPalindromeCharacters;
                }
            }else{
                if(aDigit + 1 > (nextPalindromeCharacters.length - 2)/2){
                    return nextPalindromeCharacters;
                }
            }

            return equalizeMirrorDigits(nextPalindromeCharacters,aDigit + 1);

        }else if(number < mirrorNumber){


            nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharacters,aDigit,mirrorNumber-number);

        }else{

            nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharacters,aDigit, 10 + mirrorNumber - number);
        }

        return equalizeMirrorDigits(nextPalindromeCharacters,aDigit);

    }

    public static char[] equalizeMirrorDigitsNonRecursive(char[] nextPalindromeCharacters, int digit){

        int length = 0;
        int mirrorNumber = 0;

        if(!extraDigit){
            length = nextPalindromeCharacters.length - 2;
        }else{
            length = nextPalindromeCharacters.length - 1;
        }

        for(int aDigit = 0; aDigit <= length/2 ; aDigit++ ){

            for(int iter = 0; iter <  2 ; iter++){

                int number = (int)nextPalindromeCharacters[aDigit] - 48;

                if(extraDigit){
                    length = nextPalindromeCharacters.length - 1;
                    mirrorNumber = (int)nextPalindromeCharacters[nextPalindromeCharacters.length - 1 - aDigit] - 48;
                }else{
                    mirrorNumber = (int)nextPalindromeCharacters[nextPalindromeCharacters.length - 2 - aDigit] - 48;
                }

                if(number == mirrorNumber){

                }else if(number < mirrorNumber){
                    nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharacters,aDigit,mirrorNumber-number);
                }else{
                    nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharacters,aDigit, 10 + mirrorNumber - number);
                }
            }

        }

        return nextPalindromeCharacters;

    }


    public static char[] generateNextPalindrome(char[] nextPalindromeCharactersArg){

        char[] nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharactersArg,0,1);

         //return equalizeMirrorDigits(nextPalindromeCharacters,0);

        return equalizeMirrorDigitsNonRecursive(nextPalindromeCharacters,0);



    }

    public static  void scanAndGenerateNextPalindrome(String line){

        char[] nextPalindromeCharacters = new char[line.length() + 1];
        char[] lineCharacters = line.toCharArray();
        int lineSize = line.length();


        for(int count = 0 ; count < lineSize ; count ++){
            nextPalindromeCharacters[lineSize - 1 - count] = lineCharacters[count];
        }
//        System.out.println("length "+nextPalindromeCharacters.length);
//
//        for(int count = 0 ; count < nextPalindromeCharacters.length ; count ++){
//            System.out.print(nextPalindromeCharacters[count]);
//        }
//        System.out.println();

        long before = System.nanoTime();

        char[] finalPalindrome = generateNextPalindrome(nextPalindromeCharacters);

        long after = System.nanoTime();

        System.out.println("time to find next palindrome " + (after - before));

        before = System.nanoTime();

        for(int count = 0 ; count < finalPalindrome.length ; count ++){
            System.out.print(finalPalindrome[count]);
        }
        System.out.println();

        after = System.nanoTime();

        System.out.println("time to print next palindrome " + (after - before));




        before = System.nanoTime();

        String finalPalindromeString = new StringBuilder(String.valueOf(finalPalindrome)).reverse().toString();

        System.out.println(finalPalindromeString);

        after = System.nanoTime();

        System.out.println("time to print next palindrome 2 " + (after - before));




        extraDigit = false;



    }

    public static void scanAndGenerateNextPalindrome(Scanner scan){

        //extract line
        String line = scan.nextLine();

        scanAndGenerateNextPalindrome(line);

        BigPalindromeGenerator3.scanAndGenerateNextPalindrome(line);

    }




    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        //scan number of test cases
        int testCounter = 0;
        int numberOfTEstCases = scan.nextInt();
        String inputLine = scan.nextLine();

        while(testCounter < numberOfTEstCases){

            scanAndGenerateNextPalindrome(scan);



            testCounter++;



        }


    }

}
