//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(
    collection = "LogsProvinceApi"
)
public class LogsProvinceApiEntity {
    @Field("accountId")
    private String accessId;
    @Field("remoteScheme")
    private String remoteScheme;
    @Field("remoteIp")
    private String remoteIp;
    @Field("remotePort")
    private String remotePort;
    @Field("apiName")
    private String apiName;
    @Field("apiDescription")
    private String apiDescription;
    @Field("requstParams")
    private String requstParams;
    @Field("returnContent")
    private String returnContent;
    @Field("requestTime")
    private String requestTime;
    @Field("useCause")
    private String useCause;
    @Field("result")
    private String result;

    public LogsProvinceApiEntity() {
    }

    public String getAccessId() {
        return this.accessId;
    }

    public String getRemoteScheme() {
        return this.remoteScheme;
    }

    public String getRemoteIp() {
        return this.remoteIp;
    }

    public String getRemotePort() {
        return this.remotePort;
    }

    public String getApiName() {
        return this.apiName;
    }

    public String getApiDescription() {
        return this.apiDescription;
    }

    public String getRequstParams() {
        return this.requstParams;
    }

    public String getReturnContent() {
        return this.returnContent;
    }

    public String getRequestTime() {
        return this.requestTime;
    }

    public String getUseCause() {
        return this.useCause;
    }

    public String getResult() {
        return this.result;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public void setRemoteScheme(String remoteScheme) {
        this.remoteScheme = remoteScheme;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public void setRemotePort(String remotePort) {
        this.remotePort = remotePort;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }

    public void setRequstParams(String requstParams) {
        this.requstParams = requstParams;
    }

    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public void setUseCause(String useCause) {
        this.useCause = useCause;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LogsProvinceApiEntity)) {
            return false;
        } else {
            LogsProvinceApiEntity other = (LogsProvinceApiEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label143: {
                    Object this$accessId = this.getAccessId();
                    Object other$accessId = other.getAccessId();
                    if (this$accessId == null) {
                        if (other$accessId == null) {
                            break label143;
                        }
                    } else if (this$accessId.equals(other$accessId)) {
                        break label143;
                    }

                    return false;
                }

                Object this$remoteScheme = this.getRemoteScheme();
                Object other$remoteScheme = other.getRemoteScheme();
                if (this$remoteScheme == null) {
                    if (other$remoteScheme != null) {
                        return false;
                    }
                } else if (!this$remoteScheme.equals(other$remoteScheme)) {
                    return false;
                }

                Object this$remoteIp = this.getRemoteIp();
                Object other$remoteIp = other.getRemoteIp();
                if (this$remoteIp == null) {
                    if (other$remoteIp != null) {
                        return false;
                    }
                } else if (!this$remoteIp.equals(other$remoteIp)) {
                    return false;
                }

                label122: {
                    Object this$remotePort = this.getRemotePort();
                    Object other$remotePort = other.getRemotePort();
                    if (this$remotePort == null) {
                        if (other$remotePort == null) {
                            break label122;
                        }
                    } else if (this$remotePort.equals(other$remotePort)) {
                        break label122;
                    }

                    return false;
                }

                label115: {
                    Object this$apiName = this.getApiName();
                    Object other$apiName = other.getApiName();
                    if (this$apiName == null) {
                        if (other$apiName == null) {
                            break label115;
                        }
                    } else if (this$apiName.equals(other$apiName)) {
                        break label115;
                    }

                    return false;
                }

                Object this$apiDescription = this.getApiDescription();
                Object other$apiDescription = other.getApiDescription();
                if (this$apiDescription == null) {
                    if (other$apiDescription != null) {
                        return false;
                    }
                } else if (!this$apiDescription.equals(other$apiDescription)) {
                    return false;
                }

                Object this$requstParams = this.getRequstParams();
                Object other$requstParams = other.getRequstParams();
                if (this$requstParams == null) {
                    if (other$requstParams != null) {
                        return false;
                    }
                } else if (!this$requstParams.equals(other$requstParams)) {
                    return false;
                }

                label94: {
                    Object this$returnContent = this.getReturnContent();
                    Object other$returnContent = other.getReturnContent();
                    if (this$returnContent == null) {
                        if (other$returnContent == null) {
                            break label94;
                        }
                    } else if (this$returnContent.equals(other$returnContent)) {
                        break label94;
                    }

                    return false;
                }

                label87: {
                    Object this$requestTime = this.getRequestTime();
                    Object other$requestTime = other.getRequestTime();
                    if (this$requestTime == null) {
                        if (other$requestTime == null) {
                            break label87;
                        }
                    } else if (this$requestTime.equals(other$requestTime)) {
                        break label87;
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

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof LogsProvinceApiEntity;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $accessId = this.getAccessId();
        result = result * 59 + ($accessId == null ? 43 : $accessId.hashCode());
        Object $remoteScheme = this.getRemoteScheme();
        result = result * 59 + ($remoteScheme == null ? 43 : $remoteScheme.hashCode());
        Object $remoteIp = this.getRemoteIp();
        result = result * 59 + ($remoteIp == null ? 43 : $remoteIp.hashCode());
        Object $remotePort = this.getRemotePort();
        result = result * 59 + ($remotePort == null ? 43 : $remotePort.hashCode());
        Object $apiName = this.getApiName();
        result = result * 59 + ($apiName == null ? 43 : $apiName.hashCode());
        Object $apiDescription = this.getApiDescription();
        result = result * 59 + ($apiDescription == null ? 43 : $apiDescription.hashCode());
        Object $requstParams = this.getRequstParams();
        result = result * 59 + ($requstParams == null ? 43 : $requstParams.hashCode());
        Object $returnContent = this.getReturnContent();
        result = result * 59 + ($returnContent == null ? 43 : $returnContent.hashCode());
        Object $requestTime = this.getRequestTime();
        result = result * 59 + ($requestTime == null ? 43 : $requestTime.hashCode());
        Object $useCause = this.getUseCause();
        result = result * 59 + ($useCause == null ? 43 : $useCause.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "LogsProvinceApiEntity(accessId=" + this.getAccessId() + ", remoteScheme=" + this.getRemoteScheme() + ", remoteIp=" + this.getRemoteIp() + ", remotePort=" + this.getRemotePort() + ", apiName=" + this.getApiName() + ", apiDescription=" + this.getApiDescription() + ", requstParams=" + this.getRequstParams() + ", returnContent=" + this.getReturnContent() + ", requestTime=" + this.getRequestTime() + ", useCause=" + this.getUseCause() + ", result=" + this.getResult() + ")";
    }
}
