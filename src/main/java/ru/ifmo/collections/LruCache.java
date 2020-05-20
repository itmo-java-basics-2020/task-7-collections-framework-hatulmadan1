package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.*;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> extends LinkedHashMap {
    private int capacity;

    public LruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    @Override
    public V get(Object key) {
        return (V) super.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    public int elements() {
        return super.size();
    }
}