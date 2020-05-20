package ru.ifmo.collections;

import java.util.*;
/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final PriorityQueue<Integer> innerLogic;
    private final int k;

    public KthLargest(int k, int[] numbers) {
        innerLogic = new PriorityQueue<Integer>();

        if (k < 0) {
            throw new IllegalArgumentException("K must be more than zero");
        }
        this.k = k;

        for (int num : numbers) {
            add(num);
        }
    }

    public int add(int value) {
        innerLogic.add(value);

        if (innerLogic.size() > k) {
            innerLogic.remove();
        }
        return innerLogic.element();
    }
}