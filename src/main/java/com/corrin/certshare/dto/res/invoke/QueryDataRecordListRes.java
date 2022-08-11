//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

import java.util.List;

public class QueryDataRecordListRes {
    private String group;
    private List<QueryDataRecordDetailRes> datalist;

    public QueryDataRecordListRes() {
    }

    public String getGroup() {
        return this.group;
    }

    public List<QueryDataRecordDetailRes> getDatalist() {
        return this.datalist;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setDatalist(List<QueryDataRecordDetailRes> datalist) {
        this.datalist = datalist;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryDataRecordListRes)) {
            return false;
        } else {
            QueryDataRecordListRes other = (QueryDataRecordListRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$group = this.getGroup();
                Object other$group = other.getGroup();
                if (this$group == null) {
                    if (other$group != null) {
                        return false;
                    }
                } else if (!this$group.equals(other$group)) {
                    return false;
                }

                Object this$datalist = this.getDatalist();
                Object other$datalist = other.getDatalist();
                if (this$datalist == null) {
                    if (other$datalist != null) {
                        return false;
                    }
                } else if (!this$datalist.equals(other$datalist)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryDataRecordListRes;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $group = this.getGroup();
        int result = result * 59 + ($group == null ? 43 : $group.hashCode());
        Object $datalist = this.getDatalist();
        result = result * 59 + ($datalist == null ? 43 : $datalist.hashCode());
        return result;
    }

    public String toString() {
        return "QueryDataRecordListRes(group=" + this.getGroup() + ", datalist=" + this.getDatalist() + ")";
    }
}
