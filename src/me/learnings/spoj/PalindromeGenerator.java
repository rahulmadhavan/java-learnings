package me.learnings.spoj;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: rahulm
 * Date: 29/06/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeGenerator {


    public static long generateNextPalindrome(String asnumber){

        long scannedNumber = Long.parseLong(asnumber);
        long startNumber = scannedNumber + 1;

        long result = generateNextPalindrome(startNumber);
        return generateNextPalindrome(result);

    }

    public static long generateNextPalindrome(long startNumber){

        long finalNumber = startNumber;
        String snumber = new Long(startNumber).toString();


        int size = snumber.length();
        int limit = size/2;

        for(int i = 0 ; i < limit ; i++){

            int left = snumber.charAt(i) - 48;
            int right = snumber.charAt(size - 1 - i) - 48;

            //System.out.println("left "+left+ " right "+right + " i "+(int)Math.pow(10,i) );

            if(left == right){

            }else if(left > right){

                long multiplier = (long)Math.pow(10,i);
                finalNumber = finalNumber + (left  - right) * multiplier;


            }else if(left < right){

                long multiplier = (long)Math.pow(10,i);
                //System.out.println(finalNumber+ " "+(left + 10  - right) * multiplier);
                finalNumber = finalNumber + (left + 10  - right) * multiplier;
            }

        }


        return finalNumber;

    }
    public static void scanAndGenerateNextPalindrome(Scanner scan){

        String snumber = scan.next();
        long result = generateNextPalindrome(snumber);
        System.out.println(result);


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
