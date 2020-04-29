package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort<T> implements SortingStrategyInterface<T> {
    private ComparatorInterface<T> comparator;

    public SelectionSort() {}
    public SelectionSort(ComparatorInterface<T> comparator) {
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

    private void _sort(ArrayList<T> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (comparator.Compare(list.get(j), list.get(min_idx)) == -1)
                    min_idx = j;

            swap(list, i, min_idx);
        }
    }

    private void swap(ArrayList<T> list, int i, int min_idx) {
        T temp = list.get(min_idx);
        list.set(min_idx, list.get(i));
        list.set(i, temp);
    }
}
