package com.rkt.learntogether.practice;

import java.util.HashMap;
import java.util.Map;

public class Solution6 {

    static long hashMap(String[] queryType, int[][] query) {

        int l = queryType.length;
        String type = "";
        Map<Integer, Integer> m = new HashMap<>();
        long answer = 0;
        for(int i=0; i<l; i++){
            type = queryType[i];

            switch(type){
                case "insert" :
                    m.put(query[i][0], query[i][1]);
                    break;
                case "addToKey" :
                    Map<Integer, Integer> x = new HashMap<>();
                    for(Map.Entry<Integer, Integer> k : m.entrySet()){
                        x.put(k.getKey()+query[i][0], k.getValue());
                        m = x;
                    }
                    break;
                case "addToValue" :
                    for(Map.Entry<Integer, Integer> k : m.entrySet()){
                        m.put(k.getKey(), k.getValue()+query[i][0]);
                    }
                    break;
                case "get" :
                    answer = answer + m.get(query[i][0]);
                    break;
                default:
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] s  = {"insert",
                "insert",
                "addToValue",
                "addToKey",
                "get"};
        int[][] q = {{1,2},{2,3},{2}, {1}, {3}};
        System.out.println(hashMap(s,q));
    }

}
