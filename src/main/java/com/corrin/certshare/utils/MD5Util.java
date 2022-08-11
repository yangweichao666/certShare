//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MD5Util {
    public MD5Util() {
    }

    public static String md5Encrypt32Upper(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException var7) {
            throw new RuntimeException("Huh, MD5 should be supported?", var7);
        } catch (UnsupportedEncodingException var8) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", var8);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        byte[] var3 = hash;
        int var4 = hash.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            if ((b & 255) < 16) {
                hex.append("0");
            }

            hex.append(Integer.toHexString(b & 255));
        }

        return hex.toString().toUpperCase();
    }

    public static String md5Encrypt32Lower(String string) {
        return md5Encrypt32Upper(string).toLowerCase();
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();

        for(int i = 0; i < bytes.length; ++i) {
            int num = bytes[i];
            if (num < 0) {
                num += 256;
            }

            if (num < 16) {
                hexStr.append("0");
            }

            hexStr.append(Integer.toHexString(num));
        }

        return hexStr.toString().toUpperCase();
    }

    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

        char ch;
        for(Matcher matcher = pattern.matcher(str); matcher.find(); str = str.replace(matcher.group(1), ch + "")) {
            ch = (char)Integer.parseInt(matcher.group(2), 16);
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(md5Encrypt32Lower("Sdsjj022"));
        System.out.println(md5Encrypt32Upper("Sdsjj022"));
    }
}
