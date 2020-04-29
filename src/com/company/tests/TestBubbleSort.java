package com.company.tests;

import com.company.Comparators.IntegerComparator;
import com.company.SortingStrategies.BubbleSort;
import org.junit.Test;

import static com.company.tests.TestTemplate.*;

public class TestBubbleSort {
    @Test
    public void Tests(){
        var sortingAlgorithm = new BubbleSort<>(new IntegerComparator());
        TestMethod1(sortingAlgorithm);
        TestMethod2(sortingAlgorithm);
        TestMethod3(sortingAlgorithm);
        TestMethod4(sortingAlgorithm);
        TestMethod5(sortingAlgorithm);
    }
}
