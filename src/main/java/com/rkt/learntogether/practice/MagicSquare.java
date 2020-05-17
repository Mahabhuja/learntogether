package com.rkt.learntogether.practice;

public class MagicSquare {

    public static void main(String[] args) {
        //int[][] a = {{4,9,2},{3,5,7},{8,1,5}};
        int[][] a = {{4,8,2},{4,5,7},{6,1,6}};

        int i = 010;
        int j = 07;
        System.out.println(i);
        System.out.println(j);
        //formingMagicSquare(a);
    }

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int result = 0;
        result = Math.abs(5 - s[1][1]);

        for(int i=0; i<3; i++){
            int rsum = 0;
            int csum = 0;
            for(int j=0; j<3; j++){
                rsum = rsum + s[i][j];
                csum = csum + s[j][i];
            }
            if(rsum != 15){
                if(s[0][0] %2 == 0){

                } else{

                }
            }

        }

        return 0;
    }
}
