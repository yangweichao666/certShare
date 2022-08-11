//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dao;

import com.corrin.certshare.entity.TempDownloadUrlExpireTime;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITempDownloadUrlExpireTimeRepository extends MongoRepository<TempDownloadUrlExpireTime, ObjectId> {
    @Query("{'tempFileId':'?0'}")
    TempDownloadUrlExpireTime findOneByTempFileId(String var1);

    @Query("{'expiredTime':{'$lt':?0},'isFileDeleted':0}")
    List<TempDownloadUrlExpireTime> findByExpiredTime(Date var1);
}
