package com.sennu.bigdata.hbase;

import com.sennu.utils.MyUtils;

import java.util.Properties;

public class HbaseUtils {
    public static void main(String[] args) {
        Properties bigDataProperties = MyUtils.getProperties("Application.bigdata.properties");
        bigDataProperties.list(System.out);

    }
}
