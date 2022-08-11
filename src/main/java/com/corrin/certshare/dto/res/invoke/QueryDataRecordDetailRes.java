//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class QueryDataRecordDetailRes {
    private String name;
    private String valueType;
    private String value;
    private String columnName;
    private String orderNum;

    public QueryDataRecordDetailRes() {
    }

    public String getName() {
        return this.name;
    }

    public String getValueType() {
        return this.valueType;
    }

    public String getValue() {
        return this.value;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryDataRecordDetailRes)) {
            return false;
        } else {
            QueryDataRecordDetailRes other = (QueryDataRecordDetailRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label71;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label71;
                    }

                    return false;
                }

                Object this$valueType = this.getValueType();
                Object other$valueType = other.getValueType();
                if (this$valueType == null) {
                    if (other$valueType != null) {
                        return false;
                    }
                } else if (!this$valueType.equals(other$valueType)) {
                    return false;
                }

                label57: {
                    Object this$value = this.getValue();
                    Object other$value = other.getValue();
                    if (this$value == null) {
                        if (other$value == null) {
                            break label57;
                        }
                    } else if (this$value.equals(other$value)) {
                        break label57;
                    }

                    return false;
                }

                Object this$columnName = this.getColumnName();
                Object other$columnName = other.getColumnName();
                if (this$columnName == null) {
                    if (other$columnName != null) {
                        return false;
                    }
                } else if (!this$columnName.equals(other$columnName)) {
                    return false;
                }

                Object this$orderNum = this.getOrderNum();
                Object other$orderNum = other.getOrderNum();
                if (this$orderNum == null) {
                    if (other$orderNum == null) {
                        return true;
                    }
                } else if (this$orderNum.equals(other$orderNum)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryDataRecordDetailRes;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $name = this.getName();
        int result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $valueType = this.getValueType();
        result = result * 59 + ($valueType == null ? 43 : $valueType.hashCode());
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        Object $columnName = this.getColumnName();
        result = result * 59 + ($columnName == null ? 43 : $columnName.hashCode());
        Object $orderNum = this.getOrderNum();
        result = result * 59 + ($orderNum == null ? 43 : $orderNum.hashCode());
        return result;
    }

    public String toString() {
        return "QueryDataRecordDetailRes(name=" + this.getName() + ", valueType=" + this.getValueType() + ", value=" + this.getValue() + ", columnName=" + this.getColumnName() + ", orderNum=" + this.getOrderNum() + ")";
    }
}
