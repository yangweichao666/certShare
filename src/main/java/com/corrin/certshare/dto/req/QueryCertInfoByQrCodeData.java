//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通过二维码获取电子证照信息对象")
public class QueryCertInfoByQrCodeData {
    @ApiModelProperty(
        value = "电子证照二维码信息",
        example = "4642087996",
        required = true,
        notes = "电子证照二维码信息"
    )
    private String qrcode;
    @ApiModelProperty(
        value = "申请事由，不超过200字【必填】",
        example = "事由***",
        required = true,
        notes = "申请事由，不超过200字【必填】"
    )
    private String useCause;

    public QueryCertInfoByQrCodeData() {
    }

    public String getQrcode() {
        return this.qrcode;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoByQrCodeData)) {
            return false;
        } else {
            QueryCertInfoByQrCodeData other = (QueryCertInfoByQrCodeData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$qrcode = this.getQrcode();
                Object other$qrcode = other.getQrcode();
                if (this$qrcode == null) {
                    if (other$qrcode != null) {
                        return false;
                    }
                } else if (!this$qrcode.equals(other$qrcode)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryCertInfoByQrCodeData;
    }

    public int hashCode() {

        int result = 1;
        Object $qrcode = this.getQrcode();
        result = result * 59 + ($qrcode == null ? 43 : $qrcode.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoByQrCodeData(qrcode=" + this.getQrcode() + ", useCause=" + this.getUseCause() + ")";
    }
}
