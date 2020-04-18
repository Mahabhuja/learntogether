package com.rkt.learntogether;

public class Practice {

    public static void main(String[] args) {
        draw(5);
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
}
