package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 8:32
 */
public class RepeatedIterator<E> implements Iterator<E> {
    private final E value;
    private final int times;
    private int count;

    public RepeatedIterator(E value, int times) {
        this.value = value;
        this.times = times;
    }

    @Override
    public boolean hasNext() {
        return count < times;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        count++;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
