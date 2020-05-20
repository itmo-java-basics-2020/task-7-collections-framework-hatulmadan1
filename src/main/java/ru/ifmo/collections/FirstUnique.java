package ru.ifmo.collections;

import java.util.*;
/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final Queue<Integer> orderOfElements;
    private final HashMap<Integer, Boolean> uniquenessChecker;

    public FirstUnique(int[] numbers) {
        orderOfElements = new LinkedList<Integer>();
        uniquenessChecker = new HashMap<>();

        if (numbers == null) {
            throw new IllegalArgumentException("Unknown number");
        }

        for (int num : numbers) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!orderOfElements.isEmpty() && !uniquenessChecker.get(orderOfElements.peek())) {
            orderOfElements.poll();
        }
        return orderOfElements.peek() == null ? -1 : orderOfElements.peek();
    }

    public void add(int value) {
        orderOfElements.add(value);
        if (uniquenessChecker.containsKey(value)) {
            uniquenessChecker.put(value, false);
        } else {
            uniquenessChecker.put(value, true);
        }
    }
}
