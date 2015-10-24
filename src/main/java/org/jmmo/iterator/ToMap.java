package org.jmmo.iterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class ToMap<T, K, V> {

    public Map<K, V> toMap(Iterable<T> iterable) {
        return toMap(iterable.iterator());
    }

    public Map<K, V> toMap(Iterable<T> iterable, Map<K, V> map) {
        return toMap(iterable.iterator(), map);
    }

    public Map<K, V> toMap(T... ts) {
        return toMap(Arrays.asList(ts));
    }

    public Map<K, V> toMap(final Iterator<T> iterator) {
        return toMap(iterator, new HashMap<K, V>());
    }

    public Map<K, V> toMap(final Iterator<T> iterator, Map<K, V> map) {
        while (iterator.hasNext()) {
            final T next = iterator.next();
            map.put(key(next), value(next));
        }
        return map;
    }

    abstract public K key(T t);

    abstract public V value(T t);
}
