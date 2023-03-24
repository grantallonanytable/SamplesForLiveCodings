package com.google.grantallonanytable.sprtLab;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;

/**
 * Спортмастер.
        Даны два итератора.
        Реализовать итератор, который может объединить два данных итератора:
        позволяет сначала получить элементы из первого, затем из второго.
 */
public class AppTestSprtLab
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMyIter()
    {
        MyIter<Integer> myIter = new MyIter<>(asList(1,2,3,4).iterator(), asList(5,6,7).iterator());
        Assertions.assertTrue(myIter.hasNext());
        Assertions.assertEquals(myIter.next(), 1);
        Assertions.assertEquals(myIter.next(), 2);
        Assertions.assertEquals(myIter.next(), 3);
        Assertions.assertEquals(myIter.next(), 4);
        Assertions.assertTrue(myIter.hasNext()); // 5
        Assertions.assertEquals(myIter.next(), 5);
        Assertions.assertEquals(myIter.next(), 6);
        Assertions.assertEquals(myIter.next(), 7);
        Assertions.assertFalse(myIter.hasNext());
    }

    @Test
    public void testMyIterList()
    {
        MyIterList<Integer> myIter = new MyIterList<>(asList(
                asList(1,2,3,4).iterator(),
                asList(5,6,7).iterator(),
                asList(0,8).iterator(),
                asList(9,10,11,12).iterator()));
        Assertions.assertTrue(myIter.hasNext());
        Assertions.assertEquals(myIter.next(), 1);
        Assertions.assertEquals(myIter.next(), 2);
        Assertions.assertEquals(myIter.next(), 3);
        Assertions.assertEquals(myIter.next(), 4);
        Assertions.assertTrue(myIter.hasNext()); // 5
        Assertions.assertEquals(myIter.next(), 5);
        Assertions.assertEquals(myIter.next(), 6);
        Assertions.assertEquals(myIter.next(), 7);
        Assertions.assertTrue(myIter.hasNext());
        myIter.next(); myIter.next(); // 0,8
        Assertions.assertTrue(myIter.hasNext()); // 9
        Assertions.assertEquals(myIter.next(), 9);
        Assertions.assertEquals(myIter.next(), 10);
        Assertions.assertEquals(myIter.next(), 11);
        Assertions.assertEquals(myIter.next(), 12);
    }
}
