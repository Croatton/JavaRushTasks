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
        int ch;
        while ((ch = in.read()) != -1) {
            if(map.containsKey((char)ch)) {
                map.put((char)ch, map.get((char)ch) + 1);
            }
            else {
                map.put((char)ch, 1);
            }
        }
        for (Map.Entry mp : map.entrySet()) {
            System.out.println(mp.getKey() + " " + mp.getValue());
        }
        in.close();

    }
}
