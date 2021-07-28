package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    //initialize log4j instance
 private static final Logger Log= LogManager.getLogger(Log.class);

 //info level logs
    public static void info(String message){
        Log.info(message);
    }

    //warn level logs
    public static void warn(String message){
        Log.warn(message);
    }

    //Error level logs
    public static void error(String message){
        Log.error(message);
    }

    //fatal level logs
    public static void fatal(String message){
        Log.fatal(message);
    }

    //Debug level logs
    public static void debug(String message){
        Log.debug(message);
    }
}
