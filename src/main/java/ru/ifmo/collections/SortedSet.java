package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final Map<T, Boolean> contents; //TODO decide Map implementation and key/value types. "???" is used just as an example

    private SortedSet(Map<T, Boolean> contents) {
        this.contents = contents;
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public ArrayList<T> getSorted() {
        return new ArrayList<T>(contents.keySet());
    }

    public List<T> getReversed() {
        List<T> toReverse = getSorted();
        Collections.reverse(toReverse);
        return toReverse;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(T key) {
        if (contents.containsKey(key)) {
            return false;
        }

        contents.put(key, null);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean ok = true;
        for (var c : collection) {
            ok &= add(c);
        }
        return ok;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }

        contents.remove(o);
        return true;
    }

    public boolean removeAll(T... args) {
        boolean ok = true;
        for (var c : args) {
            ok &= remove(c);
        }
        return ok;
    }
}
