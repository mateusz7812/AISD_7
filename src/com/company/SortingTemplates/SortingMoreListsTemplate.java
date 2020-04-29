package com.company.SortingTemplates;

import com.company.Comparators.ComparatorInterface;
import com.company.SortingStrategies.SortingStrategyInterface;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingMoreListsTemplate<T> {
    private Map<String, List<T>> lists;
    private ComparatorInterface<T> comparator;

    public SortingMoreListsTemplate(Map<String, List<T>> lists, ComparatorInterface<T> comparator){
        this.lists = lists;
        this.comparator = comparator;
    }

    public Map<String, Map<SortingStrategyInterface<T>, Duration>> MeasureSorts(List<SortingStrategyInterface<T>> sorts){
        var map = new HashMap<String, Map<SortingStrategyInterface<T>, Duration>>();
        for (var list: lists.entrySet()) {
            var template = new SortingOneListTemplate<>(list.getValue(), comparator);
            var dict = template.MeasureSorts(sorts);
            map.put(list.getKey(), dict);
        }
        return map;
    }
}
