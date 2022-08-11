//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res;

public class ResponseHead {
    private Integer status = 0;
    private String message = "接口调用成功";

    public ResponseHead() {
    }

    public ResponseHead(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseHead)) {
            return false;
        } else {
            ResponseHead other = (ResponseHead)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseHead;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseHead(status=" + this.getStatus() + ", message=" + this.getMessage() + ")";
    }
}
