package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> lists = new ArrayList<>();
        while ((line = fileReader.readLine()) != null){
            lists.add(line);
        }
        fileReader.close();
        if (Arrays.asList("-c","-d","-u").contains(args[0])) {
            int begProduct = 1;
            String id = "";
            if (Arrays.asList("-d","-u").contains(args[0])) {
                id = args[1];
                begProduct = 2;
            }
            String price = "";
            String quantity = "";
            String prodactName = "";
            if (Arrays.asList("-c","-u").contains(args[0])) {
                for (int j = begProduct; j < args.length - 2; j++)
                    prodactName = prodactName.concat(args[j]);
                prodactName = prodactName.concat("                              ").substring(0, 30);
                price = args[args.length - 2].concat("        ").substring(0, 8);
                quantity = args[args.length - 1].concat("    ").substring(0, 4);
            }

            if (args[0].equals("-c")) createLine(lists, prodactName, price, quantity);

            if (args[0].equals("-u")) updateLine(lists, id, prodactName, price, quantity);

            if (args[0].equals("-d")) deleteLine(lists, id);

            writeList(fileName,lists,args[0]);
        }
    }

    private static void deleteLine(ArrayList<String> lists, String idIn) {
        String id = String.format("%-8s", idIn);

        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i).startsWith(id)) {
                lists.remove(i);
                break;
            }
        }
        /*for (int i = 0; i < lists.size(); i++) {
            int idName = Integer.parseInt(lists.get(i).substring(0,8).trim());
            if (idName == Integer.parseInt(id.trim())) {
                lists.remove(i);
            }
        }*/
        /*Iterator<String> it = lists.iterator();
        while (it.hasNext()){
            if (Integer.parseInt(it.next().substring(0,8).trim()) == Integer.parseInt(id.trim()))
                it.remove();
        }*/
        //lists.removeIf(s -> Integer.parseInt(s.substring(0, 8).trim()) == Integer.parseInt(id.trim()));
    }

    private static void updateLine(ArrayList<String> lists, String id, String prodactName, String price, String quantity) {
        for (int i = 0; i < lists.size();i++){
            int idName = Integer.parseInt(lists.get(i).substring(0,8).trim());
            if (idName == Integer.parseInt(id.trim())) {
                id = id.concat("        ").substring(0, 8);
                lists.set(i,id.concat(prodactName.concat(price.concat(quantity))));
            }
        }
    }

    private static void writeList(String fileName, ArrayList<String> lists, String arg) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s: lists){
                fileWriter.write(s);
                if (!"-d".equals(arg))
                    fileWriter.newLine();
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createLine(ArrayList<String> lists, String prodactName, String price, String quantity){
        long maxID = Long.MIN_VALUE;

        for (String s: lists){
            int idName = Integer.parseInt(s.substring(0,8).trim());
            if (idName > maxID) maxID = idName;
        }
        String id = String.valueOf(++maxID).concat("        ").substring(0,8);
        String result = id.concat(prodactName.concat(price.concat(quantity)));
        lists.add(result);
    }
}
