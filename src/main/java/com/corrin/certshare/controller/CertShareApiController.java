//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.controller;

import com.corrin.certshare.dto.req.CertRemarkQuery;
import com.corrin.certshare.dto.req.DownLoadUrlQuery;
import com.corrin.certshare.dto.req.DownloadFileQuery;
import com.corrin.certshare.dto.req.QueryCertInfoByHolderCode;
import com.corrin.certshare.dto.req.QueryCertInfoByQrCodeQuery;
import com.corrin.certshare.dto.req.QueryCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyFileQuery;
import com.corrin.certshare.dto.res.ResponseHead;
import com.corrin.certshare.dto.res.invoke.QueryDataRes;
import com.corrin.certshare.exception.BaseException;
import com.corrin.certshare.service.CertShareApiService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(
    description = "证照共享服务"
)
public class CertShareApiController {
    private static final Logger log = LoggerFactory.getLogger(CertShareApiController.class);
    @Autowired
    CertShareApiService certShareApiService;

    public CertShareApiController() {
    }

    @ApiOperation(
        value = "证照文件base64下载",
        notes = "证照文件以base64编码形式进行传输下载"
    )
    @RequestMapping(
        value = {"/downloadFile"},
        method = {RequestMethod.POST}
    )
    Object downloadFile(HttpServletRequest request, @RequestBody DownloadFileQuery data) {
        try {
            log.info("证照文件base64下载-开始：DownloadFileQuery={}", (new Gson()).toJson(data));
            Object downloadObject = this.certShareApiService.downloadFile(request, data);
            log.info("证照文件base64下载-结束：DownloadFileQuery={}", (new Gson()).toJson(data));
            return downloadObject;
        } catch (Exception var4) {
            log.error("证照文件base64下载异常，{}", var4);
            return new QueryDataRes(new ResponseHead(99, "其他异常"));
        }
    }

    @ApiOperation(
        value = "证照标识获取下载地址",
        notes = "证照标识获取下载地址"
    )
    @RequestMapping(
        value = {"/downloadUrl"},
        method = {RequestMethod.POST}
    )
    Object downloadUrl(HttpServletRequest request, @RequestBody DownLoadUrlQuery query) {
        try {
            log.info("证照标识获取下载地址-开始：query={}", (new Gson()).toJson(query));
            Object downloadUrl = this.certShareApiService.downloadUrl(request, query);
            log.info("证照标识获取下载地址-结束：query={},result={}", (new Gson()).toJson(query), (new Gson()).toJson(downloadUrl));
            return downloadUrl;
        } catch (Exception var4) {
            log.error("证照标识获取下载地址异常，{}", var4);
            return new QueryDataRes(new ResponseHead(99, "其他异常"));
        }
    }

    @ApiOperation(
        value = "验证证照文件",
        notes = "验证证照文件"
    )
    @RequestMapping(
        value = {"/verifyFile"},
        method = {RequestMethod.POST}
    )
    Object verifyFile(HttpServletRequest request, @RequestBody VerifyFileQuery verifyFileQuery) {
        return this.certShareApiService.verifyFile(request, verifyFileQuery);
    }

    @ApiOperation(
        value = "证照标识获取证照信息",
        notes = "根据电子证照标识获取该证照的信息内容"
    )
    @RequestMapping(
        value = {"/queryCertInfo"},
        method = {RequestMethod.POST}
    )
    Object queryCertInfo(HttpServletRequest request, @RequestBody QueryCertInfoQuery queryCertInfoQuery) {
        return this.certShareApiService.queryCertInfo(request, queryCertInfoQuery);
    }

    @ApiOperation(
        value = "验证证照信息",
        notes = "验证证照信息"
    )
    @RequestMapping(
        value = {"/verifyCertInfo"},
        method = {RequestMethod.POST}
    )
    Object verifyCertInfo(HttpServletRequest request, @RequestBody VerifyCertInfoQuery verifyCertInfoQuery) {
        return this.certShareApiService.verifyCertInfo(request, verifyCertInfoQuery);
    }

    @ApiOperation(
        value = "根据二维码信息获取证照数据,给业务部门使用",
        notes = "【获取】基于电子证照唯一标识信息获取服务"
    )
    @RequestMapping(
        value = {"/queryCertInfoByQRcode"},
        method = {RequestMethod.POST}
    )
    Object queryCertInfoByQRcode(HttpServletRequest request, @RequestBody QueryCertInfoByQrCodeQuery queryCertInfoByQrCodeQuery) {
        try {
            log.info("二维码获取证照信息-开始：queryCertInfoQuery={}", (new Gson()).toJson(queryCertInfoByQrCodeQuery));
            Object dateByQRcode = this.certShareApiService.getDateByQRcode(request, queryCertInfoByQrCodeQuery);
            log.info("二维码获取证照信息-结束：qrcode={},result={}", queryCertInfoByQrCodeQuery.getData().getQrcode(), (new Gson()).toJson(dateByQRcode));
            return dateByQRcode;
        } catch (Exception var4) {
            log.error("二维码获取证照信息异常，{}", var4);
            return new QueryDataRes(new ResponseHead(99, "其他异常"));
        }
    }

    @ApiOperation(
        value = "将证照数据提供给数据共享平台服务,基于持证主体代码信息获取服务",
        notes = "【获取】基于持证主体代码信息获取服务"
    )
    @RequestMapping(
        value = {"/queryCertInfoByHolderCode"},
        method = {RequestMethod.POST}
    )
    Object queryCertInfoByHolderCode(HttpServletRequest request, @RequestBody QueryCertInfoByHolderCode queryCertInfoByHolderCode) {
        try {
            log.info("持证主体代码获取证照信息-开始：queryCertInfoByHolderCode={}", (new Gson()).toJson(queryCertInfoByHolderCode));
            Object dataByHolder = this.certShareApiService.getDataByHolder(request, queryCertInfoByHolderCode);
            log.info("持证主体代码获取证照信息-结束：holderCode={},certTypeCode={},result={}", new Object[]{queryCertInfoByHolderCode.getData().getHolderCode(), queryCertInfoByHolderCode.getData().getCertTypeCode(), (new Gson()).toJson(dataByHolder)});
            return dataByHolder;
        } catch (Exception var4) {
            log.error("持证主体代码获取证照信息异常，{}", var4);
            return new QueryDataRes(new ResponseHead(99, "其他异常"));
        }
    }

    @ApiOperation(
        value = "将证照数据提供给数据共享平台服务,基于持证主体代码信息获取下载地址服务",
        notes = "【获取】基于持证主体代码信息获取下载地址服务"
    )
    @RequestMapping(
        value = {"/downloadUrlsByHolderCode"},
        method = {RequestMethod.POST}
    )
    Object downloadUrlsByHolderCode(HttpServletRequest request, @RequestBody QueryCertInfoByHolderCode queryCertInfoByHolderCode) {
        try {
            log.info("持证主体代码信息获取下载地址-开始：queryCertInfoByHolderCode={}", (new Gson()).toJson(queryCertInfoByHolderCode));
            Object dataByHolder = this.certShareApiService.downloadUrlsByHolderCode(request, queryCertInfoByHolderCode);
            log.info("持证主体代码信息获取下载地址-结束：holderCode={},certTypeCode={},result={}", new Object[]{queryCertInfoByHolderCode.getData().getHolderCode(), queryCertInfoByHolderCode.getData().getCertTypeCode(), (new Gson()).toJson(dataByHolder)});
            return dataByHolder;
        } catch (Exception var4) {
            log.error("持证主体代码信息获取下载地址异常，{}", var4);
            return new QueryDataRes(new ResponseHead(99, "其他异常"));
        }
    }

    @ApiOperation(
        value = "基于文件ID下载服务",
        notes = "【下载】基于文件ID下载服务"
    )
    @ApiImplicitParams({@ApiImplicitParam(
    paramType = "query",
    name = "id",
    value = "文件ID",
    required = true,
    dataType = "String"
)})
    @RequestMapping(
        value = {"/zzgxpt/download"},
        method = {RequestMethod.GET}
    )
    @ResponseBody
    Object getFileByFileId(HttpServletRequest request, HttpServletResponse response, String id) {
        try {
            this.certShareApiService.downloadCertFile(request, response, id);
            return null;
        } catch (BaseException var5) {
            return new QueryDataRes(new ResponseHead(var5.getCode(), var5.getMsg()));
        }
    }

    @ApiOperation(
        value = "基于证照类型代码获取证照照面的字段解析",
        notes = "获取证照照面字段解析"
    )
    @RequestMapping(
        value = {"/getCertRemarkInfo"},
        method = {RequestMethod.POST}
    )
    @ResponseBody
    Object getCertRemarkInfo(HttpServletRequest request, @RequestBody CertRemarkQuery certRemarkQuery) {
        try {
            Object certRemarkInfo = this.certShareApiService.getCertRemarkInfo(request, certRemarkQuery);
            return certRemarkInfo;
        } catch (BaseException var4) {
            log.error("获取证照照面字段解析地址异常，{}", var4);
            return new QueryDataRes(new ResponseHead(99, "其他异常"));
        }
    }
}
