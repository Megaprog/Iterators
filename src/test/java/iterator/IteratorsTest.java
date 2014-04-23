package iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.is;
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
