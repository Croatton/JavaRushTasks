package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String str = "";
        while (fileReader.ready()){
            str = fileReader.readLine();
            String[] arrStr = str.split(" ");
            if (args[0].equals(arrStr[0])){
                System.out.println(str);
            }
        }
        reader.close();
        fileReader.close();
    }
}
