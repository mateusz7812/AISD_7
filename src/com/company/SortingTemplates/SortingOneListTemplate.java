package com.company.SortingTemplates;

import com.company.Comparators.ComparatorInterface;
import com.company.SortingStrategies.SortingStrategyInterface;
import com.company.Timers.Timer;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingOneListTemplate<T> {
    private List<T> list;
    private ComparatorInterface<T> comparator;

    public SortingOneListTemplate(List<T> list, ComparatorInterface<T> comparator){
        this.list = list;
        this.comparator = comparator;
    }

    public Map<SortingStrategyInterface<T>, Duration> MeasureSorts(List<SortingStrategyInterface<T>> sorts) {
        var map = new HashMap<SortingStrategyInterface<T>, Duration>();
        for (var sort : sorts) {
            var timer = new Timer();
            timer.Start();
            sort.SetComparator(comparator);
            List<T> sort1 = sort.Sort(list);
            Duration duration = timer.GetCurrentValue();
            map.put(sort, duration);
        }
        return map;
    }
}
