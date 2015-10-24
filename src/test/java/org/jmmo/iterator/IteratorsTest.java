package org.jmmo.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 11:28
 */
public class IteratorsTest {

    @Test
    public void testCount() throws Exception {
        assertEquals(3, Iterators.count(Arrays.asList(1, 2, 3)));
        assertEquals(0, Iterators.count(Iterators.empty()));
    }

    @Test
    public void testEmpty() throws Exception {
        assertThat(Iterators.empty(), is(emptyIterable()));
    }

    @Test
    public void testSingleton() throws Exception {
        assertThat(Iterators.singleton(1), contains(1));
    }

    @Test
    public void testOption() throws Exception {
        assertThat(Iterators.option(1), contains(1));
        assertThat(Iterators.option(null), is(emptyIterable()));
    }

    @Test
    public void testRangeInt() throws Exception {
        assertThat(Iterators.range(0, -1), is(emptyIterable()));
        assertThat(Iterators.range(0, 0), contains(0));
        assertThat(Iterators.range(0, 1), contains(0, 1));
        assertThat(Iterators.range(2, 1), is(emptyIterable()));
        assertThat(Iterators.range(2, 1, -1), contains(2, 1));
    }

    @Test
    public void testRangeDouble() throws Exception {
        assertThat(Iterators.range(0.0, -1.0), is(emptyIterable()));
        assertThat(Iterators.range(0.0, 0.0), contains(0.0));
        assertThat(Iterators.range(0.0, 1.0), contains(0.0, 1.0));
        assertThat(Iterators.range(2.0, 1.0), is(emptyIterable()));
        assertThat(Iterators.range(2.0, 1.0, -1.0), contains(2.0, 1.0));
    }

    @Test
    public void testMerge() throws Exception {
        assertThat(Iterators.merge(Iterators.<Double>empty(), Iterators.singleton(0.0)), contains(0.0));
        assertThat(Iterators.merge(Iterators.range(1, 2), Iterators.merge(Iterators.range(5, 6), Iterators.singleton(3))), contains(1, 2, 5, 6, 3));
        assertThat(Iterators.merge(Iterators.singleton(1), Iterators.singleton(2.0)), contains(1, 2.0));
    }

    @Test
    public void testRepeat() throws Exception {
        assertThat(Iterators.repeat(1, 3), contains(1, 1, 1));
        assertThat(Iterators.repeat("Victory", 2), contains("Victory", "Victory"));
    }

    @Test
    public void testFlat() throws Exception {
        assertThat(Iterators.flat(Arrays.asList(Iterators.range(1, 2), Iterators.singleton(0), Iterators.range(3, 4))), contains(1, 2, 0, 3, 4));
    }

    @Test
    public void testFilter() throws Exception {
        assertThat(Iterators.filter(Arrays.asList(1, 2, 3, 4, 5), new Filter<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }), contains(2, 4));
    }

    @Test
    public void testMapper() throws Exception {
        assertThat(Iterators.map(Arrays.asList(1, 2, 3), new Mapper<Integer, String>() {
            @Override
            public String mapper(Integer integer) {
                return Integer.toString(integer);
            }
        }), contains("1", "2", "3"));
    }

    @Test
    public void testToCollection() throws Exception {
        assertEquals(Iterators.toCollection(Iterators.range(1, 3), new LinkedList<Integer>()), Arrays.asList(1, 2, 3));
    }

    @Test
    public void testToList() throws Exception {
        assertEquals(Iterators.toList(Iterators.range(1, 3)), Arrays.asList(1, 2, 3));
    }

    @Test
    public void testToSet() throws Exception {
        assertEquals(Iterators.toSet(Iterators.range(1, 3)), new HashSet<Integer>() {{
            add(1); add(3); add(2);
        }});
    }

    @Test
    public void testToMap() throws Exception {
        assertEquals(new HashMap<String, Integer>() {{
            put("d", 4); put("c", 3); put("a", 1); put("b", 2);
        }}, Iterators.toMap(Arrays.asList("d4", "c3", "a1", "b2"), new ToMap<String, String, Integer>() {
            @Override
            public String key(String s) {
                return s.substring(0, 1);
            }

            @Override
            public Integer value(String s) {
                return Integer.valueOf(s.substring(1));
            }
        }));
    }
}
