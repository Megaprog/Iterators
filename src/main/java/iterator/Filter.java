package iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 24.04.2014
 * Time: 14:58
 */
public abstract class Filter<T> {

    public Iterable<T> filter(Iterable<T> iterable) {
        return new FilteredIterable<T>(iterable) {
            @Override
            public boolean test(T t) {
                return Filter.this.test(t);
            }
        };
    }

    public Iterable<T> filter(T... ts) {
        return filter(Arrays.asList(ts));
    }

    public Iterator<T> filter(Iterator<T> iterator) {
        return new FilteredIterator<T>(iterator) {
            @Override
            public boolean test(T t) {
                return Filter.this.test(t);
            }
        };
    }

    abstract public boolean test(T t);
}
