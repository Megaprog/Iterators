package iterator;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


/**
 * User: Tomas
 * Date: 23.04.2014
 * Time: 11:28
 */
public class IteratorsTest {

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
    public void testToCollection() throws Exception {

    }

    @Test
    public void testToList() throws Exception {

    }

    @Test
    public void testToList1() throws Exception {

    }

    @Test
    public void testToSet() throws Exception {

    }

    @Test
    public void testToSet1() throws Exception {

    }

    @Test
    public void testToMap() throws Exception {

    }

    @Test
    public void testToMap1() throws Exception {

    }
}
