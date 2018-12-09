package com.streams;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    static List<Book> books;
    static Book book1;
    static Book book2;
    static Book book3;

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
        int sumDoublesDivisableBy3 = IntStream.rangeClosed(1,10)
                .peek(n -> System.out.printf("original : %d%n",n))
                .map(n -> n*2)
                .peek(n ->System.out.printf("doubled : %d%n",n))
                .filter(n -> n%3==0)
                .peek(n -> System.out.printf("filtered %d%n",n))
                .sum();
        System.out.println("The total sum is :"+sumDoublesDivisableBy3);
        book1= new Book(1,"Book1");
       books = Stream.of(book1,book2,book3).collect(Collectors.toList());

       List<Book> books = Stream.of(new Book(1,"Book1"),new Book(2,"Book2"),new Book(3,"Book3"))
               .collect(Collectors.toList());
       HashMap<Integer,Book> bookMap = books.stream()
               .reduce(new HashMap<Integer, Book>(),(map,book) -> {map.put(book.getId(),book);
               return map;
               },(map1,map2) -> {map1.putAll(map2);
               return map1;
               });
       bookMap.forEach((k,v) -> System.out.println("Key : "+k+" Value : "+v.getTitle()));

       String palindrome = "A santa pets rats as Pat taps a star step at NASA";
       String forward = palindrome.toLowerCase().codePoints()
               .filter(Character::isLetterOrDigit)
               .collect(StringBuilder::new,
                       StringBuilder::appendCodePoint,
                       StringBuilder::append)
               .toString();
       String backward = new StringBuilder(forward).reverse().toString();
       System.out.println(forward.equals(backward));
       long counting =palindrome.codePoints()
               .count();
       System.out.println("The total number of characters is : "+counting);
       System.out.println("Number of processors avaialbale is : "+Runtime.getRuntime().availableProcessors());
       List<Integer> numbers = Arrays.asList(13,2,30,400,54,156,78,3,900,1678);
       numbers.parallelStream()
               .map(n -> n*2)
               .sorted()
               .peek(n -> System.out.printf("%s processing %d%n",Thread.currentThread().getName(),n))
               .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static class Book{
        private  int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        Book(int id, String title){
            this.id=id;
            this.title=title;


        }
    }
}

