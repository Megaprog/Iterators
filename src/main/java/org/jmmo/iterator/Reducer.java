package org.jmmo.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.04.2014
 * Time: 11:13
 */
public abstract class Reducer<T, R> {

    public R reduce(R identity, Iterable<T> iterable) {
        return reduce(identity, iterable.iterator());
    }

    public R reduce(R identity, T... ts) {
        return reduce(identity, Arrays.asList(ts));
    }

    public R reduce(R identity, Iterator<T> iterator) {
        R result = identity;
        while (iterator.hasNext()) {
            T element = iterator.next();
            result = accumulate(result, element);
        }
        return result;
    }

    abstract public R accumulate(R r, T t);
}
