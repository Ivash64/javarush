package com.javarush.task.task14.task1411;

import com.javarush.task.task14.task1408.FactoryI;

public interface Person {
    class User implements Person {
        void live() {
            System.out.println("Usually I just live.");
        }

        public static class Factory  implements FactoryI<Person> {
            @Override
            public Person create() { return new User();}
        }
    }

    class Loser implements Person {
        void doNothing() {
            System.out.println("Usually I do nothing.");
        }

        public static class Factory  implements FactoryI<Person> {
            @Override
            public Person create() { return new Loser();}
        }
    }

    class Coder implements Person {
        void coding() {
            System.out.println("Usually I create code.");
        }

        public static class Factory  implements FactoryI<Person> {
            @Override
            public Person create() { return new Coder();}
        }
    }

    class Proger implements Person {
        void enjoy() {
            System.out.println("Wonderful life!");
        }

        public static class Factory  implements FactoryI<Person> {
            @Override
            public Person create() { return new Proger();}
        }
    }

}
