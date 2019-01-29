package com.xth.project.photo.common;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xieth on 2019/1/25.
 */
public class PropertyListenerConfig {
    private static Map<String, String> propertyMap = new HashMap();

    public static void loadAllProperties(String propertyFileName){
        try{
            Properties properties = PropertiesLoaderUtils.loadAllProperties(propertyFileName);
            processProperties(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void processProperties(Properties properties) throws UnsupportedEncodingException {
        for(Object o : properties.keySet()){
            String key = o.toString();
            String value = new String(properties.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
            propertyMap.put(key, value);
        }
    }

    public static String getProperty(String key){
        return propertyMap.get(key);
    }

    public static Map<String, String> getPropertyMap(){
        return propertyMap;
    }
}
