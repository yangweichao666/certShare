//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class QueryCertInfoDataResNew {
    private String cert_identifier;
    private Object certData;

    public QueryCertInfoDataResNew() {
    }

    public String getCert_identifier() {
        return this.cert_identifier;
    }

    public Object getCertData() {
        return this.certData;
    }

    public void setCert_identifier(String cert_identifier) {
        this.cert_identifier = cert_identifier;
    }

    public void setCertData(Object certData) {
        this.certData = certData;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoDataResNew)) {
            return false;
        } else {
            QueryCertInfoDataResNew other = (QueryCertInfoDataResNew)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$cert_identifier = this.getCert_identifier();
                Object other$cert_identifier = other.getCert_identifier();
                if (this$cert_identifier == null) {
                    if (other$cert_identifier != null) {
                        return false;
                    }
                } else if (!this$cert_identifier.equals(other$cert_identifier)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryCertInfoDataResNew;
    }

    public int hashCode() {
         
        int result = 1;
        Object $cert_identifier = this.getCert_identifier();
        result = result * 59 + ($cert_identifier == null ? 43 : $cert_identifier.hashCode());
        Object $certData = this.getCertData();
        result = result * 59 + ($certData == null ? 43 : $certData.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoDataResNew(cert_identifier=" + this.getCert_identifier() + ", certData=" + this.getCertData() + ")";
    }
}
