//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service.impl;

import com.corrin.certshare.dao.ITempDownloadUrlExpireTimeRepository;
import com.corrin.certshare.entity.TempDownloadUrlExpireTime;
import com.corrin.certshare.service.TempDownloadUrlExpireTimeService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempDownloadUrlExpireTimeServiceImpl implements TempDownloadUrlExpireTimeService {
    @Autowired
    private ITempDownloadUrlExpireTimeRepository iTempDownloadUrlExpireTimeRepository;

    public TempDownloadUrlExpireTimeServiceImpl() {
    }

    public TempDownloadUrlExpireTime save(TempDownloadUrlExpireTime tempDownloadUrlExpireTime) {
        TempDownloadUrlExpireTime save = (TempDownloadUrlExpireTime)this.iTempDownloadUrlExpireTimeRepository.save(tempDownloadUrlExpireTime);
        return save;
    }

    public TempDownloadUrlExpireTime findOneByTempFileId(String tempFileId) {
        TempDownloadUrlExpireTime tempDownloadUrlExpireTime = this.iTempDownloadUrlExpireTimeRepository.findOneByTempFileId(tempFileId);
        return tempDownloadUrlExpireTime;
    }

    public List<TempDownloadUrlExpireTime> findByExpiredTime(Date date) {
        List<TempDownloadUrlExpireTime> expiredTempFileIdsList = this.iTempDownloadUrlExpireTimeRepository.findByExpiredTime(date);
        return expiredTempFileIdsList;
    }

    public void delete(TempDownloadUrlExpireTime tempDownloadUrlExpireTime) {
        this.iTempDownloadUrlExpireTimeRepository.delete(tempDownloadUrlExpireTime);
    }
}
