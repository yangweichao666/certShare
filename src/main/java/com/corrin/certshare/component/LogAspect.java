//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.component;

import com.corrin.certshare.annotation.LogsProvinceApi;
import com.corrin.certshare.dto.req.CertRemarkQuery;
import com.corrin.certshare.dto.req.DownLoadUrlQuery;
import com.corrin.certshare.dto.req.DownloadFileQuery;
import com.corrin.certshare.dto.req.QueryCertInfoByHolderCode;
import com.corrin.certshare.dto.req.QueryCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyFileQuery;
import com.corrin.certshare.entity.LogsProvinceApiEntity;
import com.corrin.certshare.service.ILogsProvinceApiService;
import com.linewell.dzzz.DateFormat;
import com.linewell.dzzz.DateTimeUtil;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private ILogsProvinceApiService iLogsProvinceApiService;

    public LogAspect() {
    }

    @Around("within(com.corrin.certshare.service..*) && @annotation(logsProvinceApi)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, LogsProvinceApi logsProvinceApi) throws Throwable {
        LogsProvinceApiEntity logsProvinceApiEntity = new LogsProvinceApiEntity();
        Object[] args = proceedingJoinPoint.getArgs();
        Object[] var5 = args;
        int var6 = args.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Object arg = var5[var7];
            if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest)arg;
                logsProvinceApiEntity.setRemoteScheme(request.getScheme());
                logsProvinceApiEntity.setRemoteIp(request.getRemoteHost());
                logsProvinceApiEntity.setRemotePort(String.valueOf(request.getRemotePort()));
            }

            if (arg instanceof QueryCertInfoByHolderCode) {
                QueryCertInfoByHolderCode queryCertInfoByHolderCode = (QueryCertInfoByHolderCode)arg;
                logsProvinceApiEntity.setAccessId(queryCertInfoByHolderCode.getAccessId());
                logsProvinceApiEntity.setRequstParams(queryCertInfoByHolderCode.toString());
                logsProvinceApiEntity.setUseCause(queryCertInfoByHolderCode.getData().getUseCause());
            }

            if (arg instanceof DownloadFileQuery) {
                DownloadFileQuery downloadFileQuery = (DownloadFileQuery)arg;
                logsProvinceApiEntity.setAccessId(downloadFileQuery.getAccessId());
                logsProvinceApiEntity.setRequstParams(downloadFileQuery.toString());
                logsProvinceApiEntity.setUseCause(downloadFileQuery.getData().getCertificateCopyCause());
            }

            if (arg instanceof DownLoadUrlQuery) {
                DownLoadUrlQuery downLoadUrlQuery = (DownLoadUrlQuery)arg;
                logsProvinceApiEntity.setAccessId(downLoadUrlQuery.getAccessId());
                logsProvinceApiEntity.setRequstParams(downLoadUrlQuery.toString());
                logsProvinceApiEntity.setUseCause(downLoadUrlQuery.getData().getUseCause());
            }

            if (arg instanceof QueryCertInfoQuery) {
                QueryCertInfoQuery queryCertInfoQuery = (QueryCertInfoQuery)arg;
                logsProvinceApiEntity.setAccessId(queryCertInfoQuery.getAccessId());
                logsProvinceApiEntity.setRequstParams(queryCertInfoQuery.toString());
                logsProvinceApiEntity.setUseCause(queryCertInfoQuery.getData().getUseCause());
            }

            if (arg instanceof VerifyCertInfoQuery) {
                VerifyCertInfoQuery verifyCertInfoQuery = (VerifyCertInfoQuery)arg;
                logsProvinceApiEntity.setAccessId(verifyCertInfoQuery.getAccessId());
                logsProvinceApiEntity.setRequstParams(verifyCertInfoQuery.toString());
                logsProvinceApiEntity.setUseCause(verifyCertInfoQuery.getData().getUseCause());
            }

            if (arg instanceof VerifyFileQuery) {
                VerifyFileQuery verifyFileQuery = (VerifyFileQuery)arg;
                logsProvinceApiEntity.setAccessId(verifyFileQuery.getAccessId());
                logsProvinceApiEntity.setRequstParams(verifyFileQuery.toString());
                logsProvinceApiEntity.setUseCause(verifyFileQuery.getData().getUseCause());
            }

            if (arg instanceof String) {
                logsProvinceApiEntity.setAccessId((String)null);
                logsProvinceApiEntity.setRequstParams(((String)arg).toString());
                logsProvinceApiEntity.setUseCause((String)null);
                logsProvinceApiEntity.setResult("0");
                logsProvinceApiEntity.setReturnContent(((String)arg).toString());
            }

            if (arg instanceof CertRemarkQuery) {
                CertRemarkQuery certRemarkQuery = (CertRemarkQuery)arg;
                logsProvinceApiEntity.setAccessId(certRemarkQuery.getAccessId());
                logsProvinceApiEntity.setRequstParams(certRemarkQuery.toString());
                logsProvinceApiEntity.setUseCause((String)null);
            }
        }

        Object ret = proceedingJoinPoint.proceed();
        logsProvinceApiEntity.setApiName(logsProvinceApi.apiName());
        logsProvinceApiEntity.setApiDescription(logsProvinceApi.apiDescription());
        logsProvinceApiEntity.setRequestTime(DateTimeUtil.format(new Date(), DateFormat.yyyy_MM_dd_HH_mm_ss));
        if (ret != null) {
            logsProvinceApiEntity.setReturnContent(ret.toString());
            if (ret.toString().contains("status=0, message=接口调用成功")) {
                logsProvinceApiEntity.setResult("0");
            } else {
                logsProvinceApiEntity.setResult("-1");
            }
        }

        this.iLogsProvinceApiService.save(logsProvinceApiEntity);
        return ret;
    }
}
