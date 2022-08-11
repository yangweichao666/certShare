//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.schedule;

import com.corrin.certshare.entity.TempDownloadUrlExpireTime;
import com.corrin.certshare.service.TempDownloadUrlExpireTimeService;
import com.corrin.certshare.utils.OfdUtil;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteOfdSchedule {
    @Value("${deleteFileRightNow}")
    private String deleteFileRightNow;
    @Value("${deleteDatabaseOfdGenRecord}")
    private String deleteDatabaseOfdGenRecord;
    @Autowired
    private TempDownloadUrlExpireTimeService tempDownloadUrlExpireTimeService;
    @Autowired
    private OfdUtil ofdUtil;

    public DeleteOfdSchedule() {
    }

    @Scheduled(
        cron = "${deleteFileCron}"
    )
    public void deleteOfdTemp() {
        if (this.deleteFileRightNow.equals("1") || this.deleteFileRightNow.equals("2")) {
            List<TempDownloadUrlExpireTime> byExpiredTimeList = this.tempDownloadUrlExpireTimeService.findByExpiredTime(new Date());

            for(int i = byExpiredTimeList.size() - 1; i >= 0; --i) {
                TempDownloadUrlExpireTime tempDownloadUrlExpireTime = (TempDownloadUrlExpireTime)byExpiredTimeList.get(i);
                this.ofdUtil.deleteFile(tempDownloadUrlExpireTime.getTempFileId());
                if (this.deleteDatabaseOfdGenRecord.equals("1")) {
                    this.tempDownloadUrlExpireTimeService.delete(tempDownloadUrlExpireTime);
                } else if (this.deleteDatabaseOfdGenRecord.equals("0")) {
                    tempDownloadUrlExpireTime.setIsFileDeleted(1);
                    this.tempDownloadUrlExpireTimeService.save(tempDownloadUrlExpireTime);
                }
            }
        }

    }
}
