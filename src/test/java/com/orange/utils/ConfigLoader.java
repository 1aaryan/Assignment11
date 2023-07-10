package com.orange.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader()  {
        String directory= System.getProperty("user.dir");
        properties= PropertyUtils.propertyLoader(directory+ "/src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }


    public String getUrl(){
        return properties.getProperty("baseUri");
    }
    public String getUserName(){
        return properties.getProperty("userName");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }

}
