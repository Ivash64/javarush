package com.javarush.task.task14.task1411;

import com.javarush.task.task14.task1408.FactoryI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    private static Map<String,FactoryI> persons = new HashMap<>();
    static {
      persons.put("user", new Person.User.Factory());
      persons.put("loser", new Person.Loser.Factory());
      persons.put("coder", new Person.Coder.Factory());
      persons.put("proger", new Person.Proger.Factory());
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();

        while (persons.containsKey(key))
        {
            person = (Person) persons.get(key).create();
            doWork(person); //вызываем doWork
            key = reader.readLine();
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User){
          ((Person.User) person).live();
        }else if(person instanceof Person.Loser){
          ((Person.Loser) person).doNothing();
        }else if (person instanceof Person.Coder){
          ((Person.Coder) person).coding();
        }else if (person instanceof Person.Proger){
          ((Person.Proger) person).enjoy();
        }
    }
}
