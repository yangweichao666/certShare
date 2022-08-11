//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TimeCalculateUtil {
    private static Logger logger = LoggerFactory.getLogger(TimeCalculateUtil.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Value("${tempDownloadUrlValidTime}")
    private String tempDownloadUrlValidTimeStr;

    public TimeCalculateUtil() {
    }

    public Date getExpiredTime(Date createTime) {
        Integer tempDownloadUrlValidTime = 0;

        try {
            tempDownloadUrlValidTime = Integer.parseInt(this.tempDownloadUrlValidTimeStr.trim());
            logger.debug("-------------------------");
            logger.debug(tempDownloadUrlValidTime.toString());
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);
        calendar.add(13, tempDownloadUrlValidTime);
        return calendar.getTime();
    }

    public boolean isExpired(Date from, Date to) {
        Date expiredTime = this.getExpiredTime(from);
        return expiredTime.before(to);
    }

    public String date2String(Date date) {
        return simpleDateFormat.format(date);
    }
}
