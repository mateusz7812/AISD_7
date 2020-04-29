package com.company.Shufflers;

import java.util.ArrayList;
import java.util.List;

public interface ShufflerInterface<T> {
    List<T> Shuffle(ArrayList<T> list, int times);
}
