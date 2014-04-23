package iterator;

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

    @Override
    public boolean hasNext() {
        if (nextOption.hasNext()) {
            return true;
        }

        while (iterator.hasNext()) {
            final E next = iterator.next();
            if (filter(next)) {
                nextOption = Iterators.singleton(next).iterator();
                return true;
            }
        }

        return false;
    }

    @Override
    public E next() {
        if (nextOption.hasNext()) {
            final E next = nextOption.next();
            nextOption = Iterators.<E>empty().iterator();
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
