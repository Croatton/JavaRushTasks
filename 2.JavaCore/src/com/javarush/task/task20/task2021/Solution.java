package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static void main(String[] args) {

    }

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }
    }
}
