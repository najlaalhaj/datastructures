package com.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StreamsTest {

    @Test

    public void sequentialStreamOf(){
        assertFalse(Stream.of("Najla","Alhaj").isParallel());
    }

    @Test
    public void sequentialStreamIterate(){
        assertFalse(Stream.iterate(0,n ->n+1).isParallel());
    }

    @Test
    public void sequentialStreamGenerate(){
        assertFalse(Stream.generate(Math::random).limit(5).isParallel());
    }
    @Test
    public void sequentialCollectionStream(){
        List<Integer> numbers = Arrays.asList(3,2,1);
        assertFalse(numbers.stream().isParallel());
    }
    @Test
    public void parallelCollectionStream(){
        List<Integer> numbers = Arrays.asList(1,2,3);
        assertTrue(numbers.parallelStream().isParallel());
    }

    @Test
    public void parallelStreamOf(){
        assertTrue(Stream.of(1,2,3).parallel().isParallel());
    }
    @Test
    public void parallelStreamItereate(){
        assertTrue(Stream.iterate(1,n -> n*n).parallel().isParallel());
    }
    @Test
    public void parallelStreamGenerate(){
        assertTrue(Stream.generate(Math::random).parallel().isParallel());
    }
    @Test
    public void parallelThenSequentialCollectionStream(){
        List<Integer> numbers = Arrays.asList(1,2,3);
        assertFalse(numbers.parallelStream().sequential().isParallel());
    }
}
