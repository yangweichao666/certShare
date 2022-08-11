//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service.impl;

import com.corrin.certshare.dao.ICertNameUserRepository;
import com.corrin.certshare.entity.CertNameUser;
import com.corrin.certshare.service.CertNameUserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertNameUserServiceImpl implements CertNameUserService {
    @Autowired
    private ICertNameUserRepository iCertNameUserRepository;

    public CertNameUserServiceImpl() {
    }

    public CertNameUser save(CertNameUser certNameUser) {
        CertNameUser save = (CertNameUser)this.iCertNameUserRepository.save(certNameUser);
        return save;
    }

    public List<CertNameUser> findAllByAccountId(String accountId) {
        List<CertNameUser> certNameUserList = this.iCertNameUserRepository.findAllByAccountId(accountId);
        return certNameUserList.size() > 0 ? certNameUserList : null;
    }

    public List<CertNameUser> findAllByAccountIdCertName(String accountId, String certName) {
        List<CertNameUser> certNameUserList = this.iCertNameUserRepository.findAllByAccountIdCertName(accountId, certName);
        return certNameUserList.size() > 0 ? certNameUserList : null;
    }

    public void delete(CertNameUser certNameUser) {
        this.iCertNameUserRepository.delete(certNameUser);
    }

    public CertNameUser findOneByAccountId(String accountId) {
        CertNameUser certNameUser = this.iCertNameUserRepository.findOneByAccountId(accountId);
        return certNameUser;
    }

    public Map<String, String> findKVByAccountId(String accountId) {
        CertNameUser certNameUser = this.findOneByAccountId(accountId);
        if (certNameUser != null && certNameUser.getIsEnable().equals(1)) {
            String certificateKV = certNameUser.getCertificateKV();
            Gson gson = new Gson();
            Map<String, String> map = (Map)gson.fromJson(certificateKV, (new TypeToken<Map<String, String>>() {
            }).getType());
            return map;
        } else {
            return null;
        }
    }
}
