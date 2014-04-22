package iterator;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:16
 *
 * Contains nullable value. If value is null iterator() returns empty iterator otherwise singleton one.
 */
public class OptionIterable<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -9075964863488796350L;
    private final T value;

    public OptionIterable(T value) {
        this.value = value;
    }

    @Override
    public Iterator<T> iterator() {
        return value == null ? Collections.<T>emptyList().iterator() : Collections.singletonList(value).iterator();
    }
}
