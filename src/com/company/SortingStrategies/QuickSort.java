package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort<T> implements SortingStrategyInterface<T> {
    private ComparatorInterface<T> comparator;
    Random r = new Random();

    public QuickSort() {}
    public QuickSort(ComparatorInterface<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public ArrayList<T> Sort(List<T> originalList) {
        if(comparator == null) throw new NullPointerException("no comparator set");
        var list = new ArrayList<>(originalList);
        _sort(list, 0, list.size() - 1);
        return list;
    }

    @Override
    public void SetComparator(ComparatorInterface<T> comparator) {
        this.comparator = comparator;
    }

    private void _sort(ArrayList<T> list, int i, int j) {
        if (j == i) return;
        var oldJ = j;
        var oldI = i;
        var pivot = list.get((j - i) / 2 + i);
        while (i < j) {
            while (comparator.Compare(list.get(i), pivot) == -1) i++;
            while (comparator.Compare(list.get(j), pivot) == 1) j--;
            if (i < j) swap(list, i++, j);
        }
        if (i != oldJ)
            _sort(list, oldI, i);
        if (j != oldI)
            _sort(list, i, oldJ);
    }

    private void swap(ArrayList<T> list, int i, int j) {
        T data = list.get(i);
        list.set(i, list.get(j));
        list.set(j, data);
    }
}
