package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (in.ready()) {
            String line = in.readLine();
            char[] chars = line.toCharArray();
            for (char c : chars)
            {
                if (map.containsKey(c))
                {
                    map.put(c, map.get(c) + 1);
                } else
                    {
                    map.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> mp : map.entrySet()) {
            System.out.println(mp.getKey() + " " + mp.getValue());
        }
        in.close();

    }
}
