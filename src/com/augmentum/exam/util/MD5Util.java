package com.augmentum.exam.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.augmentum.exam.Constants;

public class MD5Util {
    // Make byte[] to string
    private static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0x0F);
            if (hex.length() == 1) {
                hex = Constants.ZERO + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    // Gets Encrypted
    public static String getEncryptedPwd(String password) {
        byte[] pwd = null;
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance(Constants.MD5);
            mDigest.update(password.getBytes(Constants.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] digest = mDigest.digest();
        pwd = new byte[digest.length];
        System.arraycopy(digest, 0, pwd, 0, digest.length);
        return byteToHexString(pwd);
    }
}
