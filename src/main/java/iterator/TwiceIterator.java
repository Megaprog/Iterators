package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:14
 */
public class TwiceIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;
    private Option<Iterator<E>> nextIteratorOption;

    public TwiceIterator(Iterator<E> iterator1, Iterator<E> iterator2) {
        currentIterator = iterator1;
        nextIteratorOption = Option.some(iterator2);
    }

    @Override
    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        }

        for (Iterator<E> nextIterator : nextIteratorOption) {
            currentIterator = nextIterator;
            nextIteratorOption = Option.none();
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