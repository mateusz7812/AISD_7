package com.company.SortingStrategies;

import com.company.Comparators.ComparatorInterface;
import java.util.ArrayList;
import java.util.List;

public class InsertSort<T> implements SortingStrategyInterface<T> {
    private ComparatorInterface<T> comparator;

    public InsertSort(){ }
    public InsertSort(ComparatorInterface<T> comparator){
        this.comparator = comparator;
    }

    public ArrayList<T> Sort(List<T> originalList){
        if(comparator == null) throw new NullPointerException("no comparator set");
        var list = new ArrayList<>(originalList);
        return new ArrayList<>(_sort(list));
    }

    private List<T> _sort(ArrayList<T> list) {
        int notSortedIndex = 1;
        int indexToMove;
        while(notSortedIndex != list.size()){
            indexToMove = notSortedIndex;
            while (indexToMove!=0 && comparator.Compare(list.get(indexToMove-1), list.get(notSortedIndex)) == 1) indexToMove--;
            if(notSortedIndex != indexToMove) _move(list, notSortedIndex, indexToMove);
            notSortedIndex ++;
        }
        return list;
    }

    @Override
    public void SetComparator(ComparatorInterface<T> comparator) {
        this.comparator = comparator;
    }

    private void _move(List<T> list, int from, int to) {
        list.add(to, list.remove(from));
    }
}
