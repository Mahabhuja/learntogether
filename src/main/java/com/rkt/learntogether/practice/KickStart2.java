package com.rkt.learntogether.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.
What is the maximum number of houses you can buy?
* */

class KickStart2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = in.nextInt();
        int arraySize = 0;
        int countdown = 0;
        for (int i = 1; i <= totalTests; i++) {
            arraySize = in.nextInt();
            countdown = in.nextInt();
            int[] inputArray = new int[arraySize];
            for(int j=0; j<arraySize; j++){
                inputArray[j] = in.nextInt();
            }
            int result = 0;
            for(int k=0; k<inputArray.length; k++){
                if(inputArray[k]==countdown){
                    int q = 1;
                    boolean found = false;
                    while(q < countdown){
                        if(inputArray[k+q] == countdown-q){
                            found = true;
                        } else{
                            found = false;
                            break;
                        }
                        q++;
                    }
                    if(found){
                        result++;
                    }
                }
            }

            System.out.println("case #"+i+": "+result);
        }
    }
}
