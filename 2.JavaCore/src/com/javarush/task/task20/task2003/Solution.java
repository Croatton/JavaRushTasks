package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public static void main(String[] args) {

    }

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        FileInputStream fin = new FileInputStream(data);
        load(fin);
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry<String, String> map : properties.entrySet()) {
            props.put(map.getKey(), map.getValue());// записываем MAP properties в созданый props
        }
        props.store(outputStream, "");//сохраняет(записывает) props в поток
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        props.load(inputStream);//загружет из потока
        Set<String> list = props.stringPropertyNames();
        for (String current : list)
            properties.put(current, props.getProperty(current));
    }
}
