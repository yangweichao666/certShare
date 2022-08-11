//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res;

public class ResCertDataData {
    private String certIdentifier;
    private String certificateName;

    public ResCertDataData() {
    }

    public String getCertIdentifier() {
        return this.certIdentifier;
    }

    public String getCertificateName() {
        return this.certificateName;
    }

    public void setCertIdentifier(String certIdentifier) {
        this.certIdentifier = certIdentifier;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResCertDataData)) {
            return false;
        } else {
            ResCertDataData other = (ResCertDataData)o;
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

                Object this$certificateName = this.getCertificateName();
                Object other$certificateName = other.getCertificateName();
                if (this$certificateName == null) {
                    if (other$certificateName != null) {
                        return false;
                    }
                } else if (!this$certificateName.equals(other$certificateName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResCertDataData;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $certIdentifier = this.getCertIdentifier();
        result = result * 59 + ($certIdentifier == null ? 43 : $certIdentifier.hashCode());
        Object $certificateName = this.getCertificateName();
        result = result * 59 + ($certificateName == null ? 43 : $certificateName.hashCode());
        return result;
    }

    public String toString() {
        return "ResCertDataData(certIdentifier=" + this.getCertIdentifier() + ", certificateName=" + this.getCertificateName() + ")";
    }
}
