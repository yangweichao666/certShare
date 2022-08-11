//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

import java.util.List;

public class QueryDataListRes {
    private Integer total;
    private List<QueryDataInfoRes> dataList;

    public QueryDataListRes() {
    }

    public Integer getTotal() {
        return this.total;
    }

    public List<QueryDataInfoRes> getDataList() {
        return this.dataList;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setDataList(List<QueryDataInfoRes> dataList) {
        this.dataList = dataList;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryDataListRes)) {
            return false;
        } else {
            QueryDataListRes other = (QueryDataListRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$total = this.getTotal();
                Object other$total = other.getTotal();
                if (this$total == null) {
                    if (other$total != null) {
                        return false;
                    }
                } else if (!this$total.equals(other$total)) {
                    return false;
                }

                Object this$dataList = this.getDataList();
                Object other$dataList = other.getDataList();
                if (this$dataList == null) {
                    if (other$dataList != null) {
                        return false;
                    }
                } else if (!this$dataList.equals(other$dataList)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryDataListRes;
    }

    public int hashCode() {
         
        int result = 1;
        Object $total = this.getTotal();
        result = result * 59 + ($total == null ? 43 : $total.hashCode());
        Object $dataList = this.getDataList();
        result = result * 59 + ($dataList == null ? 43 : $dataList.hashCode());
        return result;
    }

    public String toString() {
        return "QueryDataListRes(total=" + this.getTotal() + ", dataList=" + this.getDataList() + ")";
    }
}
