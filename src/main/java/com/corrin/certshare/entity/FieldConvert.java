//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("FieldConvert")
public class FieldConvert {
    private static final long serialVersionUID = 121112L;
    @Id
    @Field("_id")
    private ObjectId id;
    @Field("catalogId")
    private String catalogId;
    @Field("licenseTypeCode")
    private String licenseTypeCode;
    @Field("provinceField")
    private String provinceField;
    @Field("dzzzField")
    private String dzzzField;
    @Field("remark")
    private String remark;
    @Field("isAutoAdjust")
    private String isAutoAdjust = "0";

    public FieldConvert() {
    }

    public ObjectId getId() {
        return this.id;
    }

    public String getCatalogId() {
        return this.catalogId;
    }

    public String getLicenseTypeCode() {
        return this.licenseTypeCode;
    }

    public String getProvinceField() {
        return this.provinceField;
    }

    public String getDzzzField() {
        return this.dzzzField;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getIsAutoAdjust() {
        return this.isAutoAdjust;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public void setLicenseTypeCode(String licenseTypeCode) {
        this.licenseTypeCode = licenseTypeCode;
    }

    public void setProvinceField(String provinceField) {
        this.provinceField = provinceField;
    }

    public void setDzzzField(String dzzzField) {
        this.dzzzField = dzzzField;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setIsAutoAdjust(String isAutoAdjust) {
        this.isAutoAdjust = isAutoAdjust;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FieldConvert)) {
            return false;
        } else {
            FieldConvert other = (FieldConvert)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label95;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label95;
                    }

                    return false;
                }

                Object this$catalogId = this.getCatalogId();
                Object other$catalogId = other.getCatalogId();
                if (this$catalogId == null) {
                    if (other$catalogId != null) {
                        return false;
                    }
                } else if (!this$catalogId.equals(other$catalogId)) {
                    return false;
                }

                Object this$licenseTypeCode = this.getLicenseTypeCode();
                Object other$licenseTypeCode = other.getLicenseTypeCode();
                if (this$licenseTypeCode == null) {
                    if (other$licenseTypeCode != null) {
                        return false;
                    }
                } else if (!this$licenseTypeCode.equals(other$licenseTypeCode)) {
                    return false;
                }

                label74: {
                    Object this$provinceField = this.getProvinceField();
                    Object other$provinceField = other.getProvinceField();
                    if (this$provinceField == null) {
                        if (other$provinceField == null) {
                            break label74;
                        }
                    } else if (this$provinceField.equals(other$provinceField)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$dzzzField = this.getDzzzField();
                    Object other$dzzzField = other.getDzzzField();
                    if (this$dzzzField == null) {
                        if (other$dzzzField == null) {
                            break label67;
                        }
                    } else if (this$dzzzField.equals(other$dzzzField)) {
                        break label67;
                    }

                    return false;
                }

                Object this$remark = this.getRemark();
                Object other$remark = other.getRemark();
                if (this$remark == null) {
                    if (other$remark != null) {
                        return false;
                    }
                } else if (!this$remark.equals(other$remark)) {
                    return false;
                }

                Object this$isAutoAdjust = this.getIsAutoAdjust();
                Object other$isAutoAdjust = other.getIsAutoAdjust();
                if (this$isAutoAdjust == null) {
                    if (other$isAutoAdjust != null) {
                        return false;
                    }
                } else if (!this$isAutoAdjust.equals(other$isAutoAdjust)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof FieldConvert;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $catalogId = this.getCatalogId();
        result = result * 59 + ($catalogId == null ? 43 : $catalogId.hashCode());
        Object $licenseTypeCode = this.getLicenseTypeCode();
        result = result * 59 + ($licenseTypeCode == null ? 43 : $licenseTypeCode.hashCode());
        Object $provinceField = this.getProvinceField();
        result = result * 59 + ($provinceField == null ? 43 : $provinceField.hashCode());
        Object $dzzzField = this.getDzzzField();
        result = result * 59 + ($dzzzField == null ? 43 : $dzzzField.hashCode());
        Object $remark = this.getRemark();
        result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
        Object $isAutoAdjust = this.getIsAutoAdjust();
        result = result * 59 + ($isAutoAdjust == null ? 43 : $isAutoAdjust.hashCode());
        return result;
    }

    public String toString() {
        return "FieldConvert(id=" + this.getId() + ", catalogId=" + this.getCatalogId() + ", licenseTypeCode=" + this.getLicenseTypeCode() + ", provinceField=" + this.getProvinceField() + ", dzzzField=" + this.getDzzzField() + ", remark=" + this.getRemark() + ", isAutoAdjust=" + this.getIsAutoAdjust() + ")";
    }
}
