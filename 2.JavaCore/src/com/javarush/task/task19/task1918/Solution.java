package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String openTag = "<" + args[0];//
        String closeTag = "</" + args[0] + ">";
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        fileReader.close();

        int openTagIndex = sb.indexOf(openTag);
        int closeTagIndex = sb.indexOf(closeTag);

        Map<Integer, Boolean> tagIndexesMap = new TreeMap<>();
        Stack<Integer> tagStack = new Stack<>();
        Map<Integer, Integer> finalIndexes = new TreeMap<>();

        while (openTagIndex != -1) {
            tagIndexesMap.put(openTagIndex, true);
            openTagIndex = sb.indexOf(openTag, openTagIndex + 1);
        }

        while (closeTagIndex != -1) {
            tagIndexesMap.put(closeTagIndex, false);
            closeTagIndex = sb.indexOf(closeTag, closeTagIndex + 1);
        }

        for (Map.Entry<Integer, Boolean> entry : tagIndexesMap.entrySet()) {
            if (entry.getValue()) {
                tagStack.push(entry.getKey());
            } else {
                finalIndexes.put(tagStack.pop(), entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> entry : finalIndexes.entrySet())
            System.out.println(sb.substring(entry.getKey(), entry.getValue() + closeTag.length()));
    }
}
