package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final static Map<String,FactoryI> factories = new HashMap<>();
    static {
        factories.put(Country.BELARUS,new BelarusianHen.Factory());
        factories.put(Country.MOLDOVA, new MoldovanHen.Factory());
        factories.put(Country.RUSSIA, new RussianHen.Factory());
        factories.put(Country.UKRAINE, new UkrainianHen.Factory());
    }

    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            hen = (Hen) factories.get(country).create();
            return hen;
        }
    }


}
