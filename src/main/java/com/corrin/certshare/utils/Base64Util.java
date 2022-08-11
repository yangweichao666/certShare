//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;

public final class Base64Util {
    public Base64Util() {
    }

    public static String ioToBase64(InputStream in) {
        String strBase64 = "";
        ByteArrayOutputStream bs = new ByteArrayOutputStream();

        String ret;
        try {

            byte[] bytes = new byte[1024];

            int index;
            while((index = in.read(bytes)) != -1) {
                bs.write(bytes, 0, index);
            }

            byte[] bytes1 = bs.toByteArray();
            in.read(bytes1);
            strBase64 = Base64.encodeBase64String(bytes1);
            String var7 = strBase64;
            return var7;
        } catch (Exception var17) {
            var17.printStackTrace();
            ret = strBase64;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (bs != null) {
                    bs.close();
                }
            } catch (IOException var16) {
                var16.printStackTrace();
                return strBase64;
            }

        }

        return ret;
    }
}
