package org.jmmo.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:14
 */
public class MergeIterator<E> implements Iterator<E> {
    private Iterator<? extends E> currentIterator;
    private Iterator<? extends Iterator<? extends E>> nextIteratorOption;

    public MergeIterator(Iterator<? extends E> iterator1, Iterator<? extends E> iterator2) {
        currentIterator = iterator1;
        nextIteratorOption = Iterators.singleton(iterator2).iterator();
    }

    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        }

        if (nextIteratorOption.hasNext()) {
            currentIterator = nextIteratorOption.next();
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
        currentIterator.remove();
    }
}
