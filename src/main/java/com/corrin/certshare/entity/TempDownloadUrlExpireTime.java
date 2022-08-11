//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("TempDownloadUrlExpireTime")
public class TempDownloadUrlExpireTime {
    @Id
    @Field("_id")
    private ObjectId id;
    @Field("accountId")
    private String accountId;
    @NotNull
    @Length(
        min = 1,
        max = 100
    )
    @Field("certificateName")
    private String certificateName;
    @Field("tempFileId")
    private String tempFileId;
    @Field("fileId")
    private String fileId;
    @Field("isDownloaded")
    private Integer isDownloaded;
    @Field("isFileDeleted")
    private Integer isFileDeleted;
    @Field("createTime")
    private Date createTime;
    @Field("expiredTime")
    private Date expiredTime;

    public TempDownloadUrlExpireTime() {
    }

    public ObjectId getId() {
        return this.id;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getCertificateName() {
        return this.certificateName;
    }

    public String getTempFileId() {
        return this.tempFileId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public Integer getIsDownloaded() {
        return this.isDownloaded;
    }

    public Integer getIsFileDeleted() {
        return this.isFileDeleted;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getExpiredTime() {
        return this.expiredTime;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public void setTempFileId(String tempFileId) {
        this.tempFileId = tempFileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setIsDownloaded(Integer isDownloaded) {
        this.isDownloaded = isDownloaded;
    }

    public void setIsFileDeleted(Integer isFileDeleted) {
        this.isFileDeleted = isFileDeleted;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TempDownloadUrlExpireTime)) {
            return false;
        } else {
            TempDownloadUrlExpireTime other = (TempDownloadUrlExpireTime)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label119: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label119;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label119;
                    }

                    return false;
                }

                Object this$accountId = this.getAccountId();
                Object other$accountId = other.getAccountId();
                if (this$accountId == null) {
                    if (other$accountId != null) {
                        return false;
                    }
                } else if (!this$accountId.equals(other$accountId)) {
                    return false;
                }

                label105: {
                    Object this$certificateName = this.getCertificateName();
                    Object other$certificateName = other.getCertificateName();
                    if (this$certificateName == null) {
                        if (other$certificateName == null) {
                            break label105;
                        }
                    } else if (this$certificateName.equals(other$certificateName)) {
                        break label105;
                    }

                    return false;
                }

                Object this$tempFileId = this.getTempFileId();
                Object other$tempFileId = other.getTempFileId();
                if (this$tempFileId == null) {
                    if (other$tempFileId != null) {
                        return false;
                    }
                } else if (!this$tempFileId.equals(other$tempFileId)) {
                    return false;
                }

                label91: {
                    Object this$fileId = this.getFileId();
                    Object other$fileId = other.getFileId();
                    if (this$fileId == null) {
                        if (other$fileId == null) {
                            break label91;
                        }
                    } else if (this$fileId.equals(other$fileId)) {
                        break label91;
                    }

                    return false;
                }

                Object this$isDownloaded = this.getIsDownloaded();
                Object other$isDownloaded = other.getIsDownloaded();
                if (this$isDownloaded == null) {
                    if (other$isDownloaded != null) {
                        return false;
                    }
                } else if (!this$isDownloaded.equals(other$isDownloaded)) {
                    return false;
                }

                label77: {
                    Object this$isFileDeleted = this.getIsFileDeleted();
                    Object other$isFileDeleted = other.getIsFileDeleted();
                    if (this$isFileDeleted == null) {
                        if (other$isFileDeleted == null) {
                            break label77;
                        }
                    } else if (this$isFileDeleted.equals(other$isFileDeleted)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$createTime = this.getCreateTime();
                    Object other$createTime = other.getCreateTime();
                    if (this$createTime == null) {
                        if (other$createTime == null) {
                            break label70;
                        }
                    } else if (this$createTime.equals(other$createTime)) {
                        break label70;
                    }

                    return false;
                }

                Object this$expiredTime = this.getExpiredTime();
                Object other$expiredTime = other.getExpiredTime();
                if (this$expiredTime == null) {
                    if (other$expiredTime != null) {
                        return false;
                    }
                } else if (!this$expiredTime.equals(other$expiredTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof TempDownloadUrlExpireTime;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        Object $certificateName = this.getCertificateName();
        result = result * 59 + ($certificateName == null ? 43 : $certificateName.hashCode());
        Object $tempFileId = this.getTempFileId();
        result = result * 59 + ($tempFileId == null ? 43 : $tempFileId.hashCode());
        Object $fileId = this.getFileId();
        result = result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
        Object $isDownloaded = this.getIsDownloaded();
        result = result * 59 + ($isDownloaded == null ? 43 : $isDownloaded.hashCode());
        Object $isFileDeleted = this.getIsFileDeleted();
        result = result * 59 + ($isFileDeleted == null ? 43 : $isFileDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $expiredTime = this.getExpiredTime();
        result = result * 59 + ($expiredTime == null ? 43 : $expiredTime.hashCode());
        return result;
    }

    public String toString() {
        return "TempDownloadUrlExpireTime(id=" + this.getId() + ", accountId=" + this.getAccountId() + ", certificateName=" + this.getCertificateName() + ", tempFileId=" + this.getTempFileId() + ", fileId=" + this.getFileId() + ", isDownloaded=" + this.getIsDownloaded() + ", isFileDeleted=" + this.getIsFileDeleted() + ", createTime=" + this.getCreateTime() + ", expiredTime=" + this.getExpiredTime() + ")";
    }
}
