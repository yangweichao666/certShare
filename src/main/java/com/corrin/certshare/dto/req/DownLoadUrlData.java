//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("证照文件下载地址对象")
public class DownLoadUrlData {
    @ApiModelProperty(
        value = "电子证照标识",
        example = "1.2.156.3005.2.11100000000013661B006.113700000045046442.209FA4E88F9E4C878F3E9BED2CE7EA49.001.M",
        required = true,
        notes = "电子证照唯一标识"
    )
    private String certIdentifier;
    @ApiModelProperty(
        value = "申请事由",
        example = "事由***",
        required = true,
        notes = "申请下载该文件的事由"
    )
    private String useCause;
    @ApiModelProperty(
        value = "有效期截止时间",
        example = "''",
        required = false,
        notes = "电子证照加注件有效期截止时间，目前尚未启用，可为空"
    )
    private String expiryTime;

    public DownLoadUrlData() {
    }

    public String getCertIdentifier() {
        return this.certIdentifier;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public String getExpiryTime() {
        return this.expiryTime;
    }

    public void setCertIdentifier(String certIdentifier) {
        this.certIdentifier = certIdentifier;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownLoadUrlData)) {
            return false;
        } else {
            DownLoadUrlData other = (DownLoadUrlData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$certIdentifier = this.getCertIdentifier();
                    Object other$certIdentifier = other.getCertIdentifier();
                    if (this$certIdentifier == null) {
                        if (other$certIdentifier == null) {
                            break label47;
                        }
                    } else if (this$certIdentifier.equals(other$certIdentifier)) {
                        break label47;
                    }

                    return false;
                }

                Object this$useCause = this.getUseCause();
                Object other$useCause = other.getUseCause();
                if (this$useCause == null) {
                    if (other$useCause != null) {
                        return false;
                    }
                } else if (!this$useCause.equals(other$useCause)) {
                    return false;
                }

                Object this$expiryTime = this.getExpiryTime();
                Object other$expiryTime = other.getExpiryTime();
                if (this$expiryTime == null) {
                    if (other$expiryTime != null) {
                        return false;
                    }
                } else if (!this$expiryTime.equals(other$expiryTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DownLoadUrlData;
    }

    public int hashCode() {

        int result = 1;
        Object $certIdentifier = this.getCertIdentifier();
        result = result * 59 + ($certIdentifier == null ? 43 : $certIdentifier.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        Object $expiryTime = this.getExpiryTime();
        result = result * 59 + ($expiryTime == null ? 43 : $expiryTime.hashCode());
        return result;
    }

    public String toString() {
        return "DownLoadUrlData(certIdentifier=" + this.getCertIdentifier() + ", useCause=" + this.getUseCause() + ", expiryTime=" + this.getExpiryTime() + ")";
    }
}
