package org.jmmo.iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:15
 */
public class RangeIntegerIterable implements Iterable<Integer>, Serializable {
    private static final long serialVersionUID = -2352389096097977717L;
    private final int from;
    private final int to;
    private final int step;

    public RangeIntegerIterable(int from, int to) {
        this(from, to, 1);
    }

    public RangeIntegerIterable(int from, int to, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step cannot be zero");
        }

        this.from = from;
        this.to = to;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIntegerIterator(from, to, step);
    }
}
