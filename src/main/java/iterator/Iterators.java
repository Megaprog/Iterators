package iterator;

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
