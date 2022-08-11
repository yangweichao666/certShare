//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import java.io.InputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class OutputFormateUtil {
    private static Logger logger = LoggerFactory.getLogger(OutputFormateUtil.class);

    public OutputFormateUtil() {
    }

    public static void ReturnInPutStream(InputStream in, OutputStream out) {
        if (in != null) {
            try {
                byte[] buffer = new byte[1024];

                int len;
                while((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }

                out.flush();
            } catch (Exception var4) {
                logger.error(var4.getMessage(), var4);
            }
        }

    }
}
