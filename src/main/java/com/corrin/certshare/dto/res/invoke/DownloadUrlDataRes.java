//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.dto.res.invoke;

public class DownloadUrlDataRes {
    private String contentType;
    private String certIdentifier;
    private Object content;

    public DownloadUrlDataRes() {
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getCertIdentifier() {
        return this.certIdentifier;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setCertIdentifier(String certIdentifier) {
        this.certIdentifier = certIdentifier;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DownloadUrlDataRes)) {
            return false;
        } else {
            DownloadUrlDataRes other = (DownloadUrlDataRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$contentType = this.getContentType();
                    Object other$contentType = other.getContentType();
                    if (this$contentType == null) {
                        if (other$contentType == null) {
                            break label47;
                        }
                    } else if (this$contentType.equals(other$contentType)) {
                        break label47;
                    }

                    return false;
                }

                Object this$certIdentifier = this.getCertIdentifier();
                Object other$certIdentifier = other.getCertIdentifier();
                if (this$certIdentifier == null) {
                    if (other$certIdentifier != null) {
                        return false;
                    }
                } else if (!this$certIdentifier.equals(other$certIdentifier)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DownloadUrlDataRes;
    }

    public int hashCode() {
         
        int result = 1;
        Object $contentType = this.getContentType();
        result = result * 59 + ($contentType == null ? 43 : $contentType.hashCode());
        Object $certIdentifier = this.getCertIdentifier();
        result = result * 59 + ($certIdentifier == null ? 43 : $certIdentifier.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "DownloadUrlDataRes(contentType=" + this.getContentType() + ", certIdentifier=" + this.getCertIdentifier() + ", content=" + this.getContent() + ")";
    }
}
