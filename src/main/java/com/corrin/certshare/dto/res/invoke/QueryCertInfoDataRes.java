//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class QueryCertInfoDataRes {
    private Object certData;

    public QueryCertInfoDataRes() {
    }

    public Object getCertData() {
        return this.certData;
    }

    public void setCertData(Object certData) {
        this.certData = certData;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoDataRes)) {
            return false;
        } else {
            QueryCertInfoDataRes other = (QueryCertInfoDataRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$certData = this.getCertData();
                Object other$certData = other.getCertData();
                if (this$certData == null) {
                    if (other$certData != null) {
                        return false;
                    }
                } else if (!this$certData.equals(other$certData)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryCertInfoDataRes;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $certData = this.getCertData();
        int result = result * 59 + ($certData == null ? 43 : $certData.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoDataRes(certData=" + this.getCertData() + ")";
    }
}
