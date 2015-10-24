package org.jmmo.iterator;

import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.04.2014
 * Time: 11:04
 */
public abstract class MappedIterator<E, R> implements Iterator<R> {
    private final Iterator<E> iterator;

    public MappedIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public R next() {
        return mapper(iterator.next());
    }

    public void remove() {
        iterator.remove();
    }

    abstract public R mapper(E e);
}
