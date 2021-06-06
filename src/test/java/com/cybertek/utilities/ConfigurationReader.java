package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
We will create a re-usable method that will be reading from configuration.reader file
 */

public class ConfigurationReader {

    //#1- Create properties object
    private static Properties properties = new Properties();

    static {

        try {
            //#2- Load the file into FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3- load properties object with the file (configuration.properties)
            properties.load(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
