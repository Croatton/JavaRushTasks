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
        String openTag = "<" + args[0];// открывающий
        String closeTag = "</" + args[0] + ">";// закрывающий
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());// считываем все строки в стрингбилдер
        }
        fileReader.close();

        int openTagIndex = sb.indexOf(openTag);// индекс открывающего
        int closeTagIndex = sb.indexOf(closeTag);// индекс закрывающего

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
                tagStack.push(entry.getKey());// индексы всех открывающих тэгов в стэк
            } else {
                finalIndexes.put(tagStack.pop(), entry.getKey());
                /*если entry.getValue() == false , забираем из стэка последний попавший туда индекс(индеск начала)
                * и добавляем индекс конца*/
            }
        }
        for (Map.Entry<Integer, Integer> entry : finalIndexes.entrySet())
            System.out.println(sb.substring(entry.getKey(), entry.getValue() + closeTag.length()));
    }
}
