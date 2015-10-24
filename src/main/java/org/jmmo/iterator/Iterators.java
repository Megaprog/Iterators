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
        return count(iterable.iterator());
    }

    public static <T> int count(Iterator<T> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
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

    public static <T> Iterator<T> filter(Iterator<T> iterator, Filter<T> filter) {
        return filter.filter(iterator);
    }

    public static <T> Iterable<T> filter(Iterable<T> iterable, Filter<T> filter) {
        return filter.filter(iterable);
    }

    public static <T, R> Iterator<R> map(Iterator<T> iterator, Mapper<T, R> mapper) {
        return mapper.map(iterator);
    }

    public static <T, R> Iterable<R> map(Iterable<T> iterable, Mapper<T, R> mapper) {
        return mapper.map(iterable);
    }

    public static <T> T reduce(T identity, Iterator<T> iterator, Reducer<T> reducer) {
        return reducer.reduce(identity, iterator);
    }

    public static <T> T reduce(T identity, Iterable<T> iterable, Reducer<T> reducer) {
        return reducer.reduce(identity, iterable);
    }

    public static <T> Iterable<T> reduce(Iterator<T> iterator, Reducer<T> reducer) {
        return reducer.reduce(iterator);
    }

    public static <T> Iterable<T> reduce(Iterable<T> iterable, Reducer<T> reducer) {
        return reducer.reduce(iterable);
    }

    public static <T> Collection<T> collection(Iterable<T> iterable) {
        return new IterableCollection<T>(iterable);
    }

    public static <C extends Collection<E>, E> C toCollection(Iterable<? extends E> iterable, C collection) {
        return toCollection(iterable.iterator(), collection);
    }

    public static <C extends Collection<E>, E> C toCollection(Iterator<? extends E> iterator, C collection) {
        while (iterator.hasNext()) {
            collection.add(iterator.next());
        }
        return collection;
    }

    public static <T> List<T> toList(Iterator<T> iterator) {
        return toCollection(iterator, new ArrayList<T>());
    }

    public static <T> List<T> toList(Iterable<T> iterable) {
        return toCollection(iterable, new ArrayList<T>());
    }

    public static <T> Set<T> toSet(Iterator<T> iterator) {
        return toCollection(iterator, new HashSet<T>());
    }
    public static <T> Set<T> toSet(Iterable<T> iterable) {
        return toCollection(iterable, new HashSet<T>());
    }

    public static <T, K, V> Map<K, V> toMap(Iterator<T> iterator, ToMap<T, K, V> toMap) {
        return toMap.toMap(iterator);
    }

    public static <T, K, V> Map<K, V> toMap(Iterator<T> iterator, ToMap<T, K, V> toMap, Map<K, V> map) {
        return toMap.toMap(iterator, map);
    }

    public static <T, K, V> Map<K, V> toMap(Iterable<T> iterable, ToMap<T, K, V> toMap) {
        return toMap.toMap(iterable);
    }

    public static <T, K, V> Map<K, V> toMap(Iterable<T> iterable, ToMap<T, K, V> toMap, Map<K, V> map) {
        return toMap.toMap(iterable, map);
    }

    private static class EmptyIterable<T> implements Iterable<T> {
        static final EmptyIterable<Object> EMPTY_ITERABLE = new EmptyIterable<Object>();

        public Iterator<T> iterator() {
            return Collections.<T>emptyList().iterator();
        }
    }
}
