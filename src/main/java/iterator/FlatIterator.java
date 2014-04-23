package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 9:03
 */
public class FlatIterator<I extends Iterator<? extends Iterable<E>>, E> implements Iterator<E> {
    private final I notFlatIterator;
    private Iterator<? extends E> currentIterator = Iterators.<E>empty().iterator();

    public FlatIterator(I notFlatIterator) {
        this.notFlatIterator = notFlatIterator;
    }

    @Override
    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        }

        if (notFlatIterator.hasNext()) {
            currentIterator = notFlatIterator.next().iterator();
            return hasNext();
        }

        return false;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return currentIterator.next();
    }

    @Override
    public void remove() {

    }
}
