package com.sennu.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyUtils {

    private static final Logger LOGGER = Logger.getLogger(MyUtils.class);
    private static String appConfigDirectory;

    public static Properties getApplicationProperties(String fileName) throws Exception {
        Properties properties = new Properties();
        try {
            if (validateSystemConfig()) {
                properties.load(new FileInputStream(appConfigDirectory + "/" + fileName));
            }
        } catch (IOException e) {
            LOGGER.error("Error in reading properties file", e);
            throw new Exception("Error in reading properties file", e);
        } catch (Exception e) {
            LOGGER.error("System property validation error: ", e);
            throw new Exception("System property validation error: ", e);
        }
        return properties;
    }

    private static boolean validateSystemConfig() throws Exception {
        appConfigDirectory = System.getProperty("app.config.directory");
        if (appConfigDirectory == null || appConfigDirectory.equals("")) {
            LOGGER.error("System property \"app.config.directory\" is not set. Please set this property to point out application configuration directory.");
            throw new Exception("System property \"app.config.directory\" is not set. Please set this property to point out application configuration directory.");
        }
        return true;
    }

    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(MyUtils.class.getClassLoader().getResource(fileName).getFile())));
        } catch (IOException e) {
            LOGGER.error("Error in reading properties file", e);
        }
        return properties;
    }
}
