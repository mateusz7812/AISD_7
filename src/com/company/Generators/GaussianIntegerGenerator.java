package com.company.Generators;

import java.util.Random;

public class GaussianIntegerGenerator implements GeneratorInterface<Integer> {
    Random r = new Random();

    @Override
    public Integer GenerateOne() {
        return (int)(r.nextGaussian() * Integer.MAX_VALUE);
    }
}
