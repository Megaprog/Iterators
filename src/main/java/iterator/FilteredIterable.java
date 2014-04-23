package iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 20.01.14
 * Time: 19:27
 *
 * Wrap some iterable and filter its elements
 */
public abstract class FilteredIterable<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 725159759108691978L;
    private final Iterable<T> iterable;

    public FilteredIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new FilteredIterator<T>(iterable.iterator()) {
            @Override
            public boolean filter(T element) {
                return FilteredIterable.this.filter(element);
            }
        };
    }

    abstract public boolean filter(T element);
}
