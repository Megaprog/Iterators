package iterator;

import tools.data_structures.Option;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 20.01.14
 * Time: 19:28
 */
public abstract class FilteredIterator<E> implements Iterator<E> {
    private final Iterator<E> iterator;
    private Option<E> nextOption = Option.none();

    public FilteredIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (nextOption.isDefined()) {
            return true;
        }

        while (iterator.hasNext()) {
            final E next = iterator.next();
            if (filter(next)) {
                nextOption = Option.some(next);
                return true;
            }
        }

        return false;
    }

    @Override
    public E next() {
        for (E next : nextOption) {
            nextOption = Option.none();
            return next;
        }

        if (hasNext()) {
            return next();
        }

        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    abstract public boolean filter(E element);
}
