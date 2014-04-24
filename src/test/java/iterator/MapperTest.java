package iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class MapperTest {

    @Test
    public void testMap() throws Exception {
        Mapper<Integer, String> int2StringMapper = new Mapper<Integer, String>() {
            @Override
            public String mapper(Integer integer) {
                return Integer.toString(integer);
            }
        };

        assertThat(int2StringMapper.map(1, 2, 3), contains("1", "2", "3"));
    }
}