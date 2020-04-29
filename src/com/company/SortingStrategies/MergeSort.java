package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;
import java.util.ArrayList;
import java.util.List;

public class MergeSort<E> implements SortingStrategyInterface<E> {
    private ComparatorInterface<E> comparator;

    public MergeSort(){}
    public MergeSort(ComparatorInterface<E> comparator) {
        this.comparator = comparator;
    }

    public ArrayList<E> Sort(List<E> list) {
        if(comparator == null) throw new NullPointerException("no comparator set");
        return new ArrayList<>(_sort(list));
    }

    @Override
    public void SetComparator(ComparatorInterface<E> comparator) {
        this.comparator = comparator;
    }

    public List<E> _sort(List<E> list) {
        int middle = list.size() / 2;
        if (list.size() > 1) {
            var list1 = _sort(new ArrayList<>(list.subList(0, middle)));
            var list2 = _sort(new ArrayList<>(list.subList(middle, list.size())));
            return _merge(list1, list2);
        }
        return list;
    }

    private List<E> _merge(List<E> first, List<E> second) {
        var list = new ArrayList<E>();
        while (first.size() > 0 || second.size() > 0) {
            E element;
            if (first.size() > 0 && second.size() > 0) {
                if (comparator.Compare(first.get(0), second.get(0)) < 0) {
                    element = first.remove(0);
                } else {
                    element = second.remove(0);
                }
            } else if (first.size() > 0) {
                element = first.remove(0);
            } else {
                element = second.remove(0);
            }
            list.add(element);
        }
        return list;
    }
}
