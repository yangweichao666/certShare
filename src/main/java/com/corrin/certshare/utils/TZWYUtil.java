//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import com.suwell.ofd.custom.agent.HTTPAgent;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class TZWYUtil {
    Logger logger = LoggerFactory.getLogger(OfdUtil.class);
    private String textMark;
    private String fileId;
    private static String[] baseURL;
    private static String TZWYStrategy;
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

    public TZWYUtil() {
    }

    public void setTextMark(String textMark) {
        this.textMark = textMark;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Value("${TZWYStrategy}")
    public void setSuwellStrategy(String tzwyStrategy) {
        TZWYStrategy = tzwyStrategy;
    }

    @Value("${TZWYSignUrl}")
    public void setBaseURL(String tzwySignUrl) {
        baseURL = tzwySignUrl.split(",");
    }

    private static class TZWYUtil1 {
        public static final HTTPAgent[] ha;

        private TZWYUtil1() {
        }

        static {
            ha = new HTTPAgent[TZWYUtil.baseURL.length];

            for(int i = 0; i < TZWYUtil.baseURL.length; ++i) {
                ha[i] = new HTTPAgent(TZWYUtil.baseURL[i]);
            }

        }
    }
}
