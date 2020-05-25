package com.rkt.learntogether.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given an array of integers representing coordinates of obstacles situated on a straight line.
 * Assume that you are jumping from the point with coordinate 0 to the right.
 * You are allowed only to make jumps of the same length represented by some integer.
 * Find the minimal length of the jump enough to avoid all the obstacles.
 */
public class AvoidObstacles {

    public static void main(String[] args) {
        System.out.println(avoidObstacles(new int[]{5, 3, 6, 7, 9}));
    }

    static int avoidObstacles(int[] inputArray) {
        int jump = 0;
        ArrayList<Integer> a = IntStream.of(inputArray).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(a);
        int max = a.get(a.size()-1);
        for(int i=2; i<max; i++) {
            if(!a.contains(i)) {
                jump = i;
                for(Integer x : a) {
                    if(x%i == 0) {
                        jump = 0;
                        break;
                    }
                }
                if (jump != 0) {
                    break;
                }
            }
        }

        jump = jump == 0 ? max + 1 : jump;

        return jump;
    }

}
