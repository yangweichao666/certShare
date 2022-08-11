//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.reqzz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("文件下载地址对象")
public class DownLoadUrlDatazz {
    @ApiModelProperty("电子证照标识")
    private String certificateIdentifier;
    @ApiModelProperty("申请事由")
    private String certificateCopyCause;
    @ApiModelProperty("有效期截止时间")
    private String certificateCopyCauseExpiringTime;

    public DownLoadUrlDatazz() {
    }

    public String getCertificateIdentifier() {
        return this.certificateIdentifier;
    }

    public String getCertificateCopyCause() {
        return this.certificateCopyCause;
    }

    public String getCertificateCopyCauseExpiringTime() {
        return this.certificateCopyCauseExpiringTime;
    }

    public void setCertificateIdentifier(String certificateIdentifier) {
        this.certificateIdentifier = certificateIdentifier;
    }

    public void setCertificateCopyCause(String certificateCopyCause) {
        this.certificateCopyCause = certificateCopyCause;
    }

    public void setCertificateCopyCauseExpiringTime(String certificateCopyCauseExpiringTime) {
        this.certificateCopyCauseExpiringTime = certificateCopyCauseExpiringTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownLoadUrlDatazz)) {
            return false;
        } else {
            DownLoadUrlDatazz other = (DownLoadUrlDatazz)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$certificateIdentifier = this.getCertificateIdentifier();
                    Object other$certificateIdentifier = other.getCertificateIdentifier();
                    if (this$certificateIdentifier == null) {
                        if (other$certificateIdentifier == null) {
                            break label47;
                        }
                    } else if (this$certificateIdentifier.equals(other$certificateIdentifier)) {
                        break label47;
                    }

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

                Object this$certificateCopyCauseExpiringTime = this.getCertificateCopyCauseExpiringTime();
                Object other$certificateCopyCauseExpiringTime = other.getCertificateCopyCauseExpiringTime();
                if (this$certificateCopyCauseExpiringTime == null) {
                    if (other$certificateCopyCauseExpiringTime != null) {
                        return false;
                    }
                } else if (!this$certificateCopyCauseExpiringTime.equals(other$certificateCopyCauseExpiringTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DownLoadUrlDatazz;
    }

    public int hashCode() {

        int result = 1;
        Object $certificateIdentifier = this.getCertificateIdentifier();
        result = result * 59 + ($certificateIdentifier == null ? 43 : $certificateIdentifier.hashCode());
        Object $certificateCopyCause = this.getCertificateCopyCause();
        result = result * 59 + ($certificateCopyCause == null ? 43 : $certificateCopyCause.hashCode());
        Object $certificateCopyCauseExpiringTime = this.getCertificateCopyCauseExpiringTime();
        result = result * 59 + ($certificateCopyCauseExpiringTime == null ? 43 : $certificateCopyCauseExpiringTime.hashCode());
        return result;
    }

    public String toString() {
        return "DownLoadUrlDatazz(certificateIdentifier=" + this.getCertificateIdentifier() + ", certificateCopyCause=" + this.getCertificateCopyCause() + ", certificateCopyCauseExpiringTime=" + this.getCertificateCopyCauseExpiringTime() + ")";
    }
}
