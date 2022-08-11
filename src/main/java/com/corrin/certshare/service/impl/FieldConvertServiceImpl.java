//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service.impl;

import com.corrin.certshare.dao.IFieldConvertRepository;
import com.corrin.certshare.entity.FieldConvert;
import com.corrin.certshare.service.IFieldConvertService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldConvertServiceImpl implements IFieldConvertService {
    @Autowired
    private IFieldConvertRepository iFieldConvertRepository;

    public FieldConvertServiceImpl() {
    }

    public List<FieldConvert> findByLicenseTypeCode(String licenseTypeCode) {
        List<FieldConvert> byLicenseTypeCode = this.iFieldConvertRepository.findByLicenseTypeCode(licenseTypeCode);
        return byLicenseTypeCode;
    }

    public FieldConvert save(FieldConvert fieldConvert) {
        FieldConvert save = (FieldConvert)this.iFieldConvertRepository.save(fieldConvert);
        return save;
    }

    public List<FieldConvert> findByLicenseTypeCodeIsAutoAdjust0(String licenseTypeCode) {
        List<FieldConvert> byLicenseTypeCode = this.iFieldConvertRepository.findByLicenseTypeCodeIsAutoAdjust0(licenseTypeCode);
        return byLicenseTypeCode;
    }

    public List<FieldConvert> findByCatalogId(String catalogId) {
        List<FieldConvert> byCatalogId = this.iFieldConvertRepository.findByCatalogId(catalogId);
        return byCatalogId;
    }

    public List<FieldConvert> findByCatalogIdIsAutoAdjust0(String catalogId) {
        List<FieldConvert> byCatalogId = this.iFieldConvertRepository.findByCatalogIdIsAutoAdjust0(catalogId);
        return byCatalogId;
    }
}
