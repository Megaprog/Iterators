package org.jmmo.iterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:15
 */
public class RangeDoubleIterable implements Iterable<Double>, Serializable {
    private static final long serialVersionUID = -1438955194883187198L;
    private final double from;
    private final double to;
    private final double step;

    public RangeDoubleIterable(double from, double to) {
        this(from, to, 1.0);
    }

    public RangeDoubleIterable(double from, double to, double step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public Iterator<Double> iterator() {
        return new RangeDoubleIterator(from, to, step);
    }
}
