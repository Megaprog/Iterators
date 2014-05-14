/**
 * <h1>Lazy collections based on Iterator and Iterable interfaces</h1>
 * <h2>Examples</h2>
 *
 * Obtain empty Iterable:
 * <pre>{@code
 * Iterable<String> empty = Iterators.<String>empty();
 * }</pre>
 *
 * Obtain Iterable contains a single element:
 * <pre>{@code
 * Iterable<String> singleton = Iterators.singleton("jmmo");
 * }</pre>
 *
 * Create iterator contains repeated value some number of times (will contains 1, 1, 1, 1, 1):
 * <pre>{@code
 * Iterable<Integer> repeat = Iterators.repeat(1, 5);
 * }</pre>
 *
 * Create iterator contains the range of integer or double values (will contains 1, 2, 3):
 * <pre>{@code
 * Iterable<Integer> range = Iterators.range(1, 3);
 * }</pre>
 *
 * Merge two Iterable's in one (will contains 1, 2, 4, 5):
 * <pre>{@code
 * Iterable<Integer> merged = Iterators.merge(Arrays.asList(1, 2), Arrays.asList(4, 5));
 * }</pre>
 *
 * Make the flat Iterable from an Iterable of Iterable's (will contains 1, 2, 0, 3, 4):
 * <pre>{@code
 * Iterable<Integer> flat = Iterators.flat(Arrays.asList(Iterators.range(1, 2), Iterators.singleton(0), Iterators.range(3, 4)));
 * }</pre>
 *
 * Filter the Iterable (will contains even numbers from 2 to 100):
 * <pre>{@code
 * Iterable<Integer> even = new FilteredIterable<Integer>(Iterators.range(1, 100)) {
 *     &#064;Override
 *     public boolean test(Integer integer) {
 *         return integer % 2 == 0;
 *     }
 * };
 * }</pre>
 *
 * Map the Iterable (will contains "1", "2", "3"):
 * <pre>{@code
 * Iterable<String> int2String = new MappedIterable<Integer, String>(Iterators.range(1, 3)) {
 *     &#064;Override
 *     public String mapper(Integer integer) {
 *         return Integer.toString(integer);
 *     }
 * };
 * }</pre>
 *
 * Reduce Iterable to produce a single result (will be 6):
 * <pre>{@code
 * int length = new Reducer<String, Integer>() {
 *     &#064;Override
 *     public Integer accumulate(Integer integer, String s) {
 *         return integer + s.length();
 *     }
 * }.reduce(0, "AB", "C", "DEF", "");
 * }</pre>
 *
 * Create Collection, List or Set from any Iterable:
 * <pre>{@code
 * Collection<Integer> rangeCollection = Iterators.toCollection(Iterators.range(1, 3), new Vector<Integer>());
 * List<Integer> rangeList = Iterators.toList(Iterators.range(1, 3));
 * Set<Integer> rangeSet = Iterators.toSet(Iterators.range(1, 3));
 * }</pre>
 */
package org.jmmo.iterator;