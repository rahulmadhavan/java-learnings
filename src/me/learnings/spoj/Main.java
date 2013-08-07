package me.learnings.spoj;

import java.util.Scanner;



public class Main{


    public static void main(String[] args){

        //scan input as int
        Scanner scan = new Scanner(System.in);

        int scannedValue = scan.nextInt();

        //check if input is 42
        while(scannedValue != 42){

            //if not 42 print and rescan
            System.out.println(scannedValue);
            scannedValue = scan.nextInt();

        }

        //if 42 then exit

    }

}