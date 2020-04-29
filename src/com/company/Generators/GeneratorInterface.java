package com.company.Generators;

import java.util.ArrayList;

public interface GeneratorInterface<T> {
    T GenerateOne();

    default ArrayList<T> GenerateMany(int amount) {
        var list = new ArrayList<T>();
        for (int i = 0; i < amount; i++) list.add(GenerateOne());
        return list;
    }
}
