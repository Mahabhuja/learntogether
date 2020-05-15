package com.rkt.learntogether.practice;

import java.util.HashMap;
import java.util.Map;

public class Solution6 {

    long hashMap(String[] queryType, int[][] query) {

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
                    for(Map.Entry<Integer, Integer> k : m.entrySet()){
                        m.put(k.getKey()+query[i][0], k.getValue());
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

}
