package org.jmmo.iterator;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 22:20
 *
 * Single value iterable. It iterator() method always returns singleton iterator.
 */
public class SingletonIterable<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 7550358615656474121L;
    private final T value;

    public SingletonIterable(T value) {
        this.value = value;
    }

    @Override
    public Iterator<T> iterator() {
        return Collections.singletonList(value).iterator();
    }
}
