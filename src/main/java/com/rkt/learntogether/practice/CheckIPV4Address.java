package com.rkt.learntogether.practice;

public class CheckIPV4Address {

    public static void main(String[] args) {
        System.out.println(isIPv4Address("64.233.161.00"));
    }

    static boolean isIPv4Address(String inputString) {
        String[] ip = inputString.split("\\.");
        if (ip.length != 4) {
            return false;
        } else {
            boolean test = false;
            for (String s : ip) {
                try {
                    int x = Integer.parseInt(s);
                    test = ((x>=0) && (x<=255));
                    if(!test || (s.charAt(0) == '0' && s.length()>1))
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }
            return test;
        }
    }

}
