package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        for(char a: num.toCharArray()){
            if (a % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println(String.format("Even: %d Odd: %d",even,odd));
    }
}
