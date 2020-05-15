package com.rkt.learntogether.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 3. Stock Market Prediction
 *
 */
class Solution5 {

    public static void main(String[] args) {

        //Integer[] a = {89214,26671,75144,32445,13656,66289,21951,10265,59857,59133,63227,86121,37411,54628,25859,43510,63756,54763,30852,53243,76238,96885,33074,17745,81814,43436,79172,92819,30001,68442,54021,35566,95113,29164,84362,25120,11804,6313,51736,71661,81797,14962,57781,35560,85941,99991,95421,66048,54754,26272,35642,47343,39508,85068,65087,21321,28503,60611,30491,58503,29052,84512,94069,40516,13675,78430,65635,25479,1094,17370,13491,99243,48683,71271,34802,34624,87613,46574,671,42366,89197,36313,89708,28704,21380,54795,66376,49882,15405,96867,24737,60808,81378,35157,1324,11404,29938,66958,53234,47384};
        //Integer[] b = {80,24,26,62,46,79,85,59,52,8,76,48,72,84,3,3,30,30,36,86,96,72,93,25,28,68,81,18,78,14,1,57,90,26,18,87,56,55,97,59,62,73,58,85,8,60,87,89,89,22};
        Integer[] a = {10000,10000,10000,10000,10000,10000,10000,10000,10000,10000};
        Integer[] b = {1,2,3,4,5,6,7,8};
        List<Integer> stocks = Arrays.asList(a);
        List<Integer> queries = Arrays.asList(b);
        List<Integer> result = predictAnswer(stocks, queries);
        System.out.println("=====>" + result);
    }

    /*
     * Complete the 'predictAnswer' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stockData
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int desiredIdx;
        Integer qPrice;
        Integer lowerPrice;
        Integer cursor;
        int min = Collections.min(stockData);
        int stockSize = stockData.size();
        for(Integer q : queries){
            desiredIdx = -1;
            qPrice = stockData.get(q-1);
            if(qPrice > min){
                lowerPrice = qPrice + 1;
                cursor = 0;
                while (lowerPrice > qPrice && (((q - cursor - 2) >= 0) || ((q + cursor) < stockSize))) {
                    if (((q - cursor - 2) >= 0) && (stockData.get(q - cursor - 2) < qPrice)) {
                        lowerPrice = stockData.get(q - cursor - 2);
                        desiredIdx = q - cursor - 1;
                    } else if (((q + cursor) < stockSize) && (stockData.get(q + cursor) < qPrice)) {
                        lowerPrice = stockData.get(q + cursor);
                        desiredIdx = q + cursor + 1;
                    }
                    cursor++;
                }
            }
            result.add(desiredIdx);
        }
        return result;
    }

}

/*
In this prediction game, the first player gives the second player some stock market data for some consecutive days.
 The data contains a company's&nbsp;stock price on each day. The rules for the game are:

<ul>
	<li>Player <em>1</em> will tell player <em>2</em> a day number</li>
	<li>player <em>2</em> has to find the nearest day on which stock price is smaller than the given day</li>
	<li>If there are two results, then player <em>2</em>&nbsp;finds the day number which is smaller</li>
	<li>if no such day exists, then the answer is<em>&nbsp;-1.</em>
</li>
</ul>
*/
