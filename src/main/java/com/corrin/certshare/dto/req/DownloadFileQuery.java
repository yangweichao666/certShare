//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("证照下载文件请求体")
public class DownloadFileQuery extends BaseHeadQuery implements Serializable {
    private DownloadFileData data;

    @ApiModelProperty(
        hidden = true
    )
    public String getCertificateIdentifier() {
        DownloadFileData data = this.getData();
        return data.getCertificateIdentifier();
    }

    @ApiModelProperty(
        hidden = true
    )
    public String getCertificateCopyCause() {
        DownloadFileData data = this.getData();
        return data.getCertificateCopyCause();
    }

    @ApiModelProperty(
        hidden = true
    )
    public String getCertificateCopyExpiringTime() {
        DownloadFileData data = this.getData();
        return data.getCertificateCopyExpiringTime();
    }

    public DownloadFileQuery() {
    }

    public DownloadFileData getData() {
        return this.data;
    }

    public void setData(DownloadFileData data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownloadFileQuery)) {
            return false;
        } else {
            DownloadFileQuery other = (DownloadFileQuery)o;
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
        return other instanceof DownloadFileQuery;
    }

    public int hashCode() {

        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "DownloadFileQuery(data=" + this.getData() + ")";
    }
}
