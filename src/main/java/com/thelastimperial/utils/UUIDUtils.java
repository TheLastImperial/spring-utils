package com.thelastimperial.utils;

import java.util.UUID;

public class UUIDUtils {
    public static boolean isValid(String uuid){
        boolean result = true;

        try{
            UUID.fromString(uuid);
        } catch(Exception e){
            result = false;
        }

        return result;
    }
}
