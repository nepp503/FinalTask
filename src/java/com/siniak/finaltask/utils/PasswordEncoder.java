package com.siniak.finaltask.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncoder {
    static final Logger logger = LogManager.getLogger();

    public String encodePassword(String passwordToHash){
        byte[] salt = new byte[0];
        salt = getSalt();
        String securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
        return securePassword;
    }


    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
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

    private static byte[] getSalt(){
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.ERROR, e);
        }
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
