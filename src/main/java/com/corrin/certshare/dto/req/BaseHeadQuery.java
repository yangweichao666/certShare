//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.req;

import io.swagger.annotations.ApiModelProperty;

public class BaseHeadQuery {
    private RequestHead head;

    @ApiModelProperty(
        hidden = true
    )
    public String getAccessId() {
        RequestHead head = this.getHead();
        return head.getAccessId();
    }

    @ApiModelProperty(
        hidden = true
    )
    public String getAccessToken() {
        RequestHead head = this.getHead();
        return head.getAccessToken();
    }

    public BaseHeadQuery() {
    }

    public RequestHead getHead() {
        return this.head;
    }

    public void setHead(RequestHead head) {
        this.head = head;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseHeadQuery)) {
            return false;
        } else {
            BaseHeadQuery other = (BaseHeadQuery)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$head = this.getHead();
                Object other$head = other.getHead();
                if (this$head == null) {
                    if (other$head != null) {
                        return false;
                    }
                } else if (!this$head.equals(other$head)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseHeadQuery;
    }

    public int hashCode() {

        int result = 1;
        Object $head = this.getHead();
        result = result * 59 + ($head == null ? 43 : $head.hashCode());
        return result;
    }

    public String toString() {
        return "BaseHeadQuery(head=" + this.getHead() + ")";
    }
}
