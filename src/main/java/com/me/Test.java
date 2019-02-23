package com.me;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        System.out.println(test(new int[]{89, 256, 78, 1, 46, 78, 8}));
    }

    private static int test(int[] data) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(data[0], 1);
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (data[i] > data[j]) {
                    map.put(data[i], map.get(data[j]) + 1);
                    break;
                } else {
                    map.put(data[i], 1);
                }
            }
        }
        int max = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> e: entries) {
            System.out.println(e.getKey() + "->" + e.getValue());
            if (e.getValue() > max) max = e.getValue();
        }
        return max;
    }
}
