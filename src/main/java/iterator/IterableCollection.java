package iterator;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 22:55
 */
public class IterableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final long serialVersionUID = 9106900366135184965L;
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
