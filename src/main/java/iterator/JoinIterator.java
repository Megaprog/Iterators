package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:14
 */
public class JoinIterator<E> implements Iterator<E> {
    private Iterator<? extends E> currentIterator;
    private Iterable<? extends Iterator<? extends E>> nextIteratorOption;

    public JoinIterator(Iterator<? extends E> iterator1, Iterator<? extends E> iterator2) {
        currentIterator = iterator1;
        nextIteratorOption = Iterators.singleton(iterator2);
    }

    @Override
    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        }

        for (Iterator<? extends E> nextIterator : nextIteratorOption) {
            currentIterator = nextIterator;
            nextIteratorOption = Iterators.empty();
            return hasNext();
        }

        return false;
    }

    @Override
    public E next() {
        if (currentIterator.hasNext()) {
            return currentIterator.next();
        }

        if (hasNext()) {
            return next();
        }

        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        currentIterator.remove();
    }
}
