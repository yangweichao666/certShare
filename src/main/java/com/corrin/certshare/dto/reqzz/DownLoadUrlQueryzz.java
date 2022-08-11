//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.reqzz;

import com.corrin.certshare.dto.req.BaseHeadQuery;
import io.swagger.annotations.ApiModel;

@ApiModel("证照下载地址请求体")
public class DownLoadUrlQueryzz extends BaseHeadQuery {
    private DownLoadUrlDatazz data;

    public DownLoadUrlQueryzz() {
    }

    public DownLoadUrlDatazz getData() {
        return this.data;
    }

    public void setData(DownLoadUrlDatazz data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownLoadUrlQueryzz)) {
            return false;
        } else {
            DownLoadUrlQueryzz other = (DownLoadUrlQueryzz)o;
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
        return other instanceof DownLoadUrlQueryzz;
    }

    public int hashCode() {

        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "DownLoadUrlQueryzz(data=" + this.getData() + ")";
    }
}
