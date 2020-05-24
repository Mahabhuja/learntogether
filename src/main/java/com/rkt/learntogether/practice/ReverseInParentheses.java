package com.rkt.learntogether.practice;

public class ReverseInParentheses {

    public static void main(String[] args) {
        System.out.println(reverseInParentheses("(abc)d(efg)"));
    }

    static String reverseInParentheses(String inputString) {
        char[] c = inputString.toCharArray();
        int start = -1;
        int end = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                start = i;
            } else if (c[i] == ')') {
                end = i;
                if (start != -1 && start < end) {
                    String orig = inputString.substring(start + 1, end);
                    inputString = inputString.replace("("+ orig +")", getReverse(orig));
                    break;
                }
            }
        }
        if (inputString.indexOf('(') < inputString.indexOf(')')) {
            return reverseInParentheses(inputString);
        } else {
            return inputString;
        }


    }

    static String getReverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
