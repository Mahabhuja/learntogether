package com.rkt.learntogether.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find out if its characters can be rearranged to form a palindrome.
 *
 * Example
 *
 * For inputString = "aabb", the output should be
 * palindromeRearranging(inputString) = true.
 *
 * We can rearrange "aabb" to make "abba", which is a palindrome.
 */
public class PalindromeRearranging {

    public static void main(String[] args) {
    System.out.println(palindromeRearranging("aabb"));
    }

    static boolean palindromeRearranging(String inputString) {
        int l = inputString.length();
        if (l == 1) {
            return true;
        }
        int diff = 0;
        Map<String, Integer> counts = new HashMap<>();
        for (String s : inputString.split("")) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                diff++;
                counts.put(s, 1);
                if(l%2 == 0) {
                    if (diff > l/2) return false;
                } else {
                    if (diff > (l/2 + 1)) return false;
                }
            }
        }
        if(counts.keySet().size() == 1) return true;

        int odds = 0;
        for(Integer i : counts.values()) {
            if(i%2 != 0) {
                odds++;
            }
            if ((l%2 == 0 && odds == 1) || (l%2 != 0 && odds > 1)) {
                return false;
            }
        }
        return true;
    }

}
