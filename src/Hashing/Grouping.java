package Hashing;

import java.util.*;

public class Grouping {
    //Solution49. Grouping Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); //*
            String key = new String(chars); // use the identifier as a hashmap key to group all elements together
            if (!groups.containsKey(key)) groups.put(key, new ArrayList<>()); //*
            groups.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>(groups.values()); //parameterized constructor call
        return result;
    }
}
