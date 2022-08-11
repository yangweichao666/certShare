//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dao;

import com.corrin.certshare.entity.CertNameUser;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICertNameUserRepository extends MongoRepository<CertNameUser, ObjectId> {
    @Query(
        value = "{'accountId':'?0','isEnable':1}",
        sort = "{'updateTime':-1}"
    )
    List<CertNameUser> findAllByAccountId(String var1);

    @Query(
        value = "{'accountId':'?0','certificateName':'?1'}",
        sort = "{'updateTime':-1}"
    )
    List<CertNameUser> findAllByAccountIdCertName(String var1, String var2);

    @Query(
        value = "{'accountId':'?0'}",
        sort = "{'updateTime':-1}"
    )
    CertNameUser findOneByAccountId(String var1);
}
