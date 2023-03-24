package com.google.grantallonanytable.sprtLab;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIter<T> implements Iterator<T> {
    private Iterator<T> iter1;
    private Iterator<T> iter2;

    public MyIter(Iterator<T> iter1, Iterator<T> iter2) {
        this.iter1 = iter1 == null ? Collections.emptyListIterator() : iter1;
        this.iter2 = iter2 == null ? Collections.emptyListIterator() : iter2;
    }

    @Override
    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }

    @Override
    public T next() throws NoSuchElementException {
        return iter1.hasNext() ? iter1.next() : iter2.next();
    }
}
