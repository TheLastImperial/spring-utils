package com.thelastimperial.utils.utils;

import java.util.Base64;
/**
 *
 * Base64Utils utils to generate base64 Strings.
*/
public class Base64Utils {
    /**
     * Generate a string with base64 that represent the file.
     * @param bytes The bytes to convert.
     * @param contentType The file Content Type
     * @return a string on base64 that can be used as body request.
    */
    public static String getImageBase64(byte[] bytes, String contentType) {
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return "data:" + contentType + ";base64," + base64;
    }
}
