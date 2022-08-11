//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("下载文件请求数据体")
public class DownloadFileData {
    @ApiModelProperty(
        value = "获取的是png图片还是加注件后的ofd文件",
        example = "ofd",
        required = true,
        notes = "获取ofd还是png图片"
    )
    private String fileType;
    @ApiModelProperty(
        value = "电子证照标识",
        example = "1.2.156.3005.2.11100000000013661B006.113700000045046442.209FA4E88F9E4C878F3E9BED2CE7EA49.001.M",
        required = true,
        notes = "电子证照唯一标识"
    )
    private String certificateIdentifier;
    @ApiModelProperty(
        value = "申请事由",
        example = "事由***",
        required = true,
        notes = "申请下载该文件的事由"
    )
    private String certificateCopyCause;
    @ApiModelProperty(
        value = "有效期截止时间",
        example = "''",
        required = false,
        notes = "电子证照加注件有效期截止时间，目前尚未启用，可为空"
    )
    private String certificateCopyExpiringTime;

    public DownloadFileData() {
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getCertificateIdentifier() {
        return this.certificateIdentifier;
    }

    public String getCertificateCopyCause() {
        return this.certificateCopyCause;
    }

    public String getCertificateCopyExpiringTime() {
        return this.certificateCopyExpiringTime;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setCertificateIdentifier(String certificateIdentifier) {
        this.certificateIdentifier = certificateIdentifier;
    }

    public void setCertificateCopyCause(String certificateCopyCause) {
        this.certificateCopyCause = certificateCopyCause;
    }

    public void setCertificateCopyExpiringTime(String certificateCopyExpiringTime) {
        this.certificateCopyExpiringTime = certificateCopyExpiringTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownloadFileData)) {
            return false;
        } else {
            DownloadFileData other = (DownloadFileData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$fileType = this.getFileType();
                    Object other$fileType = other.getFileType();
                    if (this$fileType == null) {
                        if (other$fileType == null) {
                            break label59;
                        }
                    } else if (this$fileType.equals(other$fileType)) {
                        break label59;
                    }

                    return false;
                }

                Object this$certificateIdentifier = this.getCertificateIdentifier();
                Object other$certificateIdentifier = other.getCertificateIdentifier();
                if (this$certificateIdentifier == null) {
                    if (other$certificateIdentifier != null) {
                        return false;
                    }
                } else if (!this$certificateIdentifier.equals(other$certificateIdentifier)) {
                    return false;
                }

                Object this$certificateCopyCause = this.getCertificateCopyCause();
                Object other$certificateCopyCause = other.getCertificateCopyCause();
                if (this$certificateCopyCause == null) {
                    if (other$certificateCopyCause != null) {
                        return false;
                    }
                } else if (!this$certificateCopyCause.equals(other$certificateCopyCause)) {
                    return false;
                }

                Object this$certificateCopyExpiringTime = this.getCertificateCopyExpiringTime();
                Object other$certificateCopyExpiringTime = other.getCertificateCopyExpiringTime();
                if (this$certificateCopyExpiringTime == null) {
                    if (other$certificateCopyExpiringTime != null) {
                        return false;
                    }
                } else if (!this$certificateCopyExpiringTime.equals(other$certificateCopyExpiringTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DownloadFileData;
    }

    public int hashCode() {

        int result = 1;
        Object $fileType = this.getFileType();
        result = result * 59 + ($fileType == null ? 43 : $fileType.hashCode());
        Object $certificateIdentifier = this.getCertificateIdentifier();
        result = result * 59 + ($certificateIdentifier == null ? 43 : $certificateIdentifier.hashCode());
        Object $certificateCopyCause = this.getCertificateCopyCause();
        result = result * 59 + ($certificateCopyCause == null ? 43 : $certificateCopyCause.hashCode());
        Object $certificateCopyExpiringTime = this.getCertificateCopyExpiringTime();
        result = result * 59 + ($certificateCopyExpiringTime == null ? 43 : $certificateCopyExpiringTime.hashCode());
        return result;
    }

    public String toString() {
        return "DownloadFileData(fileType=" + this.getFileType() + ", certificateIdentifier=" + this.getCertificateIdentifier() + ", certificateCopyCause=" + this.getCertificateCopyCause() + ", certificateCopyExpiringTime=" + this.getCertificateCopyExpiringTime() + ")";
    }
}
