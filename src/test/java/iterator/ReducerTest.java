package iterator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReducerTest {

    @Test
    public void testReduce() throws Exception {
        Reducer<String, Integer> reducer = new Reducer<String, Integer>() {
            @Override
            public Integer accumulate(Integer integer, String s) {
                return integer + s.length();
            }
        };

        assertEquals( (int) reducer.reduce(0, "AB", "C", "DEF", ""), 6);
    }
}