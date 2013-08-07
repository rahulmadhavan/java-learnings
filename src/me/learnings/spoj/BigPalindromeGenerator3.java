package me.learnings.spoj;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 24/07/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class BigPalindromeGenerator3 {

    static boolean extraDigit = false;

    public static char[] incrementNextPalindrome(char[] nextPalindromeCharacters, int aDigit, int aValue){

//        System.out.println("IN "+aDigit + " : "+aValue);
//        for(int count = 0 ; count < nextPalindromeCharacters.length ; count ++){
//            System.out.print(nextPalindromeCharacters[count]);
//        }
//        System.out.println();

        boolean carry;
        int digit = aDigit;
        int value = aValue;

        do{


            if(digit == -1){
                extraDigit = true;
                break;

            }

            int number = (int)nextPalindromeCharacters[digit] - 48;

            if((number + value) > 9){
                carry = true;
                nextPalindromeCharacters[digit--] = (char)(((number + value) % 10)+ 48);
                value = 1;
            }else{
                nextPalindromeCharacters[digit] = (char)(number + value  + 48);
                carry = false;
            }



        }while(carry);

//        for(int count = 0 ; count < nextPalindromeCharacters.length ; count ++){
//            System.out.print(nextPalindromeCharacters[count]);
//        }
//        System.out.println();

        return nextPalindromeCharacters;

    }


    public static char[] equalizeMirrorDigitsNonRecursive(char[] nextPalindromeCharacters, int digit){

        int length = 0;
        int mirrorNumber = 0;

        if(extraDigit){
            length = nextPalindromeCharacters.length - 2;
        }else{
            length = nextPalindromeCharacters.length - 1;
        }

        for(int aDigit = 0; aDigit <= length/2 ; aDigit++ ){

            for(int iter = 0; iter <  2 ; iter++){

                int number = (int)nextPalindromeCharacters[length - aDigit] - 48;

                mirrorNumber = (int)nextPalindromeCharacters[aDigit] - 48;

//                System.out.println(number + " # " + mirrorNumber);


                if(number == mirrorNumber){

                }else if(number < mirrorNumber){
                    nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharacters,length - aDigit,mirrorNumber-number);
                }else{
                    nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharacters,length - aDigit, 10 + mirrorNumber - number);
                }
            }

        }

        return nextPalindromeCharacters;

    }


    public static char[] generateNextPalindrome(char[] nextPalindromeCharactersArg){

        int mirrorNumber = 0;
        char[] nextPalindromeCharacters = incrementNextPalindrome(nextPalindromeCharactersArg,nextPalindromeCharactersArg.length - 1,1);

        if(extraDigit){
            mirrorNumber = (int)nextPalindromeCharacters[nextPalindromeCharacters.length - 1] - 48;
            if(1 == mirrorNumber){

            }else{
                nextPalindromeCharacters[nextPalindromeCharacters.length - 1] = '1';
            }

        }else{

        }

        //return equalizeMirrorDigits(nextPalindromeCharacters,0);

        return equalizeMirrorDigitsNonRecursive(nextPalindromeCharacters,0);



    }

    public static  void scanAndGenerateNextPalindrome(String line){


        char[] nextPalindromeCharacters = line.toCharArray();




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

        String nextPalindrome = String.valueOf(finalPalindrome);
        String finalNextPalindrome;
        if(extraDigit){
            finalNextPalindrome = "1"+nextPalindrome;
        }else{
            finalNextPalindrome = nextPalindrome;
        }






        System.out.println(finalNextPalindrome);

        after = System.nanoTime();

        System.out.println("time to print next palindrome " + (after - before));



        extraDigit = false;



    }

    public static void scanAndGenerateNextPalindrome(Scanner scan){

        //extract line
        String line = scan.nextLine();

        scanAndGenerateNextPalindrome(line);

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
