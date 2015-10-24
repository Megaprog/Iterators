package org.jmmo.iterator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReducerTest {

    @Test
    public void testReduce() throws Exception {
        Reducer<Integer> reducer = new Reducer<Integer>() {
            @Override
            public Integer accumulate(Integer previous, Integer current) {
                return previous + current;
            }
        };

        Mapper<String, Integer> mapper = new Mapper<String, Integer>() {
            @Override
            public Integer mapper(String s) {
                return s.length();
            }
        };

        assertEquals(6, reducer.reduce(0, mapper.map("AB", "C", "DEF", "")).intValue());
    }
}