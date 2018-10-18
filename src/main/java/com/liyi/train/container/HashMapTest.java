package com.liyi.train.container;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-15 10:15
 */
public class HashMapTest {
    public static void main (String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap(7);
        hashMap.put(null, 1);
        hashMap.put(null, 2);
        for (int i = 0; i <= 14; i++) {
            hashMap.put(i, i);
            if (i > 10) {
                continue;
            }
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        System.out.println(hashSet.add(null));
        boolean add = hashSet.add(null);
        System.out.println(add);
    }
}
