package com.company.tests;

import com.company.Comparators.IntegerComparator;
import com.company.SortingStrategies.QuickSort;
import org.junit.Test;

import static com.company.tests.TestTemplate.*;

public class TestQuickSort {
    @Test
    public void Tests(){
        var sortingAlgorithm = new QuickSort<>(new IntegerComparator());
        TestMethod1(sortingAlgorithm);
        TestMethod2(sortingAlgorithm);
        TestMethod3(sortingAlgorithm);
        TestMethod4(sortingAlgorithm);
        TestMethod5(sortingAlgorithm);
    }
}
