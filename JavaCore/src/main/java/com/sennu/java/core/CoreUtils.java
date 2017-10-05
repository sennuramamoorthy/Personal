package com.sennu.java.core;

import com.sennu.utils.MyUtils;
import org.apache.log4j.Logger;

import java.util.Properties;

public class CoreUtils {
    private static final Logger LOGGER = Logger.getLogger(CoreUtils.class);

    public static void main(String[] args) {
        Properties coreProperties = MyUtils.getProperties("Application.Core.properties");
        coreProperties.list(System.out);
    }
}
