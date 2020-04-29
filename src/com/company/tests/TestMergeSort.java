package com.company.tests;

import com.company.Comparators.IntegerComparator;
import com.company.SortingStrategies.MergeSort;
import org.junit.Test;

import static com.company.tests.TestTemplate.*;

public class TestMergeSort {
    @Test
    public void Tests(){
        var sortingAlgorithm = new MergeSort<>(new IntegerComparator());
        TestMethod1(sortingAlgorithm);
        TestMethod2(sortingAlgorithm);
        TestMethod3(sortingAlgorithm);
        TestMethod4(sortingAlgorithm);
        TestMethod5(sortingAlgorithm);
    }
}
