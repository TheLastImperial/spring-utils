package com.thelastimperial.utils;

import java.util.UUID;
/**
 * Fast utilities related to UUIDs.
 * UUIDUtils
*/
public class UUIDUtils {
    /**
     * Determinate if the string is a valid UUID.
     * @param uuid String to be validated.
     * @return <code>true</code> if the input String is a valid UUID.
    */
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
