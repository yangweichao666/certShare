//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("证照信息验证数据体")
public class VerifyCertInfoData {
    @ApiModelProperty(
        value = "证照类型代码",
        example = "危险化学品经营许可证",
        required = true,
        notes = "证照类型代码"
    )
    private String certTypeCode;
    @ApiModelProperty(
        value = "要查验的电子证照数据json字符串",
        example = "{'holderCode': '91370406L24894136J','holder': '枣庄市山亭区金鹏加油站','certNo': '鲁枣危化经〔2018〕000012号','qymc': '枣庄市山亭区金鹏加油站','qyzs': '山亭区北庄镇青石岭村南新枣公路128公里处路西','xkfw': '乙醇汽油、柴油***','jyfs': '带有储存设施的经营***','yxqyxz': '','QYFDDBR':'高明锋'}",
        required = true,
        notes = "要查验的电子证照数据json字符串"
    )
    private Object certData;
    @ApiModelProperty(
        value = "申请事由，不超过200字",
        example = "事由***",
        required = true,
        notes = "申请事由，不超过200字"
    )
    private String useCause;

    public VerifyCertInfoData() {
    }

    public String getCertTypeCode() {
        return this.certTypeCode;
    }

    public Object getCertData() {
        return this.certData;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public void setCertTypeCode(String certTypeCode) {
        this.certTypeCode = certTypeCode;
    }

    public void setCertData(Object certData) {
        this.certData = certData;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VerifyCertInfoData)) {
            return false;
        } else {
            VerifyCertInfoData other = (VerifyCertInfoData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$certTypeCode = this.getCertTypeCode();
                    Object other$certTypeCode = other.getCertTypeCode();
                    if (this$certTypeCode == null) {
                        if (other$certTypeCode == null) {
                            break label47;
                        }
                    } else if (this$certTypeCode.equals(other$certTypeCode)) {
                        break label47;
                    }

                    return false;
                }

                Object this$certData = this.getCertData();
                Object other$certData = other.getCertData();
                if (this$certData == null) {
                    if (other$certData != null) {
                        return false;
                    }
                } else if (!this$certData.equals(other$certData)) {
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
        return other instanceof VerifyCertInfoData;
    }

    public int hashCode() {

        int result = 1;
        Object $certTypeCode = this.getCertTypeCode();
        result = result * 59 + ($certTypeCode == null ? 43 : $certTypeCode.hashCode());
        Object $certData = this.getCertData();
        result = result * 59 + ($certData == null ? 43 : $certData.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        return result;
    }

    public String toString() {
        return "VerifyCertInfoData(certTypeCode=" + this.getCertTypeCode() + ", certData=" + this.getCertData() + ", useCause=" + this.getUseCause() + ")";
    }
}
