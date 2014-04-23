package iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 9:03
 */
public class FlatIterable<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 3609931161941606302L;
    private final Iterable<? extends Iterable<T>> iterable;

    public FlatIterable(Iterable<? extends Iterable<T>> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new FlatIterator<T>(iterable.iterator());
    }
}
