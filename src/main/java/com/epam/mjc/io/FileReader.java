package com.epam.mjc.io;

import java.io.*;



public class FileReader {

    public Profile getDataFromFile(File file) {
        String line = "";
        int c = 0;
        try (FileInputStream fis = new FileInputStream(file)) {
            while ((c = fis.read()) != -1){
                line += String.valueOf((char) c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] array = line.split("\n");
        String name = array[0].substring(array[0].lastIndexOf(':') + 1).trim();
        Integer age = Integer.valueOf(array[1].substring(array[1].lastIndexOf(':') + 1).trim());
        String email = array[2].substring(array[2].lastIndexOf(':') + 1).trim();
        Long phone = Long.valueOf(array[3].substring(array[3].lastIndexOf(':') + 1).trim());
        System.out.println(name);
        return new Profile(name,age,email,phone);
    }
}
