package iterator;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 22:55
 */
public class IterableCollection<E> extends AbstractCollection<E> {
    private final Iterable<E> iterable;

    public IterableCollection(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<E> iterator() {
        return iterable.iterator();
    }

    @Override
    public int size() {
        return Iterators.count(iterable);
    }
}
