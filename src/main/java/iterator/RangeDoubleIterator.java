package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:15
 */
public class RangeDoubleIterator implements Iterator<Double> {
    private final double step;
    private final double limit;
    private final boolean asc;
    private double value;

    public RangeDoubleIterator(double from, double to) {
        this(from, to, 1.0);
    }

    public RangeDoubleIterator(double from, double to, double step) {
        this.step = step;
        this.limit = to;
        this.asc = step > 0.0;
        this.value = from;
    }

    @Override
    public boolean hasNext() {
        return asc ? value <= limit : value >= limit;
    }

    @Override
    public Double next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        final double result = value;
        value += step;
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
