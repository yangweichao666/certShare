//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("证照持有主体代码请求数据")
public class QueryCertInfoByHolderCodeData {
    @ApiModelProperty(
        value = "持证主体代码，如：身份证中的身份证号码",
        example = "'91370406L24894136J'",
        required = true,
        notes = "持证主体代码，如：身份证中的身份证号码"
    )
    private String holderCode;
    @ApiModelProperty(
        value = "持证主体代码类型代码",
        required = true,
        example = "'111'",
        notes = "111 公民身份证号码 001 统一社会信用代码，其值应遵循《GB∕T 36903-2018 电子证照元数据规范》"
    )
    private String holderTypeCode;
    @ApiModelProperty(
        value = "证照类型代码",
        example = "危险化学品经营许可证",
        required = true,
        notes = "证照类型代码"
    )
    private String certTypeCode;
    @ApiModelProperty(
        value = "证照编号",
        example = "''",
        required = false,
        notes = "证照编号,可为空"
    )
    private String certNo;
    @ApiModelProperty(
        value = "申请事由，不超过200字【必填】",
        example = "事由***",
        required = true,
        notes = "申请事由，不超过200字【必填】"
    )
    private String useCause;

    public QueryCertInfoByHolderCodeData() {
    }

    public String getHolderCode() {
        return this.holderCode;
    }

    public String getHolderTypeCode() {
        return this.holderTypeCode;
    }

    public String getCertTypeCode() {
        return this.certTypeCode;
    }

    public String getCertNo() {
        return this.certNo;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public void setHolderCode(String holderCode) {
        this.holderCode = holderCode;
    }

    public void setHolderTypeCode(String holderTypeCode) {
        this.holderTypeCode = holderTypeCode;
    }

    public void setCertTypeCode(String certTypeCode) {
        this.certTypeCode = certTypeCode;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoByHolderCodeData)) {
            return false;
        } else {
            QueryCertInfoByHolderCodeData other = (QueryCertInfoByHolderCodeData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$holderCode = this.getHolderCode();
                    Object other$holderCode = other.getHolderCode();
                    if (this$holderCode == null) {
                        if (other$holderCode == null) {
                            break label71;
                        }
                    } else if (this$holderCode.equals(other$holderCode)) {
                        break label71;
                    }

                    return false;
                }

                Object this$holderTypeCode = this.getHolderTypeCode();
                Object other$holderTypeCode = other.getHolderTypeCode();
                if (this$holderTypeCode == null) {
                    if (other$holderTypeCode != null) {
                        return false;
                    }
                } else if (!this$holderTypeCode.equals(other$holderTypeCode)) {
                    return false;
                }

                label57: {
                    Object this$certTypeCode = this.getCertTypeCode();
                    Object other$certTypeCode = other.getCertTypeCode();
                    if (this$certTypeCode == null) {
                        if (other$certTypeCode == null) {
                            break label57;
                        }
                    } else if (this$certTypeCode.equals(other$certTypeCode)) {
                        break label57;
                    }

                    return false;
                }

                Object this$certNo = this.getCertNo();
                Object other$certNo = other.getCertNo();
                if (this$certNo == null) {
                    if (other$certNo != null) {
                        return false;
                    }
                } else if (!this$certNo.equals(other$certNo)) {
                    return false;
                }

                Object this$useCause = this.getUseCause();
                Object other$useCause = other.getUseCause();
                if (this$useCause == null) {
                    if (other$useCause == null) {
                        return true;
                    }
                } else if (this$useCause.equals(other$useCause)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryCertInfoByHolderCodeData;
    }

    public int hashCode() {
        int result = 1;
        Object $holderCode = this.getHolderCode();
        result = result * 59 + ($holderCode == null ? 43 : $holderCode.hashCode());
        Object $holderTypeCode = this.getHolderTypeCode();
        result = result * 59 + ($holderTypeCode == null ? 43 : $holderTypeCode.hashCode());
        Object $certTypeCode = this.getCertTypeCode();
        result = result * 59 + ($certTypeCode == null ? 43 : $certTypeCode.hashCode());
        Object $certNo = this.getCertNo();
        result = result * 59 + ($certNo == null ? 43 : $certNo.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoByHolderCodeData(holderCode=" + this.getHolderCode() + ", holderTypeCode=" + this.getHolderTypeCode() + ", certTypeCode=" + this.getCertTypeCode() + ", certNo=" + this.getCertNo() + ", useCause=" + this.getUseCause() + ")";
    }
}
