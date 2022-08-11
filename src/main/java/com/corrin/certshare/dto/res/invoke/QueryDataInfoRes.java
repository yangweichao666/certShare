//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

import java.util.List;

public class QueryDataInfoRes {
    private String certificateType;
    private String certificateName;
    private String certificateHolder;
    private String certificateHolderCode;
    private String certificateHolderType;
    private String certificateNumber;
    private String issueDept;
    private String issueDeptCode;
    private String issueDate;
    private String certificateValidateStart;
    private String certificateValidateEnd;
    private String digitalSign;
    private List<QueryDataSurfaceInfoRes> surface;
    private List<QueryDataRecordListRes> detail;

    public QueryDataInfoRes() {
    }

    public String getCertificateType() {
        return this.certificateType;
    }

    public String getCertificateName() {
        return this.certificateName;
    }

    public String getCertificateHolder() {
        return this.certificateHolder;
    }

    public String getCertificateHolderCode() {
        return this.certificateHolderCode;
    }

    public String getCertificateHolderType() {
        return this.certificateHolderType;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public String getIssueDept() {
        return this.issueDept;
    }

    public String getIssueDeptCode() {
        return this.issueDeptCode;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public String getCertificateValidateStart() {
        return this.certificateValidateStart;
    }

    public String getCertificateValidateEnd() {
        return this.certificateValidateEnd;
    }

    public String getDigitalSign() {
        return this.digitalSign;
    }

    public List<QueryDataSurfaceInfoRes> getSurface() {
        return this.surface;
    }

    public List<QueryDataRecordListRes> getDetail() {
        return this.detail;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public void setCertificateHolder(String certificateHolder) {
        this.certificateHolder = certificateHolder;
    }

    public void setCertificateHolderCode(String certificateHolderCode) {
        this.certificateHolderCode = certificateHolderCode;
    }

    public void setCertificateHolderType(String certificateHolderType) {
        this.certificateHolderType = certificateHolderType;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public void setIssueDept(String issueDept) {
        this.issueDept = issueDept;
    }

    public void setIssueDeptCode(String issueDeptCode) {
        this.issueDeptCode = issueDeptCode;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setCertificateValidateStart(String certificateValidateStart) {
        this.certificateValidateStart = certificateValidateStart;
    }

    public void setCertificateValidateEnd(String certificateValidateEnd) {
        this.certificateValidateEnd = certificateValidateEnd;
    }

    public void setDigitalSign(String digitalSign) {
        this.digitalSign = digitalSign;
    }

    public void setSurface(List<QueryDataSurfaceInfoRes> surface) {
        this.surface = surface;
    }

    public void setDetail(List<QueryDataRecordListRes> detail) {
        this.detail = detail;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryDataInfoRes)) {
            return false;
        } else {
            QueryDataInfoRes other = (QueryDataInfoRes)o;
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

                Object this$certificateName = this.getCertificateName();
                Object other$certificateName = other.getCertificateName();
                if (this$certificateName == null) {
                    if (other$certificateName != null) {
                        return false;
                    }
                } else if (!this$certificateName.equals(other$certificateName)) {
                    return false;
                }

                Object this$certificateHolder = this.getCertificateHolder();
                Object other$certificateHolder = other.getCertificateHolder();
                if (this$certificateHolder == null) {
                    if (other$certificateHolder != null) {
                        return false;
                    }
                } else if (!this$certificateHolder.equals(other$certificateHolder)) {
                    return false;
                }

                label158: {
                    Object this$certificateHolderCode = this.getCertificateHolderCode();
                    Object other$certificateHolderCode = other.getCertificateHolderCode();
                    if (this$certificateHolderCode == null) {
                        if (other$certificateHolderCode == null) {
                            break label158;
                        }
                    } else if (this$certificateHolderCode.equals(other$certificateHolderCode)) {
                        break label158;
                    }

                    return false;
                }

                label151: {
                    Object this$certificateHolderType = this.getCertificateHolderType();
                    Object other$certificateHolderType = other.getCertificateHolderType();
                    if (this$certificateHolderType == null) {
                        if (other$certificateHolderType == null) {
                            break label151;
                        }
                    } else if (this$certificateHolderType.equals(other$certificateHolderType)) {
                        break label151;
                    }

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

                label137: {
                    Object this$issueDept = this.getIssueDept();
                    Object other$issueDept = other.getIssueDept();
                    if (this$issueDept == null) {
                        if (other$issueDept == null) {
                            break label137;
                        }
                    } else if (this$issueDept.equals(other$issueDept)) {
                        break label137;
                    }

                    return false;
                }

                label130: {
                    Object this$issueDeptCode = this.getIssueDeptCode();
                    Object other$issueDeptCode = other.getIssueDeptCode();
                    if (this$issueDeptCode == null) {
                        if (other$issueDeptCode == null) {
                            break label130;
                        }
                    } else if (this$issueDeptCode.equals(other$issueDeptCode)) {
                        break label130;
                    }

                    return false;
                }

                Object this$issueDate = this.getIssueDate();
                Object other$issueDate = other.getIssueDate();
                if (this$issueDate == null) {
                    if (other$issueDate != null) {
                        return false;
                    }
                } else if (!this$issueDate.equals(other$issueDate)) {
                    return false;
                }

                Object this$certificateValidateStart = this.getCertificateValidateStart();
                Object other$certificateValidateStart = other.getCertificateValidateStart();
                if (this$certificateValidateStart == null) {
                    if (other$certificateValidateStart != null) {
                        return false;
                    }
                } else if (!this$certificateValidateStart.equals(other$certificateValidateStart)) {
                    return false;
                }

                label109: {
                    Object this$certificateValidateEnd = this.getCertificateValidateEnd();
                    Object other$certificateValidateEnd = other.getCertificateValidateEnd();
                    if (this$certificateValidateEnd == null) {
                        if (other$certificateValidateEnd == null) {
                            break label109;
                        }
                    } else if (this$certificateValidateEnd.equals(other$certificateValidateEnd)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    Object this$digitalSign = this.getDigitalSign();
                    Object other$digitalSign = other.getDigitalSign();
                    if (this$digitalSign == null) {
                        if (other$digitalSign == null) {
                            break label102;
                        }
                    } else if (this$digitalSign.equals(other$digitalSign)) {
                        break label102;
                    }

                    return false;
                }

                Object this$surface = this.getSurface();
                Object other$surface = other.getSurface();
                if (this$surface == null) {
                    if (other$surface != null) {
                        return false;
                    }
                } else if (!this$surface.equals(other$surface)) {
                    return false;
                }

                Object this$detail = this.getDetail();
                Object other$detail = other.getDetail();
                if (this$detail == null) {
                    if (other$detail != null) {
                        return false;
                    }
                } else if (!this$detail.equals(other$detail)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryDataInfoRes;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $certificateType = this.getCertificateType();
        int result = result * 59 + ($certificateType == null ? 43 : $certificateType.hashCode());
        Object $certificateName = this.getCertificateName();
        result = result * 59 + ($certificateName == null ? 43 : $certificateName.hashCode());
        Object $certificateHolder = this.getCertificateHolder();
        result = result * 59 + ($certificateHolder == null ? 43 : $certificateHolder.hashCode());
        Object $certificateHolderCode = this.getCertificateHolderCode();
        result = result * 59 + ($certificateHolderCode == null ? 43 : $certificateHolderCode.hashCode());
        Object $certificateHolderType = this.getCertificateHolderType();
        result = result * 59 + ($certificateHolderType == null ? 43 : $certificateHolderType.hashCode());
        Object $certificateNumber = this.getCertificateNumber();
        result = result * 59 + ($certificateNumber == null ? 43 : $certificateNumber.hashCode());
        Object $issueDept = this.getIssueDept();
        result = result * 59 + ($issueDept == null ? 43 : $issueDept.hashCode());
        Object $issueDeptCode = this.getIssueDeptCode();
        result = result * 59 + ($issueDeptCode == null ? 43 : $issueDeptCode.hashCode());
        Object $issueDate = this.getIssueDate();
        result = result * 59 + ($issueDate == null ? 43 : $issueDate.hashCode());
        Object $certificateValidateStart = this.getCertificateValidateStart();
        result = result * 59 + ($certificateValidateStart == null ? 43 : $certificateValidateStart.hashCode());
        Object $certificateValidateEnd = this.getCertificateValidateEnd();
        result = result * 59 + ($certificateValidateEnd == null ? 43 : $certificateValidateEnd.hashCode());
        Object $digitalSign = this.getDigitalSign();
        result = result * 59 + ($digitalSign == null ? 43 : $digitalSign.hashCode());
        Object $surface = this.getSurface();
        result = result * 59 + ($surface == null ? 43 : $surface.hashCode());
        Object $detail = this.getDetail();
        result = result * 59 + ($detail == null ? 43 : $detail.hashCode());
        return result;
    }

    public String toString() {
        return "QueryDataInfoRes(certificateType=" + this.getCertificateType() + ", certificateName=" + this.getCertificateName() + ", certificateHolder=" + this.getCertificateHolder() + ", certificateHolderCode=" + this.getCertificateHolderCode() + ", certificateHolderType=" + this.getCertificateHolderType() + ", certificateNumber=" + this.getCertificateNumber() + ", issueDept=" + this.getIssueDept() + ", issueDeptCode=" + this.getIssueDeptCode() + ", issueDate=" + this.getIssueDate() + ", certificateValidateStart=" + this.getCertificateValidateStart() + ", certificateValidateEnd=" + this.getCertificateValidateEnd() + ", digitalSign=" + this.getDigitalSign() + ", surface=" + this.getSurface() + ", detail=" + this.getDetail() + ")";
    }
}
