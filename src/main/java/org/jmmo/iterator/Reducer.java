package org.jmmo.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.04.2014
 * Time: 11:13
 */
public abstract class Reducer<T> {

    public T reduce(T identity, Iterable<T> iterable) {
        return reduce(identity, iterable.iterator());
    }

    public T reduce(T identity, Iterator<T> iterator) {
        T result = identity;
        while (iterator.hasNext()) {
            T element = iterator.next();
            result = accumulate(result, element);
        }
        return result;
    }

    public Iterable<T> reduce(T... ts) {
        return reduce(Arrays.asList(ts));
    }

    public Iterable<T> reduce(Iterable<T> iterable) {
        return reduce(iterable.iterator());
    }

    public Iterable<T> reduce(Iterator<T> iterator) {
        boolean foundAny = false;
        T result = null;
        while (iterator.hasNext()) {
            final T element = iterator.next();
            if (!foundAny) {
                foundAny = true;
                result = element;
            }
            else
                result = accumulate(result, element);
        }
        return foundAny ? Iterators.singleton(result) : Iterators.<T>empty();
    }

    abstract public T accumulate(T previous, T current);
}
