package iterator;

import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.02.14
 * Time: 16:46
 */
public class DoubleIterable<T> implements Iterable<T> {
    private final Iterable<T> iterable1;
    private final Iterable<T> iterable2;

    public DoubleIterable(Iterable<T> iterable1, Iterable<T> iterable2) {
        this.iterable1 = iterable1;
        this.iterable2 = iterable2;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleIterator<T>(iterable1.iterator(), iterable2.iterator());
    }
 }
