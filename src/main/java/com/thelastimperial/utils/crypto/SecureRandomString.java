package com.thelastimperial.utils.crypto;

import java.security.SecureRandom;
/**
 *
 * SecureRandomString Create secure Strings.
*/
public class SecureRandomString {
    private static SecureRandomString instance = null;
    private final SecureRandom secureRandom = new SecureRandom();
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private String numbers = "0123456789";
    private String simbols = "`~!@#$%^&*()_+={}|[]\\;':\"<>?,./";

    /**
     * Just can be a Instance.
    */
    private SecureRandomString() {
    }

    /**
     * Create a instance of {@code SecureRandomString}. Or return the existed instance.
     * @return SecureRandomString
    */
    public static SecureRandomString getInstance() {
        if(instance == null)
            instance = new SecureRandomString();
        return instance;
    }

    /**
     * Generate a secure string with all the characters.
     * @param length The length of the generate String.
     * @return A new secure random String.
    */
    public String generate(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be positive");
        String allChars = characters + numbers + simbols;

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(allChars.length());
            sb.append(allChars.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Generate a secure string with the selected values.
     * @param length The length of the generate String.
     * @param useChars Boolean value to use characters.
     * @param useNumbers Boolean value to use numbers.
     * @param useSimbols Boolean value to use simbols.
     * @return A new secure random String.
    */
    public String generate(int length, boolean useChars, boolean useNumbers, boolean useSimbols){
        if (length <= 0)
            throw new IllegalArgumentException("Length must be positive");
        if(useChars && useNumbers && useSimbols)
            throw new IllegalArgumentException("You have to set minimum a use value.");

        String allChars = "";

        if(useChars) allChars += characters;
        if(useNumbers) allChars += useNumbers;
        if(useSimbols) allChars += simbols;

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(allChars.length());
            sb.append(allChars.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Get the characters property.
     * @return The Characters property.
    */
    public String getCharacters() {
        return characters;
    }

    /**
     * Set the characters property.
     * @param characters Set the Characters property.
    */
    public void setCharacters(String characters) {
        this.characters = characters;
    }
    /**
     * Get the numbers property.
     * @return The Numbers property.
    */
    public String getNumbers() {
        return numbers;
    }
    /**
     * Set the numbers property.
     * @param numbers Set the Numbers property.
    */
    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    /**
     * Get the simbols property.
     * @return The Simbols property.
    */
    public String getSimbols() {
        return simbols;
    }
    /**
     * Set the simbols property.
     * @param simbols Set the Simbols property.
    */
    public void setSimbols(String simbols) {
        this.simbols = simbols;
    }

}
