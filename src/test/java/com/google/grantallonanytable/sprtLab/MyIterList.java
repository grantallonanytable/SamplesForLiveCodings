package com.google.grantallonanytable.sprtLab;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyIterList<T> implements Iterator<T> {
    private MyIter<T> myIter;

    public MyIterList(List<Iterator<T>> iterList) {
        this.myIter = (iterList == null || iterList.isEmpty()) ? new MyIter<>(null, null) : composeIterList(iterList);
    }

    private static <T> MyIter<T> composeIterList(List<Iterator<T>> iterList) {
        MyIter<T> res = null;
        for (Iterator<T> iter: iterList) {
            res = new MyIter<>(res, iter);
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return myIter.hasNext();
    }

    @Override
    public T next() throws NoSuchElementException {
        return myIter.next();
    }
}
