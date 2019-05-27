package com.siniak.finaltask.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password encoder
 * @author Vitali Siniak
 */

public class PasswordEncoder {
    static final Logger logger = LogManager.getLogger();

    /**
     * Returns encoded password
     * @param passwordToHash - password to encode
     * @param login - login
     * @return encoded password
     */
    public static String encodePassword(String passwordToHash, String login){
        String securePassword = get_SHA_256_SecurePassword(passwordToHash, login);
        return securePassword;
    }


    private static String get_SHA_256_SecurePassword(String passwordToHash, String login)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] salt = login.getBytes();
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
