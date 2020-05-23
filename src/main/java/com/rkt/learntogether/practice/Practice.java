package com.rkt.learntogether.practice;

public class Practice {

    public static void main(String[] args) {
        //draw(5);
        System.out.println(isLucky(1230));
    }

    static void draw(int i) {
        if(i == 0) {
            return;
        }
        draw(i-1);
        for (int j = 0; j < i; j++) {
            System.out.print("#");
        }
        System.out.println("");
    }

    static boolean isLucky(int n) {
        String s = Integer.toString(n);
        int l = s.length();
        String s1 = s.substring(0, (l/2));
        String s2 = s.substring(l/2);
        return getSum(s1) == getSum(s2);
    }
    static int getSum(String s) {
        int result = 0;
        for (String a : s.split("")) {
            result = result + Integer.parseInt(a);
        }
        return result;
    }
}
