package com.company.Comparators;

public class IntegerComparator implements ComparatorInterface<Integer> {
    @Override
    public int Compare(Integer first, Integer second) {
        return Integer.compare(first, second);
    }
}