package org.jmmo.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 20.01.14
 * Time: 19:28
 */
public abstract class FilteredIterator<E> implements Iterator<E> {
    private final Iterator<E> iterator;
    private Iterator<E> nextOption = Iterators.<E>empty().iterator();

    public FilteredIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
        if (nextOption.hasNext()) {
            return true;
        }

        while (iterator.hasNext()) {
            final E next = iterator.next();
            if (test(next)) {
                nextOption = Iterators.singleton(next).iterator();
                return true;
            }
        }

        return false;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return nextOption.next();
    }

    public void remove() {
        iterator.remove();
    }

    abstract public boolean test(E e);
}
