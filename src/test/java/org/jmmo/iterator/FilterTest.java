package org.jmmo.iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class FilterTest {

    @Test
    public void testFilter() throws Exception {
        Filter<Integer> evenFilter = new Filter<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        assertThat(evenFilter.filter(1, 2, 3, 4, 5), contains(2, 4));
    }
}