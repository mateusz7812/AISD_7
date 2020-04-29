package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort<T> implements SortingStrategyInterface<T> {
    private ComparatorInterface<T> comparator;

    public BubbleSort() { }
    public BubbleSort(ComparatorInterface<T> comparator) {
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
        int lastIndex = list.size() - 1;
        for (int i = 0; i < lastIndex; i++)
            for (int j = 0; j < lastIndex - i; j++)
                if (comparator.Compare(list.get(j), list.get(j + 1)) == 1)
                    swap(list, j);
    }

    private void swap(ArrayList<T> list, int j) {
        T temp = list.get(j);
        list.set(j, list.get(j + 1));
        list.set(j + 1, temp);
    }
}
