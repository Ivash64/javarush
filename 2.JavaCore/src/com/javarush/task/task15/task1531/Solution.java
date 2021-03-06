package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        return String.valueOf(calcFact(n));
    }

    public static BigInteger calcFact(int n){
        if (n < 0) return BigInteger.ZERO;
        return n > 0? calcFact(n-1).multiply(BigInteger.valueOf(n)): BigInteger.ONE;
    }
}
