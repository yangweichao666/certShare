//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

@ApiModel("查询证照信息请求体")
public class QueryCertInfoQuery extends BaseHeadQuery implements Serializable {
    private QueryCertInfoData data;

    public QueryCertInfoQuery() {
    }

    public QueryCertInfoData getData() {
        return this.data;
    }

    public void setData(QueryCertInfoData data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoQuery)) {
            return false;
        } else {
            QueryCertInfoQuery other = (QueryCertInfoQuery)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryCertInfoQuery;
    }

    public int hashCode() {

        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoQuery(data=" + this.getData() + ")";
    }
}
