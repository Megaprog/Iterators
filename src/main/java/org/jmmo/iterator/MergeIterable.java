package org.jmmo.iterator;

import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.02.14
 * Time: 16:46
 */
public class MergeIterable<T> implements Iterable<T> {
    private final Iterable<? extends T> iterable1;
    private final Iterable<? extends T> iterable2;

    public MergeIterable(Iterable<? extends T> iterable1, Iterable<? extends T> iterable2) {
        this.iterable1 = iterable1;
        this.iterable2 = iterable2;
    }

    public Iterator<T> iterator() {
        return new MergeIterator<T>(iterable1.iterator(), iterable2.iterator());
    }
 }
