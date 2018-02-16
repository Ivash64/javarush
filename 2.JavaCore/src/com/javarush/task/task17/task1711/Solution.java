package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static DateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static DateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Person person;
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                    for(int i = 1; i < args.length; i += 3)
                        addPerson(args[i+1],args[i],dateFormatIn.parse(args[i+2]));
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i += 4)
                        updatePerson(Integer.valueOf(args[i]), args[i+2], args[i+1], dateFormatIn.parse(args[i+3]));
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i++)
                        deletePerson(Integer.valueOf(args[i]));
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i++)
                        printPerson(Integer.valueOf(args[i]));
                }
                break;
        }
    }

    private static void addPerson(String sex, String name, Date bd){
        Person person =  "м".equals(sex) ?
            Person.createMale(name,bd) :
            Person.createFemale(name,bd);
        allPeople.add(person);
        System.out.println(allPeople.size()-1);
    }

    private static void updatePerson(Integer id, String sex, String name, Date bd) {
        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
        person.setBirthDay(bd);
    }

    private static void deletePerson(Integer id){
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    private static void printPerson(Integer id){
        Person person = allPeople.get(id);
        String sex = person.getSex() != null ?
            (Sex.MALE.equals(person.getSex())?"м":"ж") :
            null;
        String bd = person.getBirthDay() != null ? dateFormatOut.format(person.getBirthDay()): null;
        System.out.println(person.getName()+" "+sex+" "+bd);
    }
}
