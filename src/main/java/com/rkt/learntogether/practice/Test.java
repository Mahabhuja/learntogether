package com.rkt.learntogether.practice;

class Test {

    public static boolean  isBalanced(String s){
        if(s.equals("")){
            return true;
        }
        boolean balanced = true;
        char[] cc = s.toCharArray();
        int l = cc.length;
        if(l%2 != 0){
            return false;
        }

        int leftStart = l/2-1;
        int rightStart = leftStart+1;

        char[] left = new char[l/2];
        char[] right = new char[l/2];

        int gg = 0;
        while(leftStart >= 0){
            left[gg]=cc[leftStart];
            leftStart--;
            gg++;
        }

        int kk = 0;
        while(rightStart < l){
            right[kk]=cc[rightStart];
            rightStart++;
            kk++;
        }



        for(int b=0; b<l/2; b++){
            if(left[b]=='(' && right[b]!=')'){
                balanced = false;
                break;
            } else if(left[b]=='{' && right[b]!='}'){
                balanced = false;
                break;
            } else if(left[b]=='}' || left[b]==')'){
                balanced = false;
                break;
            }
        }


        return balanced;
    }

    boolean test(char[] a){
        boolean balanced = true;
        int l = a.length;
        if(l%2 != 0){
            return false;
        }

        int leftStart = l/2-1;
        int rightStart = leftStart+1;

        char[] left = new char[l/2];
        char[] right = new char[l/2];

        int gg = 0;
        while(leftStart >= 0){
            left[gg]=a[leftStart];
            leftStart--;
            gg++;
        }

        int kk = 0;
        while(rightStart < l){
            right[kk]=a[rightStart];
            rightStart++;
            kk++;
        }



        for(int b=0; b<l/2; b++){
            if(left[b]=='(' && right[b]!=')'){
                balanced = false;
                break;
            } else if(left[b]=='{' && right[b]!='}'){
                balanced = false;
                break;
            } else if(left[b]=='}' || left[b]==')'){
                balanced = false;
                break;
            }
        }


        return balanced;
    }

    public static void main(String[] args) {
        String[] s = {"{}()","({()})","{}("};
        for(String a : s){
            System.out.println(isBalanced(a));
        }
    }
}