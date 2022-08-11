//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("请求头")
public class RequestHead {
    @ApiModelProperty(
        value = "访问标识",
        example = "shengdashujuju01",
        notes = "测试访问标识"
    )
    private String accessId;
    @ApiModelProperty(
        value = "访问密码",
        example = "Sdsjj022",
        notes = "测试访问密码"
    )
    private String accessToken;

    public RequestHead() {
    }

    public String getAccessId() {
        return this.accessId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RequestHead)) {
            return false;
        } else {
            RequestHead other = (RequestHead)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$accessId = this.getAccessId();
                Object other$accessId = other.getAccessId();
                if (this$accessId == null) {
                    if (other$accessId != null) {
                        return false;
                    }
                } else if (!this$accessId.equals(other$accessId)) {
                    return false;
                }

                Object this$accessToken = this.getAccessToken();
                Object other$accessToken = other.getAccessToken();
                if (this$accessToken == null) {
                    if (other$accessToken != null) {
                        return false;
                    }
                } else if (!this$accessToken.equals(other$accessToken)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof RequestHead;
    }

    public int hashCode() {

        int result = 1;
        Object $accessId = this.getAccessId();
        result = result * 59 + ($accessId == null ? 43 : $accessId.hashCode());
        Object $accessToken = this.getAccessToken();
        result = result * 59 + ($accessToken == null ? 43 : $accessToken.hashCode());
        return result;
    }

    public String toString() {
        return "RequestHead(accessId=" + this.getAccessId() + ", accessToken=" + this.getAccessToken() + ")";
    }
}
