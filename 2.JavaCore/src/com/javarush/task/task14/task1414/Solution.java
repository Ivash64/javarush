package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Movie movie;
        String key = reader.readLine();
        movie = MovieFactory.getMovie(key);
        while (Arrays.asList("cartoon", "thriller", "soapOpera").contains(key))
        {
            System.out.println(movie.getClass().getSimpleName());
            key = reader.readLine();
            movie = MovieFactory.getMovie(key);
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }

    static class Thriller extends Movie{

    }
}
