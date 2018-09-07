package com.datastructure;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class ImplementPredicateTest {

  ImplementPredicate demo = new ImplementPredicate();
  String[] names;

@Before
  public void setUp(){
  names = Stream.of("Mal","Wash","Kaylee","Inara","Zoë","Jayne","Simon","River","Shepherd Book")
  .sorted()
  .toArray(String[]::new);
}

@Test
  public void testGetNamesofLenghtFive(){
  assertEquals("Inara, Jayne, River, Simon",demo.getNamesSatisfyingCondition(ImplementPredicate
      .LENGTH_FIVE,names));
}

@Test
  public void testGetNameStartsWithS(){
  assertEquals("Shepherd Book, Simon",demo.getNamesSatisfyingCondition(ImplementPredicate
      .STARTS_With_S,names));
}

@Test
  public void testGetNamesSatisfyingCondition(){
  assertEquals("Inara, Jayne, River, Simon",demo.getNamesSatisfyingCondition(s -> s.length()==5,
      names));
  assertEquals("Shepherd Book, Simon",demo.getNamesSatisfyingCondition(s -> s.startsWith("S"),
      names));
  assertEquals("Shepherd Book, Simon",demo.getNamesSatisfyingCondition(ImplementPredicate
      .STARTS_With_S,names));
  assertEquals("Inara, Jayne, River, Simon",demo.getNamesSatisfyingCondition(ImplementPredicate
      .LENGTH_FIVE,names));
}

@Test
  public void testComposedPredicate(){
  assertEquals("Simon",demo.getNamesSatisfyingCondition(ImplementPredicate.LENGTH_FIVE.and
      (ImplementPredicate.STARTS_With_S),names));
  assertEquals("Inara, Jayne, River, Shepherd Book, Simon",demo.getNamesSatisfyingCondition
      (ImplementPredicate.LENGTH_FIVE.or(ImplementPredicate.STARTS_With_S),names));
  assertEquals("Kaylee, Mal, Shepherd Book, Wash, Zoë",demo.getNamesSatisfyingCondition
      (ImplementPredicate
      .LENGTH_FIVE.negate(),names));
}
}
