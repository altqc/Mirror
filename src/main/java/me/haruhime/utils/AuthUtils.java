package me.haruhime.utils;

import java.io.*;
import java.security.*;

public class AuthUtils {

    // This will generate a HWID that should work across multiple os platforms

    public static String getHWID() throws IOException {
        String HWIDraw = String.valueOf(System.getenv("PROCESSOR_IDENTIFIER")) + System.getenv("COMPUTERNAME") + System.getProperty("user.name");
        return HWIDraw;
    }

    // This is an open source md5 conversion method, I did not write it

    public static String md5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b: hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (UnsupportedEncodingException ex) {

        } catch (NoSuchAlgorithmException ex) {

        }
        return digest;
    }

}
