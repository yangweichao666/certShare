//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service;

import com.corrin.certshare.dto.req.CertRemarkQuery;
import com.corrin.certshare.dto.req.DownLoadUrlQuery;
import com.corrin.certshare.dto.req.DownloadFileQuery;
import com.corrin.certshare.dto.req.QueryCertInfoByHolderCode;
import com.corrin.certshare.dto.req.QueryCertInfoByQrCodeQuery;
import com.corrin.certshare.dto.req.QueryCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyFileQuery;
import com.corrin.certshare.dto.res.ResponseHead;
import com.corrin.certshare.exception.BaseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CertShareApiService {
    Object downloadUrlsByHolderCode(HttpServletRequest var1, QueryCertInfoByHolderCode var2);

    Object downloadFile(HttpServletRequest var1, DownloadFileQuery var2);

    Object downloadUrl(HttpServletRequest var1, DownLoadUrlQuery var2);

    Object queryCertInfo(HttpServletRequest var1, QueryCertInfoQuery var2);

    Object verifyCertInfo(HttpServletRequest var1, VerifyCertInfoQuery var2);

    Object verifyFile(HttpServletRequest var1, VerifyFileQuery var2);

    void downloadCertFile(HttpServletRequest var1, HttpServletResponse var2, String var3) throws BaseException;

    Object getDateByQRcode(HttpServletRequest var1, QueryCertInfoByQrCodeQuery var2);

    Object checkCertInfoByQRcode(HttpServletRequest var1, QueryCertInfoQuery var2);

    Object getDataByHolder(HttpServletRequest var1, QueryCertInfoByHolderCode var2) throws Exception;

    Object downloadPdfFile(HttpServletRequest var1, DownloadFileQuery var2);

    boolean verifyUserToken(String var1, String var2);

    boolean verifyUserCertPermission(String var1, String var2);

    ResponseHead verifyCertState(Integer var1);

    Object getCertRemarkInfo(HttpServletRequest var1, CertRemarkQuery var2);
}
