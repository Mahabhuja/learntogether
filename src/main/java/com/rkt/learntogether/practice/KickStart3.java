package com.rkt.learntogether.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.
What is the maximum number of houses you can buy?
* */

class KickStart3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = in.nextInt();

        String result = "-1";
        for (int i = 1; i <= totalTests; i++) {
            result = "-1";

            int total = in.nextInt();
            int perTest = in.nextInt();

            for(int j=0; j<total; j++){
                String test = in.next();
                if(test.length()>=4){
                    Character[] aa = new Character[perTest];
                    Set<Character> bb = new HashSet<>();
                    int x =0;
                    for(char c: test.toCharArray()){
                        if(!bb.contains(c)) {
                            aa[x] = c;
                            x++;
                            bb.add(c);
                        }
                    }
                    if(aa.length>=4){
                        result = aa[0].toString() + aa[1].toString() + aa[2].toString() + aa[3].toString();
                        break;
                    }
                }
            }

            System.out.println("case #"+i+": "+result);
        }
    }
}
