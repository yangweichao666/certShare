//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

@ApiModel("证照持有主体代码请求体")
public class QueryCertInfoByHolderCode extends BaseHeadQuery implements Serializable {
    private QueryCertInfoByHolderCodeData data;

    public QueryCertInfoByHolderCode() {
    }

    public QueryCertInfoByHolderCodeData getData() {
        return this.data;
    }

    public void setData(QueryCertInfoByHolderCodeData data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryCertInfoByHolderCode)) {
            return false;
        } else {
            QueryCertInfoByHolderCode other = (QueryCertInfoByHolderCode)o;
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
        return other instanceof QueryCertInfoByHolderCode;
    }

    public int hashCode() {

        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "QueryCertInfoByHolderCode(data=" + this.getData() + ")";
    }
}
