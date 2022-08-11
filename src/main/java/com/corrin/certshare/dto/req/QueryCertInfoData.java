//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("电子证照信息查询对象")
public class QueryCertInfoData {
    @ApiModelProperty(
        value = "电子证照唯一标识",
        example = "1.2.156.3005.2.11100000000013661B006.113700000045046442.209FA4E88F9E4C878F3E9BED2CE7EA49.001.M",
        required = true,
        notes = "电子证照唯一标识"
    )
    private String certIdentifier;
    @ApiModelProperty(
        value = "申请事由，不超过200字【必填】",
        example = "事由***",
        required = true,
        notes = "申请事由，不超过200字【必填】"
    )
    private String useCause;

    public QueryCertInfoData() {
    }

    public String getCertIdentifier() {
        return this.certIdentifier;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public void setCertIdentifier(String certIdentifier) {
        this.certIdentifier = certIdentifier;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoData)) {
            return false;
        } else {
            QueryCertInfoData other = (QueryCertInfoData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$certIdentifier = this.getCertIdentifier();
                Object other$certIdentifier = other.getCertIdentifier();
                if (this$certIdentifier == null) {
                    if (other$certIdentifier != null) {
                        return false;
                    }
                } else if (!this$certIdentifier.equals(other$certIdentifier)) {
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
        return other instanceof QueryCertInfoData;
    }

    public int hashCode() {

        int result = 1;
        Object $certIdentifier = this.getCertIdentifier();
        result = result * 59 + ($certIdentifier == null ? 43 : $certIdentifier.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoData(certIdentifier=" + this.getCertIdentifier() + ", useCause=" + this.getUseCause() + ")";
    }
}
