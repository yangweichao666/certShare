//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询证照解析数据体")
public class CertRemarkData {
    @ApiModelProperty(
        value = "证照名称",
        example = "危险化学品经营许可证",
        required = true,
        notes = "证照名称"
    )
    private String certName;
    @ApiModelProperty(
        value = "证照类型代码【只是测试值，正式的为代码】",
        example = "危险化学品经营许可证",
        required = true,
        notes = "证照类型代码"
    )
    private String certTypeCode;

    public CertRemarkData() {
    }

    public String getCertName() {
        return this.certName;
    }

    public String getCertTypeCode() {
        return this.certTypeCode;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public void setCertTypeCode(String certTypeCode) {
        this.certTypeCode = certTypeCode;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CertRemarkData)) {
            return false;
        } else {
            CertRemarkData other = (CertRemarkData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$certName = this.getCertName();
                Object other$certName = other.getCertName();
                if (this$certName == null) {
                    if (other$certName != null) {
                        return false;
                    }
                } else if (!this$certName.equals(other$certName)) {
                    return false;
                }

                Object this$certTypeCode = this.getCertTypeCode();
                Object other$certTypeCode = other.getCertTypeCode();
                if (this$certTypeCode == null) {
                    if (other$certTypeCode != null) {
                        return false;
                    }
                } else if (!this$certTypeCode.equals(other$certTypeCode)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CertRemarkData;
    }

    public int hashCode() {

        int result = 1;
        Object $certName = this.getCertName();
        result = result * 59 + ($certName == null ? 43 : $certName.hashCode());
        Object $certTypeCode = this.getCertTypeCode();
        result = result * 59 + ($certTypeCode == null ? 43 : $certTypeCode.hashCode());
        return result;
    }

    public String toString() {
        return "CertRemarkData(certName=" + this.getCertName() + ", certTypeCode=" + this.getCertTypeCode() + ")";
    }
}
