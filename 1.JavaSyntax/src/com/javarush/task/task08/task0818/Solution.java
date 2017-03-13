package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> UserMap = new HashMap<>();
        UserMap.put("User1", 100);
        UserMap.put("User2", 200);
        UserMap.put("User3", 300);
        UserMap.put("User4", 400);
        UserMap.put("User5", 500);
        UserMap.put("User6", 600);
        UserMap.put("User7", 700);
        UserMap.put("User8", 800);
        UserMap.put("User9", 900);
        UserMap.put("User10", 1000);
        return UserMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy2 = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy2.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }

    }

    public static void main(String[] args) {
    }
}