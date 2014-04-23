package iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 9:03
 */
public class FlatIterable<I extends Iterable<? extends Iterable<T>>, T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 3609931161941606302L;
    private final I notFlatIterable;

    public FlatIterable(I notFlatIterable) {
        this.notFlatIterable = notFlatIterable;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
