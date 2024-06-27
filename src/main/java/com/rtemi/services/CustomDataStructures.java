package com.rtemi.services;

import com.rtemi.model.CustomArrayList;
import com.rtemi.model.CustomHashSet;

public class CustomDataStructures {
    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.put(1);
        customArrayList.put(2);
        customArrayList.put(3);
        System.out.println("ArrayList size: " + customArrayList.size());
        System.out.println("Element at index 1: " + customArrayList.get(1));
        customArrayList.delete(1);
        System.out.println("Element at index 1 after removing: " + customArrayList.get(1));


        CustomHashSet<String> customHashSet = new CustomHashSet<>();
        customHashSet.put("a");
        customHashSet.put("b");
        customHashSet.put("c");
        System.out.println("HashSet size: " + customHashSet.size());
        System.out.println("Contains 'a': " + customHashSet.contains("a"));
        customHashSet.remove("a");
        System.out.println("Contains 'a' after removal: " + customHashSet.contains("a"));

        System.out.println("Iterating over CustomHashSet:");
        for (String s : customHashSet) {
            System.out.println(s);
        }
    }
}
