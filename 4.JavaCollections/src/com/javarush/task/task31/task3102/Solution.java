package com.javarush.task.task31.task3102;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();//список
        Stack<File> stack = new Stack<>();//очередь
        File rootDir = new File(root);//файл директории в которой идет поиск
        stack.push(rootDir);// поставили в очередь корневую директорию
        while (!stack.isEmpty()) {// пока очередь не пустая
            File child = stack.pop();// взять из очереди
            if (child.isDirectory()) {// если директория
                for (File f : child.listFiles()) {//получить список файлов
                    stack.push(f);// поставить в очередь
                }
            } else if (child.isFile()) {// если файл
                fileList.add(child.getAbsolutePath());
            }
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileList = getFileTree("src/main/resources/level31/lesson02/home02");
        for (String s : fileList) {
            System.out.println(s);
        }
    }
}