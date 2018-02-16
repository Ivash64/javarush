package com.javarush.task.task18.task1827;

/* 
Прайсы
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) throws Exception {
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

      writeList(fileName,lists);
    }
  }

  private static void deleteLine(ArrayList<String> lists, String id) {
    lists.removeIf(s -> Integer.parseInt(s.substring(0, 8).trim()) == Integer.parseInt(id.substring(0, 8).trim()));
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

  private static void writeList(String fileName, ArrayList<String> lists) {
    try {
      BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
      for (String s: lists){
        fileWriter.write(s);
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




/* Красиове решение но не проходит проверку

public class Solution {
  private static final String LINE_FORMAT = "%-8d%-30s%-8s%-4s";
  private static final String CREATION_KEY = "-c";
  private static final int PRODUCT_NAME = 1;
  private static final int PRICE_INDEX = 2;
  private static final int QUANTITY_INDEX = 3;
  private static final int OPERATION_INDEX = 0;
  private static final int BEGIN_INDEX = 0;
  private static final int END_INDEX = 8;

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String fileName = sc.nextLine();
    new FileReader(fileName).close(); //just to pass the close operation

    Path file = Paths.get(fileName);

    if (CREATION_KEY.equals(args[OPERATION_INDEX])) {

      int maxId = Files.lines(file, StandardCharsets.UTF_8)
          .mapToInt(s -> Integer.parseInt(s.substring(BEGIN_INDEX, END_INDEX).trim()))
          .max()
          .orElse(-1);

      if (maxId >= 0)
        Files.write(file,System.lineSeparator().getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);

      String result = String.format(LINE_FORMAT,
          ++maxId,
          args[PRODUCT_NAME],
          args[PRICE_INDEX],
          args[QUANTITY_INDEX]);

      Files.write(file,
          (result).getBytes(StandardCharsets.UTF_8),
          StandardOpenOption.APPEND);

      //"C:\text.txt"
    }
  }
}
*/