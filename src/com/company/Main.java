package com.company;

import com.company.Comparators.IntegerComparator;
import com.company.Comparators.NegatedIntegerComparator;
import com.company.Generators.GaussianIntegerGenerator;
import com.company.Generators.RandomIntegerGenerator;
import com.company.Shufflers.RandomShuffler;
import com.company.SortingStrategies.*;
import com.company.SortingTemplates.SortingMoreListsTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        var shuffler = new RandomShuffler<Integer>();
        var comparator = new IntegerComparator();
        var negatedComparator = new NegatedIntegerComparator();
        var amount = 10000;
        var randomIntegerGenerator = new RandomIntegerGenerator();
        var gaussianIntegerGenerator = new GaussianIntegerGenerator();
        var lists = new HashMap<String, List<Integer>>();
        var insertSort = new InsertSort<Integer>();

        var basicList = randomIntegerGenerator.GenerateMany(amount);
        lists.put("basic", basicList);

        insertSort.SetComparator(comparator);
        var ascendingList = shuffler.Shuffle(insertSort.Sort(basicList), amount/10);
        lists.put("ascending", ascendingList);

        insertSort.SetComparator(negatedComparator);
        var descendingList = shuffler.Shuffle(insertSort.Sort(basicList), amount/10);
        lists.put("descending", descendingList);

        var gaussianList = gaussianIntegerGenerator.GenerateMany(amount);
        lists.put("gaussian", gaussianList);

        var template = new SortingMoreListsTemplate<>(lists, comparator);
        ArrayList<SortingStrategyInterface<Integer>> sorts = new ArrayList<>(List.of(
                new BubbleSort<>(),
                new CocktailSort<>(),
                new InsertSort<>(),
                new MergeSort<>(),
                new QuickSort<>(),
                new SelectionSort<>()
        ));
        var durationMap = template.MeasureSorts(sorts);
        Printer.Print(durationMap);
    }
}
