package com.company.tests;

import com.company.SortingStrategies.InsertSort;
import com.company.Comparators.IntegerComparator;
import org.junit.Test;

import static com.company.tests.TestTemplate.*;

public class TestInsertSort {
    @Test
    public void Tests(){
        var sortingAlgorithm = new InsertSort<>(new IntegerComparator());
        TestMethod1(sortingAlgorithm);
        TestMethod2(sortingAlgorithm);
        TestMethod3(sortingAlgorithm);
        TestMethod4(sortingAlgorithm);
        TestMethod5(sortingAlgorithm);
    }
}
