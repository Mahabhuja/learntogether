package com.rkt.learntogether.practice;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(mergeStrings("dce","cccbd"));
    }

    static String mergeStrings(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int l1 = a1.length;
        int l2 = a2.length;

        int max = l1+l2;
        StringBuilder sb = new StringBuilder();

        int j = 0;
        int k = 0;

        for(int i=0; i<max; i++){

            if(j<l1 && k<l2) {

                if(occurences(a1[j], a1) < occurences(a2[k], a2)){
                    sb.append(a1[j]);
                    j++;
                }else if(a1[j] < a2[k]){
                    sb.append(a1[j]);
                    j++;
                }else {
                    sb.append(a2[k]);
                    k++;
                }

            }else if(j>=l1){
                sb.append(a2[k]);
                k++;
            } else if(k>=l2) {
                sb.append(a1[j]);
                j++;
            }
        }

        return sb.toString();
    }

    static int occurences(char c, char[] cc){
        int result = 0;
        for(char x : cc){
            if(x==c){
                result++;
            }
        }
        return result;
    }

}
