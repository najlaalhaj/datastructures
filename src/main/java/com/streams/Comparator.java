package com.streams;

import java.util.function.Function;

@FunctionalInterface

public interface Comparator<T> {

    public int comapre(T t1, T t2);

    public static Comparator<Person> comapring(Function<Person,Integer> function){
        return (t1, t2) -> function.apply(t1) - function.apply(t2);
    }
}
