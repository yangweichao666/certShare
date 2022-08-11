//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.entity;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("CertNameUser")
public class CertNameUser {
    private static final long serialVersionUID = 121111L;
    @Field("accountId")
    private String accountId;
    @Field("certificateKV")
    private String certificateKV;
    @Field("isEnable")
    private Integer isEnable;
    @Field("createTime")
    private Date createTime;
    @Field("updateTime")
    private Date updateTime;

    public CertNameUser() {
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getCertificateKV() {
        return this.certificateKV;
    }

    public Integer getIsEnable() {
        return this.isEnable;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCertificateKV(String certificateKV) {
        this.certificateKV = certificateKV;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CertNameUser)) {
            return false;
        } else {
            CertNameUser other = (CertNameUser)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$accountId = this.getAccountId();
                    Object other$accountId = other.getAccountId();
                    if (this$accountId == null) {
                        if (other$accountId == null) {
                            break label71;
                        }
                    } else if (this$accountId.equals(other$accountId)) {
                        break label71;
                    }

                    return false;
                }

                Object this$certificateKV = this.getCertificateKV();
                Object other$certificateKV = other.getCertificateKV();
                if (this$certificateKV == null) {
                    if (other$certificateKV != null) {
                        return false;
                    }
                } else if (!this$certificateKV.equals(other$certificateKV)) {
                    return false;
                }

                label57: {
                    Object this$isEnable = this.getIsEnable();
                    Object other$isEnable = other.getIsEnable();
                    if (this$isEnable == null) {
                        if (other$isEnable == null) {
                            break label57;
                        }
                    } else if (this$isEnable.equals(other$isEnable)) {
                        break label57;
                    }

                    return false;
                }

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                Object this$updateTime = this.getUpdateTime();
                Object other$updateTime = other.getUpdateTime();
                if (this$updateTime == null) {
                    if (other$updateTime == null) {
                        return true;
                    }
                } else if (this$updateTime.equals(other$updateTime)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CertNameUser;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        Object $certificateKV = this.getCertificateKV();
        result = result * 59 + ($certificateKV == null ? 43 : $certificateKV.hashCode());
        Object $isEnable = this.getIsEnable();
        result = result * 59 + ($isEnable == null ? 43 : $isEnable.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    public String toString() {
        return "CertNameUser(accountId=" + this.getAccountId() + ", certificateKV=" + this.getCertificateKV() + ", isEnable=" + this.getIsEnable() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }
}
