//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service;

import com.corrin.certshare.entity.FieldConvert;
import java.util.List;

public interface IFieldConvertService {
    List<FieldConvert> findByLicenseTypeCode(String var1);

    List<FieldConvert> findByLicenseTypeCodeIsAutoAdjust0(String var1);

    List<FieldConvert> findByCatalogId(String var1);

    List<FieldConvert> findByCatalogIdIsAutoAdjust0(String var1);

    FieldConvert save(FieldConvert var1);
}
