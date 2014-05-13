package org.jmmo.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.04.2014
 * Time: 14:44
 */
public abstract class Mapper<T, R> {

    public Iterable<R> map(Iterable<T> iterable) {
        return new MappedIterable<T, R>(iterable) {
            @Override
            public R mapper(T t) {
                return Mapper.this.mapper(t);
            }
        };
    }

    public Iterable<R> map(T... ts) {
        return map(Arrays.asList(ts));
    }

    public Iterator<R> map(final Iterator<T> iterator) {
        return new MappedIterator<T, R>(iterator) {
            @Override
            public R mapper(T t) {
                return Mapper.this.mapper(t);
            }
        };
    }

    abstract public R mapper(T t);
}
