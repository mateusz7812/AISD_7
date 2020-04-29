package com.company.Shufflers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShuffler<T> implements ShufflerInterface<T> {
    Random r = new Random();

    @Override
    public List<T> Shuffle(ArrayList<T> originalList, int times) {
        var list = new ArrayList<>(originalList);
        if (times < 0) throw new IllegalArgumentException("value must be grater than 0");
        int size = list.size();
        for (int i = 0; i <= times; i++) {
            var index1 = r.nextInt(size);
            var index2 = r.nextInt(size);
            swap(list, index1, index2);
        }
        return list;
    }

    private void swap(ArrayList<T> list, int index1, int index2) {
        var value = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, value);
    }
}
