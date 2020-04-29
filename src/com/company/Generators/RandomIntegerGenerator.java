package com.company.Generators;

import java.util.Random;

public class RandomIntegerGenerator implements GeneratorInterface<Integer> {
    Random r = new Random();

    @Override
    public Integer GenerateOne() {
        return r.nextInt();
    }
}
