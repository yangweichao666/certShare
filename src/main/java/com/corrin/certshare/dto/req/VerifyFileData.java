//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("验证证照文件数据体")
public class VerifyFileData {
    @ApiModelProperty(
        value = "证照类型代码",
        example = "危险化学品经营许可证",
        required = true,
        notes = "证照类型代码"
    )
    private String certTypeCode;
    @ApiModelProperty(
        value = "内容类型【固定】",
        example = "base64",
        required = true,
        notes = "内容类型【固定】"
    )
    private String contentType;
    @ApiModelProperty(
        value = "base64内容",
        example = "base64内容",
        required = true,
        notes = "base64内容"
    )
    private String content;
    @ApiModelProperty(
        value = "申请事由，不超过200字",
        example = "事由***",
        required = true,
        notes = "申请事由，不超过200字"
    )
    private String useCause;

    public VerifyFileData() {
    }

    public String getCertTypeCode() {
        return this.certTypeCode;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getContent() {
        return this.content;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public void setCertTypeCode(String certTypeCode) {
        this.certTypeCode = certTypeCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VerifyFileData)) {
            return false;
        } else {
            VerifyFileData other = (VerifyFileData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$certTypeCode = this.getCertTypeCode();
                    Object other$certTypeCode = other.getCertTypeCode();
                    if (this$certTypeCode == null) {
                        if (other$certTypeCode == null) {
                            break label59;
                        }
                    } else if (this$certTypeCode.equals(other$certTypeCode)) {
                        break label59;
                    }

                    return false;
                }

                Object this$contentType = this.getContentType();
                Object other$contentType = other.getContentType();
                if (this$contentType == null) {
                    if (other$contentType != null) {
                        return false;
                    }
                } else if (!this$contentType.equals(other$contentType)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
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
        return other instanceof VerifyFileData;
    }

    public int hashCode() {

        int result = 1;
        Object $certTypeCode = this.getCertTypeCode();
        result = result * 59 + ($certTypeCode == null ? 43 : $certTypeCode.hashCode());
        Object $contentType = this.getContentType();
        result = result * 59 + ($contentType == null ? 43 : $contentType.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        return result;
    }

    public String toString() {
        return "VerifyFileData(certTypeCode=" + this.getCertTypeCode() + ", contentType=" + this.getContentType() + ", content=" + this.getContent() + ", useCause=" + this.getUseCause() + ")";
    }
}
