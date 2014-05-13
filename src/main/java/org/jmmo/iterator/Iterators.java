package org.jmmo.iterator;

import java.util.*;

/**
 * User: Tomas
 * Date: 22.04.2014
 * Time: 21:54
 *
 * Helper class for creating of various iterable
 */
public class Iterators {

    private Iterators() {}

    public static <T> int count(Iterable<T> iterable) {
        int count = 0;
        for (T element : iterable) {
            count++;
        }
        return count;
    }

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

    public static Iterable<Integer> range(int from, int to) {
        return range(from, to, 1);
    }

    public static Iterable<Integer> range(int from, int to, int step) {
        return new RangeIntegerIterable(from, to, step);
    }

    public static Iterable<Double> range(double from, double to) {
        return range(from, to, 1.0);
    }

    public static Iterable<Double> range(double from, double to, double step) {
        return new RangeDoubleIterable(from, to, step);
    }

    public static <T> Iterable<T> merge(Iterable<? extends T> iterable1, Iterable<? extends T> iterable2) {
        return new MergeIterable<T>(iterable1, iterable2);
    }

    public static <T> Iterable<T> repeat(T value, int times) {
        return new RepeatedIterable<T>(value, times);
    }

    public static <T> Iterable<T> flat(Iterable<? extends Iterable<T>> iterable) {
        return new FlatIterable<T>(iterable);
    }

    public static <T> Collection<T> collection(Iterable<T> iterable) {
        return new IterableCollection<T>(iterable);
    }

    public static <C extends Collection<E>, E> C toCollection(Iterable<? extends E> iterable, C collection) {
        for (E element : iterable) {
            collection.add(element);
        }
        return collection;
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        return toList(iterable, new ArrayList<E>());
    }

    public static <E> List<E> toList(Iterable<? extends E> iterable, List<E> list) {
        return toCollection(iterable, list);
    }

    public static <E> Set<E> toSet(Iterable<E> iterable) {
        return toSet(iterable, new HashSet<E>());
    }

    public static <E> Set<E> toSet(Iterable<? extends E> iterable, Set<E> set) {
        return toCollection(iterable, set);
    }

    public static <K, V> Map<K, V> toMap(Iterable<? extends Map.Entry<K, V>> iterable) {
        return toMap(iterable, new HashMap<K, V>());
    }

    public static <K, V> Map<K, V> toMap(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Map<K, V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : iterable) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    private static class EmptyIterable<T> implements Iterable<T> {
        static final EmptyIterable<Object> EMPTY_ITERABLE = new EmptyIterable<Object>();

        @Override
        public Iterator<T> iterator() {
            return Collections.<T>emptyList().iterator();
        }
    }
}
