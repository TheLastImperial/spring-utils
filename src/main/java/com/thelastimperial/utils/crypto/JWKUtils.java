package com.thelastimperial.utils.crypto;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JWKUtils {
    private final static Log log = LogFactory.getLog(JWKUtils.class);

    public static PublicKey getPublicKey(String key) throws Exception {
        log.debug("Public: " + key);
        // Create public key
        byte[] publicKeyBytes = Base64.getDecoder().decode(key);
        X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory publicKf = KeyFactory.getInstance("RSA");
        return publicKf.generatePublic(publicSpec);
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        log.debug("Private: " + key);
        // Create private key
        byte[] privateKeyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec privateSpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory privateKf = KeyFactory.getInstance("RSA");
        return privateKf.generatePrivate(privateSpec);
    }
}
