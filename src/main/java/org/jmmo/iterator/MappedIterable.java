package org.jmmo.iterator;

import java.util.Iterator;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 10:58
 */
public abstract class MappedIterable<T, R> implements Iterable<R> {
    private final Iterable<T> iterable;

    public MappedIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<R> iterator() {
        return new MappedIterator<T, R>(iterable.iterator()) {
            @Override
            public R mapper(T t) {
                return MappedIterable.this.mapper(t);
            }
        };
    }

    abstract public R mapper(T t);
}
