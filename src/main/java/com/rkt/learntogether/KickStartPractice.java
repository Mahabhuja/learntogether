package com.rkt.learntogether;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.
What is the maximum number of houses you can buy?
* */

 class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = in.nextInt();
        int totalHouses = 0;
        int totalBudget;
        int purchasableHouses;
        int totalPurchasePrice;
        List<Integer> prices;

        for (int i = 1; i <= totalTests; i++) {
            totalHouses = in.nextInt();
            totalBudget = in.nextInt();


            prices = new ArrayList<>();

            for (int j = 0; j < totalHouses; j++) {
                prices.add(in.nextInt());
            }

            Collections.sort(prices);
            totalPurchasePrice = 0;
            purchasableHouses = 0;
            for(int k = 0; k < prices.size(); k++) {
                totalPurchasePrice = totalPurchasePrice + prices.get(k);
                if (totalPurchasePrice <= totalBudget) {
                    purchasableHouses++;
                } else {
                    break;
                }
            }

            System.out.println("case #"+i+": "+purchasableHouses);
        }
    }

}
