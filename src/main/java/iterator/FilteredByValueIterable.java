package iterator;

/**
 * User: Tomas
 * Date: 20.01.14
 * Time: 20:25
 */
public class FilteredByValueIterable<T> extends FilteredIterable<T> {
    private final T value;

    public FilteredByValueIterable(Iterable<T> iterable, T value) {
        super(iterable);
        this.value = value;
    }

    @Override
    public boolean filter(T element) {
        return element.equals(value);
    }
}
