package com.siniak.finaltask.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncoder {
    private static final String SALT = "NEPPVITALI";
    static final Logger logger = LogManager.getLogger();

    public static String encodePassword(String passwordToHash){
        String securePassword = get_SHA_256_SecurePassword(passwordToHash);
        return securePassword;
    }


    private static String get_SHA_256_SecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] salt = SALT.getBytes();
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.ERROR, e);
        }
        return generatedPassword;
    }
}
