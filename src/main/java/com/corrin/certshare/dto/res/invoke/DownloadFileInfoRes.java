//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class DownloadFileInfoRes {
    private String certificateType;
    private String issueDept;
    private String certificateNumber;
    private String issueDate;
    private String fileFormat = "ofd";
    private String fileUrl;

    public DownloadFileInfoRes() {
    }

    public String getCertificateType() {
        return this.certificateType;
    }

    public String getIssueDept() {
        return this.issueDept;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public void setIssueDept(String issueDept) {
        this.issueDept = issueDept;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownloadFileInfoRes)) {
            return false;
        } else {
            DownloadFileInfoRes other = (DownloadFileInfoRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$certificateType = this.getCertificateType();
                Object other$certificateType = other.getCertificateType();
                if (this$certificateType == null) {
                    if (other$certificateType != null) {
                        return false;
                    }
                } else if (!this$certificateType.equals(other$certificateType)) {
                    return false;
                }

                Object this$issueDept = this.getIssueDept();
                Object other$issueDept = other.getIssueDept();
                if (this$issueDept == null) {
                    if (other$issueDept != null) {
                        return false;
                    }
                } else if (!this$issueDept.equals(other$issueDept)) {
                    return false;
                }

                Object this$certificateNumber = this.getCertificateNumber();
                Object other$certificateNumber = other.getCertificateNumber();
                if (this$certificateNumber == null) {
                    if (other$certificateNumber != null) {
                        return false;
                    }
                } else if (!this$certificateNumber.equals(other$certificateNumber)) {
                    return false;
                }

                label62: {
                    Object this$issueDate = this.getIssueDate();
                    Object other$issueDate = other.getIssueDate();
                    if (this$issueDate == null) {
                        if (other$issueDate == null) {
                            break label62;
                        }
                    } else if (this$issueDate.equals(other$issueDate)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$fileFormat = this.getFileFormat();
                    Object other$fileFormat = other.getFileFormat();
                    if (this$fileFormat == null) {
                        if (other$fileFormat == null) {
                            break label55;
                        }
                    } else if (this$fileFormat.equals(other$fileFormat)) {
                        break label55;
                    }

                    return false;
                }

                Object this$fileUrl = this.getFileUrl();
                Object other$fileUrl = other.getFileUrl();
                if (this$fileUrl == null) {
                    if (other$fileUrl != null) {
                        return false;
                    }
                } else if (!this$fileUrl.equals(other$fileUrl)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DownloadFileInfoRes;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $certificateType = this.getCertificateType();
        int result = result * 59 + ($certificateType == null ? 43 : $certificateType.hashCode());
        Object $issueDept = this.getIssueDept();
        result = result * 59 + ($issueDept == null ? 43 : $issueDept.hashCode());
        Object $certificateNumber = this.getCertificateNumber();
        result = result * 59 + ($certificateNumber == null ? 43 : $certificateNumber.hashCode());
        Object $issueDate = this.getIssueDate();
        result = result * 59 + ($issueDate == null ? 43 : $issueDate.hashCode());
        Object $fileFormat = this.getFileFormat();
        result = result * 59 + ($fileFormat == null ? 43 : $fileFormat.hashCode());
        Object $fileUrl = this.getFileUrl();
        result = result * 59 + ($fileUrl == null ? 43 : $fileUrl.hashCode());
        return result;
    }

    public String toString() {
        return "DownloadFileInfoRes(certificateType=" + this.getCertificateType() + ", issueDept=" + this.getIssueDept() + ", certificateNumber=" + this.getCertificateNumber() + ", issueDate=" + this.getIssueDate() + ", fileFormat=" + this.getFileFormat() + ", fileUrl=" + this.getFileUrl() + ")";
    }
}
