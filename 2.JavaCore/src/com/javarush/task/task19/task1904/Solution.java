package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {

        /*PersonScanner person = new PersonScannerAdapter(new Scanner(System.in));
        Person person1 = person.read();
        System.out.println(person1);*/
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String [] fioAndBd = fileScanner.nextLine().split(" ",4);

            return new Person(fioAndBd[1],fioAndBd[2],fioAndBd[0],new SimpleDateFormat("dd MM yyyy").parse(fioAndBd[3]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
