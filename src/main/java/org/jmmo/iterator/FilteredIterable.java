package org.jmmo.iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 20.01.14
 * Time: 19:27
 *
 * Wrap some iterable and filter its elements
 */
public abstract class FilteredIterable<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 725159759108691978L;
    private final Iterable<T> iterable;

    public FilteredIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public Iterator<T> iterator() {
        return new FilteredIterator<T>(iterable.iterator()) {
            @Override
            public boolean test(T t) {
                return FilteredIterable.this.test(t);
            }
        };
    }

    abstract public boolean test(T t);
}
