//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import com.linewell.license.encode.sm4.Util;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECPoint;

public class SM2Utils {
    public SM2Utils() {
    }

    public static String encrypt(byte[] publicKey, byte[] data) throws IOException {
        if (publicKey != null && publicKey.length != 0) {
            if (data != null && data.length != 0) {
                byte[] source = new byte[data.length];
                System.arraycopy(data, 0, source, 0, data.length);
                Cipher cipher = new Cipher();
                SM2 sm2 = SM2.Instance();
                ECPoint userKey = sm2.ecc_curve.decodePoint(publicKey);
                ECPoint c1 = cipher.Init_enc(sm2, userKey);
                cipher.Encrypt(source);
                byte[] c3 = new byte[32];
                cipher.Dofinal(c3);
                return Util.byteToHex(c1.getEncoded(false)) + Util.byteToHex(source) + Util.byteToHex(c3);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static byte[] decry(byte[] privateKey, byte[] encryptedData) throws IOException {
        if (privateKey != null && privateKey.length != 0) {
            if (encryptedData != null && encryptedData.length != 0) {
                String data = Util.byteToHex(encryptedData);
                byte[] c1Bytes = Util.hexToByte(data.substring(0, 130));
                int c2Len = encryptedData.length - 97;
                byte[] c2 = Util.hexToByte(data.substring(130, 130 + 2 * c2Len));
                byte[] c3 = Util.hexToByte(data.substring(130 + 2 * c2Len, 194 + 2 * c2Len));
                SM2 sm2 = SM2.Instance();
                BigInteger userD = new BigInteger(1, privateKey);
                ECPoint c1 = sm2.ecc_curve.decodePoint(c1Bytes);
                Cipher cipher = new Cipher();
                cipher.Init_dec(userD, c1);
                cipher.Decrypt(c2);
                cipher.Dofinal(c3);
                return c2;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
