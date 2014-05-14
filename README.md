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
- Reduce iterator values to produce single result
- Repeat a value by creation iterator contains this value some number of times
- Produce ranges contains the sequence of integer or double values
- Create Java Collection from any Iterable

## Examples

Obtain empty Iterable:
```java
Iterable<String> empty = Iterators.<String>empty();
```
