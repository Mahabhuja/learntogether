package com.rkt.learntogether.practice;

import java.util.*;

/**
 * 3. Bus Stand
 *
 */
class Solution4 {

        public static void main(String[] args) {

            Integer[] a = {2, 5, 3};
            Integer[] b = {1, 5};
            List<Integer> p = Arrays.asList(a);
            List<Integer> q = Arrays.asList(b);

            List<Integer> result = kthPerson(3, p, q);
            System.out.println("=====>"+result);
        }

    /*
     * Complete the 'kthPerson' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY p
     *  3. INTEGER_ARRAY q
     */

    public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        int pSize = p.size();
        int tooLate = 99999;

        int capacityCount = 0;
        for(Integer i : q) {
            if(i < tooLate){
                capacityCount = 0;
                for(int j=0; j< pSize; j++) {
                    if(p.get(j) >= i){
                        capacityCount++;
                        if(capacityCount == k){
                            result.add(j+1);
                            break;
                        }
                    }
                }
                if(capacityCount < k){
                    result.add(0);
                    tooLate = i;
                }
            } else {
                result.add(0);
            }
        }
        return result;
    }

}

/*
There are <em>n</em> people standing in a queue for bus numbered from left to right, <em>1</em> to <em>n</em>.
Each person has a patience limit, <em>p </em>and will only wait until the time <em>p</em> expires.
If the bus reaches after time <em>p,</em> the person will leave the queue and miss the bus.
Initially the bus is empty and has a fixed capacity, <em>k</em>.
Given a number of queries <em>q,</em> where each query is a time of bus arrival,
for each query, print the index/number (1-indexed) of the <em>k<sup>th</sup></em>
person who catches the bus. If all passengers remaining in the queue can board the bus,
return <em>0</em> because there will be no <em>k<sup>th</sup></em> person.</span></p>

For example, given a bus size <em>k = 2, </em>patience limits of <em>p = [1, 2, 3, 4]</em>,
and queries at times <em>q = [1, 3, 4]</em>, there are three scenarios all dealing with the same initial queue.
Where the bus arrives at <em>q[0] = 1</em>, all passengers are still queued but only the first two will fit on the bus.
 The last passenger who will fit is number <em>2</em>.
 If the bus arrives at <em>q[1] = 3, </em>passengers <em>1</em>&nbsp;and <em>2</em>&nbsp;have left the queue,
 the first two remaining <em>(3 </em>and <em>4</em>) get on the bus, filling it to capacity.
 When <em>q[2] = 4</em>, passengers <em>1, 2</em>&nbsp;and <em>3</em>&nbsp;have left,
 so passenger <em>4</em>&nbsp;can get on. Since the bus is not filled,
 there is no <em>k<sup>th</sup></em>&nbsp;passenger <em>.</em>&nbsp; T
 he returned array of answers is <em>[2, 4, 0].</em></span></p>

*/
