//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

import com.corrin.certshare.dto.res.ResponseHead;

public class VerifyDataRes {
    private ResponseHead head;
    private Object data;

    public VerifyDataRes() {
    }

    public ResponseHead getHead() {
        return this.head;
    }

    public Object getData() {
        return this.data;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VerifyDataRes)) {
            return false;
        } else {
            VerifyDataRes other = (VerifyDataRes)o;
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
        return other instanceof VerifyDataRes;
    }

    public int hashCode() {
         
        int result = 1;
        Object $head = this.getHead();
        result = result * 59 + ($head == null ? 43 : $head.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "VerifyDataRes(head=" + this.getHead() + ", data=" + this.getData() + ")";
    }
}
