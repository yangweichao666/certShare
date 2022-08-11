//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service;

import com.corrin.certshare.entity.TempDownloadUrlExpireTime;
import java.util.Date;
import java.util.List;

public interface TempDownloadUrlExpireTimeService {
    TempDownloadUrlExpireTime save(TempDownloadUrlExpireTime var1);

    TempDownloadUrlExpireTime findOneByTempFileId(String var1);

    List<TempDownloadUrlExpireTime> findByExpiredTime(Date var1);

    void delete(TempDownloadUrlExpireTime var1);
}
