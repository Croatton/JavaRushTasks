package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static long Size;
    static int CountFiles = 0;
    static long FoldersInFolder = -1;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String absPath = reader.readLine();
        Path folder = Paths.get(absPath);
        if (!Files.isDirectory(folder))
        {
            absPath = folder.toAbsolutePath().toString();
            System.out.println(absPath + " - не папка");
            return;
        }
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(folder,myFileVisitor);

        System.out.println("Всего папок - " + FoldersInFolder);
        System.out.println("Всего файлов - " + CountFiles);
        System.out.println("Общий размер - " + Size);
    }
    static class MyFileVisitor extends SimpleFileVisitor{
        public FileVisitResult fileVisitResult(Path file, BasicFileAttributes attrs) throws IOException{
            CountFiles++;
            Size += Files.size(file);
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) {
            FoldersInFolder ++;
            return FileVisitResult.CONTINUE;
        }
    }
}
