package com.company.Comparators;

public class NegatedIntegerComparator extends IntegerComparator {
    @Override
    public int Compare(Integer first, Integer second) {
        return super.Compare(first, second) * -1;
    }
}
