//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service;

import com.corrin.certshare.entity.CertNameUser;
import java.util.List;
import java.util.Map;

public interface CertNameUserService {
    CertNameUser save(CertNameUser var1);

    List<CertNameUser> findAllByAccountId(String var1);

    List<CertNameUser> findAllByAccountIdCertName(String var1, String var2);

    void delete(CertNameUser var1);

    CertNameUser findOneByAccountId(String var1);

    Map<String, String> findKVByAccountId(String var1);
}
