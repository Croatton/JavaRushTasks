package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("C:\\Users\\admin\\Dropbox\\JavaRushTasks\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\admin\\Dropbox\\JavaRushTasks\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\admin\\Dropbox\\JavaRushTasks\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        if (fileName.endsWith("xml")) {
            try {
                properties.loadFromXML(new FileInputStream(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                properties.load(new FileInputStream(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
