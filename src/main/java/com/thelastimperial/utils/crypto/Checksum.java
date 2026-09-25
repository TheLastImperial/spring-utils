package com.thelastimperial.utils.crypto;

import java.io.InputStream;
import java.security.MessageDigest;
/**
 *
 * Checksum Generate Checksum of files.
*/
public class Checksum {
    private String algorithm = "SHA-256";

    /**
     * Create the object with the default algorithm
    */
    public Checksum() {
    }
    /**
     * Create the object with the algorithm specified.
     * @param algorithm Algorithm to digest file.
    */
    public Checksum(String algorithm) {
        this.algorithm = algorithm;
    }
    /**
     *
     * @return String with the algorithm gused.
    */
    public String getAlgorithm() {
        return algorithm;
    }
    /**
     *
     * @param algorithm New algorithm to create the checksum.
    */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    /**
     * Create a checksum with the InputStream
     * @param inputStream InputStream to generate Checksum.
     * @return String the identify the file.
    */
    public String digest(InputStream inputStream) {

        String result = null;
        try{
            // Initialize SHA-256 digest instance
            MessageDigest digest = MessageDigest.getInstance(getAlgorithm());

            // Use try-with-resources to ensure the input stream closes
            try (InputStream is = inputStream) {
                byte[] buffer = new byte[8192]; // 8KB buffer size
                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    digest.update(buffer, 0, bytesRead);
                }
            }

            // Convert the byte array to a readable hex string
            byte[] hashBytes = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            result = hexString.toString();
        } catch(Exception e){

        }

        return result;
    }

}
