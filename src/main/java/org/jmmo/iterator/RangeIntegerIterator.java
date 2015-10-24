package org.jmmo.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:15
 */
public class RangeIntegerIterator implements Iterator<Integer> {
    private final int step;
    private final int limit;
    private final boolean asc;
    private int value;

    public RangeIntegerIterator(int from, int to) {
        this(from, to, 1);
    }

    public RangeIntegerIterator(int from, int to, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step cannot be zero");
        }

        this.step = step;
        this.limit = to;
        this.asc = step > 0;
        this.value = from;
    }

    public boolean hasNext() {
        return asc ? value <= limit : value >= limit;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        final int result = value;
        value += step;
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
