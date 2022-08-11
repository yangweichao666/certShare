//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class VerifyDataInfoRes {
    private String result;
    private String message;

    public VerifyDataInfoRes() {
    }

    public String getResult() {
        return this.result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VerifyDataInfoRes)) {
            return false;
        } else {
            VerifyDataInfoRes other = (VerifyDataInfoRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
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
        return other instanceof VerifyDataInfoRes;
    }

    public int hashCode() {

        int result = 1;
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        return "VerifyDataInfoRes(result=" + this.getResult() + ", message=" + this.getMessage() + ")";
    }
}
