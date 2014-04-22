package iterator;

import java.util.Collections;
import java.util.Iterator;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:54
 *
 * Helper class for creating of various iterable
 */
public class Iterators {

    private Iterators() {}

    @SuppressWarnings("unchecked")
    public static <T> Iterable<T> empty() {
        return (Iterable<T>) EmptyIterable.EMPTY_ITERABLE;
    }

    public static <T> Iterable<T> singleton(T value) {
        return new SingletonIterable<T>(value);
    }

    public static <T> Iterable<T> option(T value) {
        return new OptionIterable<T>(value);
    }

    private static class EmptyIterable<T> implements Iterable<T> {
        static final EmptyIterable<Object> EMPTY_ITERABLE = new EmptyIterable<Object>();

        @Override
        public Iterator<T> iterator() {
            return Collections.<T>emptyList().iterator();
        }
    }
}
