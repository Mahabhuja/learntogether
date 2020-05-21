package com.rkt.learntogether.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sequence of integers as an array, determine whether it is possible to obtain a strictly
 * increasing sequence by removing no more than one element from the array.
 *
 * Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an.
 * Sequence containing only one element is also considered to be strictly increasing.
 */
public class AlmostIncreasingSequence {

    public static void main(String[] args) {
        int[] a = {3, 6, 5, 8, 10, 20, 15};
        System.out.print(almostIncreasingSequence(a));
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        int l = sequence.length;
        if (l == 1) {
            return true;
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        boolean fine = true;
        boolean toAdd = true;
        int count = 0;

        for(int i=0; i<l-1; i++) {
            if(sequence[i] >= sequence[i+1]) {
                count++;
                if(count==2) {
                    return false;
                }
                listA.add(sequence[i]);
                listB.add(sequence[i+1]);
                fine = false;
                toAdd = i!=l-2;
                i = i+1;
            } else {
                listA.add(sequence[i]);
                listB.add(sequence[i]);
            }
        }

        if(fine) {
            return true;
        } else {
            if(toAdd) {
                listA.add(sequence[l-1]);
                listB.add(sequence[l-1]);
            }

            System.out.println(listA);
            System.out.println(listB);
            boolean aFine = true;
            boolean bFine = true;

            for(int i=1; i<listA.size(); i++) {
                if(listA.get(i) <= listA.get(i-1)) {
                    aFine = false;
                    break;
                }
            }
            for(int i=1; i<listB.size(); i++) {
                if(listB.get(i) <= listB.get(i-1)) {
                    bFine = false;
                    break;
                }
            }
            if(!aFine && !bFine) {
                return false;
            } else {
                return true;
            }
        }
    }

}
