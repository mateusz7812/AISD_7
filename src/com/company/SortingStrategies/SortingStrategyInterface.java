package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;

import java.util.ArrayList;
import java.util.List;

public interface SortingStrategyInterface<T> {
    public ArrayList<T> Sort(List<T> list);

    void SetComparator(ComparatorInterface<T> comparator);
}
