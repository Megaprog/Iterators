# Iterators

Iterators framework is the implementation of lazy collections functional based on Iterator and Iterable interfaces.

## How do I use it?

You can download the latest build at:
    https://github.com/Megaprog/Iterators/releases

Or use it as a maven dependency:

```xml
<dependency>
    <groupId>org.jmmo</groupId>
    <artifactId>iterators</artifactId>
    <version>1.0</version>
</dependency>
```

## What can I do with Iterators?

- Create Empty, Singleton or Optional Iterable
- Merge two or more iterators into one
- Filter iterator values
- Map iterator values
- Reduce iterator values to produce a single result
- Repeat a value by creation iterator contains this value some number of times
- Produce ranges contains the sequence of integer or double values
- Create Java Collection, List or Set from any Iterable

## Examples

Obtain empty Iterable:
```java
Iterable<String> empty = Iterators.<String>empty();
```

Obtain Iterable contains a single element:
```java
Iterable<String> singleton = Iterators.singleton("jmmo");
```

Create iterator contains repeated value some number of times (will contains 1, 1, 1, 1, 1):
```java
Iterable<Integer> repeat = Iterators.repeat(1, 5);
```

Create iterator contains the range of integer or double values (will contains 1, 2, 3):
```java
Iterable<Integer> range = Iterators.range(1, 3);
```

Merge two Iterable's in one (will contains 1, 2, 4, 5):
```java
Iterable<Integer> merged = Iterators.merge(Arrays.asList(1, 2), Arrays.asList(4, 5));
```

Make the flat Iterable from an Iterable of Iterable's (will contains 1, 2, 0, 3, 4):
```java
Iterable<Integer> flat = Iterators.flat(Arrays.asList(Iterators.range(1, 2), Iterators.singleton(0), Iterators.range(3, 4)));
```

Filter the Iterable (will contains even numbers from 2 to 100):
```java
Iterable<Integer> even = new FilteredIterable<Integer>(Iterators.range(1, 100)) {
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
};
```

Map the Iterable (will contains "1", "2", "3"):
```java
Iterable<String> int2String = new MappedIterable<Integer, String>(Iterators.range(1, 3)) {
    @Override
    public String mapper(Integer integer) {
        return Integer.toString(integer);
    }
};
```

Reduce Iterable to produce a single result (will be 6):
```java
int length = new Reducer<String, Integer>() {
    @Override
    public Integer accumulate(Integer integer, String s) {
        return integer + s.length();
    }
}.reduce(0, "AB", "C", "DEF", "");
```

Create Collection, List or Set from any Iterable:
```java
Collection<Integer> rangeCollection = Iterators.toCollection(Iterators.range(1, 3), new Vector<Integer>());
List<Integer> rangeList = Iterators.toList(Iterators.range(1, 3));
Set<Integer> rangeSet = Iterators.toSet(Iterators.range(1, 3));
```
