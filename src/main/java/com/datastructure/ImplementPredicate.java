package com.datastructure;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImplementPredicate {

  public static final Predicate<String> LENGTH_FIVE = s -> s.length()==5;
  public static final Predicate<String> STARTS_With_S = s -> s.startsWith("S");

  public  String getNamesSatisfyingCondition(Predicate<String> condition, String ... names){
    return Arrays.stream(names)
        .filter(condition)
        .collect(Collectors.joining(", "));
  }
}
