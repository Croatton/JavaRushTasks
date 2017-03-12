package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// имя файла с консоли
        FileReader inputStream = null; // чтение файла поток
        String fileName = " ";// имя файла
        while (true){
            try{
                fileName = reader.readLine();// получили имя файла
                inputStream = new FileReader(fileName);// читаем этот файл
            } catch (FileNotFoundException e){
                System.out.println(fileName);
                break;
            }
            inputStream.close();
        }
        reader.close();
    }
}