//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dao;

import com.corrin.certshare.entity.FieldConvert;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldConvertRepository extends MongoRepository<FieldConvert, ObjectId> {
    @Query("{'$and':[{'licenseTypeCode':?0},{'isAutoAdjust':'1'}]}")
    List<FieldConvert> findByLicenseTypeCode(String var1);

    @Query("{'$and':[{'licenseTypeCode':?0},{'isAutoAdjust':'0'}]}")
    List<FieldConvert> findByLicenseTypeCodeIsAutoAdjust0(String var1);

    @Query("{'$and':[{'catalogId':?0},{'isAutoAdjust':'1'}]}")
    List<FieldConvert> findByCatalogId(String var1);

    @Query("{'$and':[{'catalogId':?0},{'isAutoAdjust':'0'}]}")
    List<FieldConvert> findByCatalogIdIsAutoAdjust0(String var1);
}
