package com.rkt.learntogether.practice;

/**
 * CODE SIGNAL ARCADE --> 5
 *
 * Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.
 *
 * A 1-interesting polygon is just a square with a side of length 1.
 * An n-interesting polygon is obtained by taking the n - 1-interesting polygon and appending 1-interesting polygons
 * to its rim, side by side. You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
 *
 */
public class ShapeArea {

    public static void main(String[] args) {
        System.out.print("Number of shapes: "+shapeArea(5));
    }

    static int shapeArea(int n) {

        if(n==1) {
            return 1;
        } else if(n==2) {
            return 5;
        } else {
            int result = 0;
            return getResult(result, n);
        }

    }

    static int getResult(int result, int n) {
        if(n > 2) {
            result = getResult(result, n-1) + (4*(n-2) + 4);
        } else if(n == 2) {
            result = result + 5;
        }
        return result;
    }

}

/*
Example
For n = 2, the output should be
shapeArea(n) = 5;
For n = 3, the output should be
shapeArea(n) = 13.

 */