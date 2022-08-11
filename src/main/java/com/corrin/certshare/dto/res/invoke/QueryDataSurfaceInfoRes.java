//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class QueryDataSurfaceInfoRes {
    private String name;
    private String value;
    private String valueType;
    private String columnName;

    public QueryDataSurfaceInfoRes() {
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String getValueType() {
        return this.valueType;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryDataSurfaceInfoRes)) {
            return false;
        } else {
            QueryDataSurfaceInfoRes other = (QueryDataSurfaceInfoRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label59;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label59;
                    }

                    return false;
                }

                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
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

                Object this$columnName = this.getColumnName();
                Object other$columnName = other.getColumnName();
                if (this$columnName == null) {
                    if (other$columnName != null) {
                        return false;
                    }
                } else if (!this$columnName.equals(other$columnName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryDataSurfaceInfoRes;
    }

    public int hashCode() {
         
        int result = 1;
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        Object $valueType = this.getValueType();
        result = result * 59 + ($valueType == null ? 43 : $valueType.hashCode());
        Object $columnName = this.getColumnName();
        result = result * 59 + ($columnName == null ? 43 : $columnName.hashCode());
        return result;
    }

    public String toString() {
        return "QueryDataSurfaceInfoRes(name=" + this.getName() + ", value=" + this.getValue() + ", valueType=" + this.getValueType() + ", columnName=" + this.getColumnName() + ")";
    }
}
