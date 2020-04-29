package com.company;

import com.company.SortingStrategies.SortingStrategyInterface;

import java.time.Duration;
import java.util.Map;

public class Printer {
    public static void Print(Map<String, Map<SortingStrategyInterface<Integer>, Duration>> map) {
        for (var listTest : map.entrySet()) {
            var listName = listTest.getKey();
            var strategyTests = listTest.getValue();

            System.out.println(listName);
            for (var strategyTest : strategyTests.entrySet()) {
                var name = strategyTest.getKey().getClass().getSimpleName();
                var time = strategyTest.getValue().toMillis();
                System.out.printf("%20s  => %8s ms\n", name, time);
            }
            System.out.println();
        }
    }
}
