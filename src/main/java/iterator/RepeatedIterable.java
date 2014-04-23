package iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 8:32
 */
public class RepeatedIterable<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -2744724903119520628L;
    private final T value;
    private final int times;

    public RepeatedIterable(T value, int times) {
        this.value = value;
        this.times = times;
    }

    @Override
    public Iterator<T> iterator() {
        return new RepeatedIterator<T>(value, times);
    }
}
