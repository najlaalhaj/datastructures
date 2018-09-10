package com.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    // creating stream using Stream interface static factory functions
    public static void main(String[] args) {

        String names = Stream.of("Najla", "Mohamed", "Alhaj", "Hamad").collect(Collectors.joining(" "));
        System.out.println(names);

        List<Integer> number = Stream.iterate(1,n -> n+1).limit(3).collect(Collectors.toList());
        System.out.println(number);
        Stream.iterate(LocalDate.now(),ld -> ld.plusDays(1)).limit(3).forEach(System.out:: println);
        Stream.generate(Math::random).limit(3).forEach(System.out::println);
        String[] name = {"Nagla","Werme"};
        String myName= Arrays.stream(name).collect(Collectors.joining(" " ));
        System.out.println(myName);
         LongStream.of(12, 13, 14, 15).boxed().collect(Collectors.toList()).forEach(System.out::println);

         //map - filter then reduce : to apply opertaions on primitive streams like sum and average ...ect

        String[] strings = "This is an array of strings".split((" "));
        long count= Arrays.stream(strings)
                .map(String::length)
                .count();
        System.out.println(count);
        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
        System.out.println(totalLength);

        OptionalDouble average= Arrays.stream(strings)
                .mapToInt(String::length)
                .average();
        System.out.println(average);

        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max();
        System.out.println(max);

        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();
        System.out.println(min);

        int prod =Arrays.stream(strings)
                .mapToInt(String::length)
                .reduce((x,y) -> x*y).orElse(0);
        System.out.println(prod);

    }

}

