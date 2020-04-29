package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;

import java.util.ArrayList;
import java.util.List;

public class CocktailSort<T> implements SortingStrategyInterface<T> {
    private ComparatorInterface<T> comparator;

    public CocktailSort() {}

    public CocktailSort(ComparatorInterface<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public ArrayList<T> Sort(List<T> list) {
        if(comparator == null) throw new NullPointerException("no comparator set");
        var result = new ArrayList<>(list);
        _sort(result);
        return result;
    }

    @Override
    public void SetComparator(ComparatorInterface<T> comparator) {
        this.comparator = comparator;
    }

    void _sort(ArrayList<T> a) {
        boolean swapped = true;
        int start = 0;
        int end = a.size();

        while (swapped) {
            swapped = SortedOnEnd(a, start, end);

            if (!swapped) break;
            end = end - 1;

            swapped = SortedOnStart(a, start, end);

            start = start + 1;
        }
    }

    private boolean SortedOnStart(ArrayList<T> a, int start, int end) {
        boolean swapped;
        swapped = false;
        for (int i = end - 1; i >= start; i--) {
            if (comparator.Compare(a.get(i), a.get(i + 1)) == 1) {
                swap(a, i);
                swapped = true;
            }
        }
        return swapped;
    }

    private boolean SortedOnEnd(ArrayList<T> a, int start, int end) {
        boolean swapped;
        swapped = false;
        for (int i = start; i < end - 1; ++i) {
            if (comparator.Compare(a.get(i), a.get(i + 1)) == 1) {
                swap(a, i);
                swapped = true;
            }
        }
        return swapped;
    }

    private void swap(ArrayList<T> a, int i) {
        T temp = a.get(i);
        a.set(i, a.get(i + 1));
        a.set(i + 1, temp);
    }
}
