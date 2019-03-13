package com.streams;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) throws InterruptedException{

        List<Integer> ints = Arrays.asList(0,1,2,3,4,-1,-2,-3,-4);
        List<Integer> ints1 = Arrays.asList(0,1,2,3,4);
        List<Integer> ints2 = Arrays.asList(-1,-2,-3,-4);

        BinaryOperator<Integer> opt = (int1,int2) -> Integer.max(int1,int2);

        int reduction1 = ints1.stream().reduce(0,opt);
        int reduction2 = ints2.stream().reduce(0,opt);
        int reduction = Stream.of(reduction1,reduction2).reduce(0,opt);

    System.out.println("Reduction = "+reduction);

    Stream.Builder<String> builder = Stream.builder();
    builder.add("one")
            .add("tow")
            .add("three");
    Stream<String> stream = builder.build();
    stream.forEach(System.out::println);
    Stream<Double> doubleStream = Stream.generate(() -> 1.0*2).limit(5);
    doubleStream.forEach(System.out::println);
    Stream<Integer> integerStream = Stream.iterate(1,n -> n+1).limit(5);
    integerStream.forEach(System.out::println);
    IntStream localThreadStream = ThreadLocalRandom.current().ints().limit(5);
    localThreadStream.forEach(System.out::println);
   Optional<Integer> integer = ints.stream().filter(n -> n < 0).findAny();
    System.out.println(integer);
    Optional<Integer> optionalInt = ints.stream().reduce((a1,a2) -> Integer.max(a1,a2));
    System.out.println(optionalInt);
    Map<Integer,Long> multipuleAssignments =ints.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    System.out.println(multipuleAssignments);
    }
}

