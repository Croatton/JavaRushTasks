package com.javarush.task.task31.task3105;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        if (args.length > 1)
        {
            String pathToFile = args[0];
            try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1])))
            {
                ZipEntry en;
                while ((en = zipIn.getNextEntry()) != null)
                {
                    ByteArrayOutputStream stream = readFromStream(zipIn);
                    map.put(en.getName(), stream);
                }
                zipIn.close();
            }
            String fileName = pathToFile.substring(pathToFile.lastIndexOf("/") + 1);
            FileInputStream inputStream = new FileInputStream(pathToFile);
            ByteArrayOutputStream byteArrayOutputStream = readFromStream(inputStream);
            inputStream.close();
            if (map.containsKey(fileName))
            {
                map.put(fileName, byteArrayOutputStream);
            } else {
                map.put("new/" + fileName, byteArrayOutputStream);
            }
            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1])))
            {
                for (Map.Entry<String, ByteArrayOutputStream> entry : map.entrySet()) {
                    zipOut.putNextEntry(new ZipEntry(entry.getKey()));
                    zipOut.write(entry.getValue().toByteArray());
                    zipOut.closeEntry();
                }
                zipOut.close();
            }
        }
    }
    public static ByteArrayOutputStream readFromStream(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int bytesRead;
        byte[] buffer = new byte[8192];
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        return out;
    }
}