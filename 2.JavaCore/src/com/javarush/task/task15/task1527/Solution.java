package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            char[] line = reader.readLine().toCharArray();
            List<String> params = new ArrayList<>();
            String param = null;
            String value = null;
            boolean isParamBlock = false;
            boolean isParam = false;
            boolean isValue = false;
            for(int i = 0; i < line.length; i++){
                if(!isParamBlock){
                    if('?' == line[i]) {
                        isParamBlock = true;
                        isParam = true;
                    }
                }else {
                    if('&' == line[i]){
                        if(param != null && !params.contains(param))
                            params.add(param);
                        param = null;
                        isParam = true;
                        isValue = false;
                        continue;
                    }

                    if('=' == line[i]){
                        if(param != null && !params.contains(param))
                            params.add(param);
                        isValue = true;
                        isParam = false;
                        continue;
                    }
                    if (isParam){
                        param = param == null ? String.valueOf(line[i]) : param + line[i];
                    }
                    if (isValue && "obj".equals(param)){
                        value = value == null ? String.valueOf(line[i]) : value + line[i];
                    }
                }
            }
            if(param != null && !params.contains(param))
                params.add(param);
            for( String p: params){
                System.out.print(p);
                System.out.print(" ");
            }
            System.out.print("\n");
            if (value != null) {
                try {
                    alert(Double.valueOf(value));
                } catch (Exception e) {
                    alert(value);
                }
            }
        }catch (IOException ignored){

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
