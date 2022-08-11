//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

@ApiModel("查询证照解析请求体")
public class CertRemarkQuery extends BaseHeadQuery implements Serializable {
    private CertRemarkData data;

    public CertRemarkQuery() {
    }

    public CertRemarkData getData() {
        return this.data;
    }

    public void setData(CertRemarkData data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CertRemarkQuery)) {
            return false;
        } else {
            CertRemarkQuery other = (CertRemarkQuery)o;
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
        return other instanceof CertRemarkQuery;
    }

    public int hashCode() {

        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "CertRemarkQuery(data=" + this.getData() + ")";
    }
}
