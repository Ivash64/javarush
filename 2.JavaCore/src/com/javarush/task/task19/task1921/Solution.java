package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        Pattern pattern = Pattern.compile("(\\D+) (\\d+\\s\\d+\\s\\d+)"); /// две группы: имя(1) и дата(2)
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()){
                String  value = reader.readLine();
                Matcher matcher = pattern.matcher(value);
                if (matcher.find()) {
                    PEOPLE.add(new Person(matcher.group(1), dateFormat.parse(matcher.group(2))));
                }
            }
        }
    }
}
