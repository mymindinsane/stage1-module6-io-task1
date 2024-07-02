package com.epam.mjc.io;

import java.io.*;



public class FileReader {

    public Profile getDataFromFile(File file){
        StringBuilder line = new StringBuilder();
        int c;
        try (FileInputStream fis = new FileInputStream(file)) {
            while ((c = fis.read()) != -1){
                line.append(((char) c));
            }
        } catch (IOException e)  {
            throw new ProfileInvalidData(e.getMessage());
        }

        String[] array = line.toString().split("\n");
        String name = array[0].substring(array[0].lastIndexOf(':') + 1).trim();
        Integer age = Integer.valueOf(array[1].substring(array[1].lastIndexOf(':') + 1).trim());
        String email = array[2].substring(array[2].lastIndexOf(':') + 1).trim();
        Long phone = Long.valueOf(array[3].substring(array[3].lastIndexOf(':') + 1).trim());
        return new Profile(name,age,email,phone);
    }
}
