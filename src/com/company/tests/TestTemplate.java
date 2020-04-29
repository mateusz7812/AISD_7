package com.company.tests;

import com.company.SortingStrategies.SortingStrategyInterface;
import org.junit.Assert;

import java.util.List;

public class TestTemplate {
    public static void TestMethod1(SortingStrategyInterface<Integer> sortingAlgorithm){
        var integers = List.of(1,2,3);
        var sorted = sortingAlgorithm.Sort(integers);
        Assert.assertArrayEquals(List.of(1,2,3).toArray(), sorted.toArray());
    }

    public static void TestMethod2(SortingStrategyInterface<Integer> sortingAlgorithm){
        var integers = List.of(4,3);
        var sorted = sortingAlgorithm.Sort(integers);
        Assert.assertArrayEquals(List.of(3,4).toArray(), sorted.toArray());
    }

    public static void TestMethod3(SortingStrategyInterface<Integer> sortingAlgorithm){
        List<Integer> originalList = List.of(3, 2, 1);
        var sorted = sortingAlgorithm.Sort(originalList);
        Assert.assertNotSame(originalList, sorted);
    }

    public static void TestMethod4(SortingStrategyInterface<Integer> sortingAlgorithm){
        var sorted = sortingAlgorithm.Sort(List.of(3,3,3,1,5));
        Assert.assertArrayEquals(List.of(1,3,3,3,5).toArray(), sorted.toArray());
    }

    public static void TestMethod5(SortingStrategyInterface<Integer> sortingAlgorithm){
        var sorted = sortingAlgorithm.Sort(List.of(3,2,5,4,7,8,6,9,1));
        Assert.assertArrayEquals(List.of(1,2,3,4,5,6,7,8,9).toArray(), sorted.toArray());
    }
}
