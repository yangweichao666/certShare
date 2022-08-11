//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import com.suwell.ofd.custom.agent.ConvertAgent;
import com.suwell.ofd.custom.agent.ConvertException;
import com.suwell.ofd.custom.agent.HTTPAgent;
import com.suwell.ofd.custom.agent.StandaloneAgent;
import com.suwell.ofd.custom.wrapper.PackException;
import com.suwell.ofd.custom.wrapper.Const.XAlign;
import com.suwell.ofd.custom.wrapper.Const.YAlign;
import com.suwell.ofd.custom.wrapper.model.MarkPosition;
import com.suwell.ofd.custom.wrapper.model.TextInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import suwell.ofd.custom.agent.nw.Agent;

@Component
public class OfdUtil {
    Logger logger = LoggerFactory.getLogger(OfdUtil.class);
    private String textMark;
    private String fileId;
    private static String[] baseURL;
    private static String SUWELLSTRATEGY;
    private static String ADDSIGNMETHOD;
    private static String SUWELLPLUGINDIR;
    private static Random random = new Random();
    private static volatile AtomicInteger atomicInteger = new AtomicInteger(0);
    @Value("${ofdFilePath}")
    private String ofdFilePath;
    @Value("${srcFileNameExt}")
    private String srcFileNameExt;
    @Value("${destFileNameExt}")
    private String destFileNameExt;
    @Value("${fontName}")
    private String fontName;
    @Value("${fontSize}")
    private String fontSize;
    @Value("${color}")
    private String color;
    @Value("${rotate}")
    private String rotate;
    @Value("${pngDpi}")
    private int pngDpi;

    public OfdUtil() {
    }

    public void setTextMark(String textMark) {
        this.textMark = textMark;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Value("${addSignMethod}")
    private void setAddSignMethod(String addSignMethod) {
        ADDSIGNMETHOD = addSignMethod;
    }

    @Value("${suwellPluginDir}")
    private void setSuwellPluginDir(String suwellPluginDir) {
        SUWELLPLUGINDIR = suwellPluginDir;
    }

    @Value("${SuwellStrategy}")
    public void setSuwellStrategy(String suwellStrategy) {
        SUWELLSTRATEGY = suwellStrategy;
    }

    @Value("${HTTPAgentUrl}")
    public void setBaseURL(String HTTPAgentUrl) {
        baseURL = HTTPAgentUrl.split(",");
    }

    public static ConvertAgent getHTTPAgent() {
        if (ADDSIGNMETHOD.equals("0")) {
            int i = -1;
            if (SUWELLSTRATEGY.equals("1")) {
                i = atomicInteger.getAndIncrement();
                if (baseURL.length + 1 == atomicInteger.get()) {
                    atomicInteger.set(0);
                    i = atomicInteger.getAndIncrement();
                }
            } else if (SUWELLSTRATEGY.equals("2")) {
                i = random.nextInt(baseURL.length);
            }

            return OfdUtil.OfdUtil1.ha[i];
        } else if (ADDSIGNMETHOD.equals("1")) {
            return OfdUtil.OfdUtil1.sa;
        } else {
            System.out.println("配置错误！！数科转化配置未生效");
            return null;
        }
    }

    public void addWaterMarker(String textMark, String fileId) {
        try {
            new MarkPosition(10.0F, 20.0F, 200.0F, 300.0F, MarkPosition.INDEX_ALL);
            new TextInfo(textMark, this.fontName, (float)Integer.parseInt(this.fontSize), this.color, Integer.parseInt(this.rotate), XAlign.Center, YAlign.Middle);
            System.out.println("====#####");
            File file = new File(this.ofdFilePath + fileId + this.srcFileNameExt);
            File file1 = new File(this.ofdFilePath + fileId + this.destFileNameExt);
            copyFile(file, file1);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        } else if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        } else {
            FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream(destFile);
            byte[] buf = new byte[8192];

            int b;
            while((b = in.read(buf, 0, buf.length)) != -1) {
                out.write(buf, 0, b);
                out.flush();
            }

            in.close();
            out.close();
            System.out.println("文件copy完毕、");
        }
    }

    public List<String> ofd2png(String tempFileId) {
        List retStrList = null;

        try {
            getHTTPAgent().OFDToImge(new File(this.ofdFilePath + tempFileId + this.srcFileNameExt), new FileOutputStream(this.ofdFilePath + tempFileId + ".zip"), this.pngDpi, true);
            retStrList = unZip(this.ofdFilePath + tempFileId + ".zip", "utf-8");
        } catch (PackException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        } catch (ConvertException var6) {
            var6.printStackTrace();
        }

        return retStrList;
    }

    public void addWaterMarker1(String textMark, String fileId) {
        try {
            MarkPosition mp = new MarkPosition(10.0F, 20.0F, 200.0F, 300.0F, MarkPosition.INDEX_ALL);
            TextInfo textinfo = new TextInfo(textMark, this.fontName, (float)Integer.parseInt(this.fontSize), this.color, Integer.parseInt(this.rotate), XAlign.Center, YAlign.Middle);
            HTTPAgent httpAgent = (HTTPAgent)getHTTPAgent();
            File file = new File(this.ofdFilePath + fileId + this.srcFileNameExt);
            if (file.exists()) {
                httpAgent.addTextMark(file, new FileOutputStream(this.ofdFilePath + fileId + this.destFileNameExt), textinfo, mp, true, true);
            }
        } catch (IOException var7) {
            this.logger.error("IO异常：{}", var7.getMessage());
        } catch (ConvertException var8) {
            this.logger.error("Convert异常：{}", var8.getMessage());
            var8.printStackTrace();
        } catch (PackException var9) {
            this.logger.error("Pack异常：{}", var9.getMessage());
        }

    }

    public boolean deleteFile(String fileName) {
        String filePath = this.ofdFilePath + fileName + this.srcFileNameExt;
        String filePathWaterMarker = this.ofdFilePath + fileName + this.destFileNameExt;
        File file = new File(filePath);
        File fileWaterMarker = new File(filePathWaterMarker);
        boolean ret = false;
        if (file.exists()) {
            file.delete();
            this.logger.info("原始文件已删除，文件id为::{}\n", fileName);
            if (fileWaterMarker.exists()) {
                fileWaterMarker.delete();
                this.logger.info("水印文件已删除，文件id为::{}\n", fileName);
                ret = true;
            } else {
                this.logger.info("水印文件不存在，文件id为::{}\n", fileName);
            }
        } else {
            this.logger.info("原始文件不存在，文件id为:{}\n", fileName);
            if (fileWaterMarker.exists()) {
                fileWaterMarker.delete();
                this.logger.info("水印文件已删除，文件id为::{}\n", fileName);
                ret = true;
            } else {
                this.logger.info("水印文件都不存在，文件id为::{}\n", fileName);
            }
        }

        return ret;
    }

    public static List<String> unZip(String path, String code) {
        List<String> retStrList = new ArrayList();
        InputStream is = null;
        ZipFile zipFile = null;

        try {
            zipFile = new ZipFile(path, code);
            Enumeration entries = zipFile.getEntries();

            while(entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry)entries.nextElement();
                is = zipFile.getInputStream(entry);
                retStrList.add(Base64Util.ioToBase64(is));
            }

            zipFile.close();
        } catch (IOException var15) {
            var15.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (Exception var14) {
                var14.printStackTrace();
            }

        }

        return retStrList;
    }

    private static class OfdUtil1 {
        public static final HTTPAgent[] ha;
        public static StandaloneAgent sa;

        private OfdUtil1() {
        }

        static {
            ha = new HTTPAgent[OfdUtil.baseURL.length];

            for(int i = 0; i < OfdUtil.baseURL.length; ++i) {
                ha[i] = new HTTPAgent(OfdUtil.baseURL[i]);
            }

            sa = null;
            if (sa == null) {
                System.setProperty("sw.rpc.x2y", OfdUtil.SUWELLPLUGINDIR);
                sa = new StandaloneAgent();
                new Agent(sa);
            }

        }
    }
}
