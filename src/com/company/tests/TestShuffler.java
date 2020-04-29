package com.company.tests;

import com.company.Shufflers.RandomShuffler;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestShuffler {
    @Test
    public void Test1(){
        var integers = new ArrayList<Integer>(List.of(1,2,3));
        var shuffler = new RandomShuffler<Integer>();
        var shuffledTable = shuffler.Shuffle(integers, 1);
        Assert.assertNotEquals(integers.toArray(), shuffledTable.toArray());
    }
}
