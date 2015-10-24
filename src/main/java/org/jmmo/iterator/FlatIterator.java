package org.jmmo.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 9:03
 */
public class FlatIterator<E> implements Iterator<E> {
    private final Iterator<? extends Iterable<E>> iterator;
    private Iterator<? extends E> currentIterator = Iterators.<E>empty().iterator();

    public FlatIterator(Iterator<? extends Iterable<E>> iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        }

        if (iterator.hasNext()) {
            currentIterator = iterator.next().iterator();
            return hasNext();
        }

        return false;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return currentIterator.next();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
