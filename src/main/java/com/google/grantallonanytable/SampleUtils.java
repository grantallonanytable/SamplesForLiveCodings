package com.google.grantallonanytable;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public final class SampleUtils {
    //private static final Logger logger;
    static {
        //logger = LoggerFactory.getLogger(SampleUtils.class);
    }
    private SampleUtils() {}

    public static void findDigit(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        //logger.info(String.format("Lists: %s | %s | %s", listToString(list1), listToString(list2), listToString(list3)));
        System.out.println(String.format("Lists: %s | %s | %s", listToString(list1), listToString(list2), listToString(list3)));
        Set<Integer> set1 = new TreeSet<>(list1);
        Set<Integer> set2 = new TreeSet<>(list2);
        Set<Integer> set3 = new TreeSet<>(list3);
        for (Integer i : set1) {
            if (set2.contains(i) && set3.contains(i)) {
                System.out.println(String.format("digit: %d", i));
                //logger.info("digit: {}", i);
            }
        }
    }

    private static <T> String listToString(Collection<T> data) {
        return data.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
    }
}
