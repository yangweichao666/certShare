//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.corrin.certshare.annotation.LogsProvinceApi;
import com.corrin.certshare.dto.req.CertRemarkData;
import com.corrin.certshare.dto.req.CertRemarkQuery;
import com.corrin.certshare.dto.req.DownLoadUrlData;
import com.corrin.certshare.dto.req.DownLoadUrlQuery;
import com.corrin.certshare.dto.req.DownloadFileData;
import com.corrin.certshare.dto.req.DownloadFileQuery;
import com.corrin.certshare.dto.req.QueryCertInfoByHolderCode;
import com.corrin.certshare.dto.req.QueryCertInfoByHolderCodeData;
import com.corrin.certshare.dto.req.QueryCertInfoByQrCodeData;
import com.corrin.certshare.dto.req.QueryCertInfoByQrCodeQuery;
import com.corrin.certshare.dto.req.QueryCertInfoData;
import com.corrin.certshare.dto.req.QueryCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyCertInfoData;
import com.corrin.certshare.dto.req.VerifyCertInfoQuery;
import com.corrin.certshare.dto.req.VerifyFileData;
import com.corrin.certshare.dto.req.VerifyFileQuery;
import com.corrin.certshare.dto.res.ResponseHead;
import com.corrin.certshare.dto.res.invoke.CertRemarkRes;
import com.corrin.certshare.dto.res.invoke.DownloadUrlDataRes;
import com.corrin.certshare.dto.res.invoke.DownloadUrlRes;
import com.corrin.certshare.dto.res.invoke.QueryCertInfoDataRes;
import com.corrin.certshare.dto.res.invoke.QueryCertInfoRes;
import com.corrin.certshare.dto.res.invoke.VerifyDataInfoRes;
import com.corrin.certshare.dto.res.invoke.VerifyDataRes;
import com.corrin.certshare.entity.FieldConvert;
import com.corrin.certshare.entity.TempDownloadUrlExpireTime;
import com.corrin.certshare.exception.BaseException;
import com.corrin.certshare.service.CertNameUserService;
import com.corrin.certshare.service.CertShareApiService;
import com.corrin.certshare.service.IFieldConvertService;
import com.corrin.certshare.service.TempDownloadUrlExpireTimeService;
import com.corrin.certshare.utils.Base64Util;
import com.corrin.certshare.utils.HttpUtils;
import com.corrin.certshare.utils.MD5Util;
import com.corrin.certshare.utils.OfdUtil;
import com.corrin.certshare.utils.OutputFormateUtil;
import com.corrin.certshare.utils.SM2Utils;
import com.corrin.certshare.utils.TimeCalculateUtil;
import com.corrin.certshare.utils.UrlPrefixUtil;
import com.corrin.certshare.utils.Util;
import com.corrin.certshare.utils.UuidUtil;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linewell.license.catalog.constant.CatalogState;
import com.linewell.license.catalog.pojo.Catalog;
import com.linewell.license.catalog.pojo.LicenseTemplate;
import com.linewell.license.catalog.service.CatalogService;
import com.linewell.license.catalog.service.LicenseTemplateService;
import com.linewell.license.gridfs.services.GridfsService;
import com.linewell.license.make.constant.LicenseState;
import com.linewell.license.make.pojo.License;
import com.linewell.license.make.pojo.NewAddCol;
import com.linewell.license.make.services.LicenseSearchService;
import com.linewell.license.make.services.LicenseService;
import com.linewell.license.oauth.pojo.OauthUser;
import com.linewell.license.oauth.services.OauthUserService;
import com.linewell.license.util.query.QueryEntity;
import com.linewell.license.util.query.QueryMapBuilder;
import com.linewell.license.util.query.QueryModel;
import com.linewell.license.util.query.QueryOperator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CertShareApiServiceImpl implements CertShareApiService {
    Logger logger = LoggerFactory.getLogger(CertShareApiServiceImpl.class);
    @Reference
    private LicenseService licenseService;
    @Reference
    private OauthUserService oauthUserService;
    @Reference
    private LicenseSearchService licenseSearchService;
    @Reference
    private GridfsService gridfsService;
    @Reference
    private CatalogService catalogService;
    @Reference
    private LicenseTemplateService licenseTemplateService;
    @Autowired
    private CertNameUserService certNameUserService;
    @Autowired
    private TempDownloadUrlExpireTimeService tempDownloadUrlExpireTimeService;
    @Autowired
    private IFieldConvertService iFieldConvertService;
    @Autowired
    private TimeCalculateUtil timeCalculateUtil;
    @Value("${ofdFilePath}")
    private String ofdFilePath;
    @Value("${srcFileNameExt}")
    private String srcFileNameExt;
    @Value("${destFileNameExt}")
    private String destFileNameExt;
    @Value("${deleteFileRightNow}")
    private String deleteFileRightNow;
    @Autowired
    private OfdUtil ofdUtil;
    @Value("${isEncryptPWD}")
    private String isEncryptPWD;
    HttpUtils httpInstance = HttpUtils.getInstance();
    @Value("${isPrefix}")
    private String isPrefix;
    @Value("${validCertState}")
    private String validCertState;
    @Value("${supportCertState}")
    private String supportCertState;
    @Value("${holderTypeCodes}")
    private String holderTypeCodes;
    @Value("${publicKey}")
    private String publickey;
    @Value("${localRequestKey}")
    private String localRequestKey;
    @Value("${localRequestValue}")
    private String localRequestValue;
    @Value("${pngMethod}")
    private String pngMethod;
    @Value("${certIdentifier}")
    private String certIdentifier;
    @Value("${certIdentifier2fileNumberUrl}")
    private String certIdentifier2fileNumberUrl;
    @Value("${fileNumber2CertIdentifierUrl}")
    private String fileNumber2CertIdentifierUrl;
    @Value("${byCatalogIds}")
    private String byCatalogIds;
    @Value("${byLicenseTypeCodes}")
    private String byLicenseTypeCodes;
    private Map mapCatalogIds = null;
    private Map mapLicenseTypeCodes = null;

    public CertShareApiServiceImpl() {
    }

    @LogsProvinceApi(
        apiName = "downloadUrlsByHolderCode",
        apiDescription = "基于持证主体代码信息获取下载地址服务"
    )
    public Object downloadUrlsByHolderCode(HttpServletRequest request, QueryCertInfoByHolderCode query) {
        QueryCertInfoByHolderCodeData data = query.getData();
        DownloadUrlRes downloadUrlRes = new DownloadUrlRes();
        ResponseHead responseHead = new ResponseHead();
        DownloadUrlDataRes downloadUrlDataRes = new DownloadUrlDataRes();
        if (!this.verifyUserToken(query.getAccessId(), query.getAccessToken())) {
            return this.returnParams(downloadUrlRes.getClass(), 11, "身份验证不通过", downloadUrlDataRes);
        } else if (!StringUtils.isEmpty(data.getHolderCode()) && !StringUtils.isEmpty(data.getHolderTypeCode()) && !StringUtils.isEmpty(data.getCertTypeCode()) && !StringUtils.isEmpty(data.getUseCause())) {
            if (!this.isHolderTypeCode(data.getHolderTypeCode())) {
                return this.returnParams(downloadUrlRes.getClass(), 103, "持证主体代码类型代码不符合规范", downloadUrlDataRes);
            } else {
                QueryMapBuilder builder = QueryMapBuilder.builder();
                QueryEntity queryEntity = new QueryEntity();
                queryEntity.setField("licence_Type_Code");
                queryEntity.setValue(data.getCertTypeCode());
                queryEntity.setType(QueryOperator.IS);
                builder.put(queryEntity);
                List<Catalog> catalogByCon = this.catalogService.findCatalogByCon(builder.build(), new Integer[]{1}, new String[]{"updatetime"}, QueryModel.AND);
                if (catalogByCon.size() > 0 && catalogByCon.get(0) != null) {
                    if (!this.verifyUserCertPermission(query.getAccessId(), ((Catalog)catalogByCon.get(0)).getLicence_Type_Code())) {
                        return this.returnParams(downloadUrlRes.getClass(), 100, "该用户无访问该证的权限！请先申请", downloadUrlDataRes);
                    } else {
                        QueryEntity queryEntity_holderCode;
                        if (StringUtils.isNotEmpty(data.getCertNo())) {
                            queryEntity_holderCode = new QueryEntity();
                            queryEntity_holderCode.setField("license_number");
                            queryEntity_holderCode.setValue(data.getCertNo());
                            queryEntity_holderCode.setType(QueryOperator.IS);
                            builder.put(queryEntity_holderCode);
                        }

                        queryEntity_holderCode = new QueryEntity();
                        queryEntity_holderCode.setField("holder_code");
                        queryEntity_holderCode.setValue(data.getHolderCode());
                        queryEntity_holderCode.setType(QueryOperator.IS);
                        builder.put(queryEntity_holderCode);
                        Integer[] stateInteger = this.stringArr2IntegerArr(this.validCertState);
                        QueryEntity queryEntity_state = new QueryEntity();
                        queryEntity_state.setField("state");
                        queryEntity_state.setValue(stateInteger);
                        queryEntity_state.setType(QueryOperator.IN);
                        builder.put(queryEntity_state);

                        for(int i = 0; i < stateInteger.length; ++i) {
                            responseHead = this.verifyCertState(stateInteger[i]);
                            if (!responseHead.getStatus().equals(0)) {
                                downloadUrlRes.setHead(responseHead);
                                downloadUrlRes.setData(downloadUrlDataRes);
                                return downloadUrlRes;
                            }
                        }

                        List<License> licenseList = this.licenseService.findLicenseByCon(builder.build(), QueryModel.AND);
                        if (licenseList != null) {
                            if (licenseList.size() > 0) {
                                List<DownloadUrlDataRes> mapList = new ArrayList();
                                String tempFileId;
                                if (licenseList.size() == 1) {
                                    License license = (License)licenseList.get(0);
                                    Date createTime = new Date();
                                    TempDownloadUrlExpireTime tempDownloadUrlExpireTime = new TempDownloadUrlExpireTime();
                                    tempDownloadUrlExpireTime.setAccountId(query.getAccessId());
                                    tempDownloadUrlExpireTime.setCertificateName(license.getLicenseName());
                                    tempDownloadUrlExpireTime.setTempFileId(UuidUtil.getUuid());
                                    if (this.validCertState.contains(String.valueOf(LicenseState.STATE_RELEASE))) {
                                        if (StringUtils.isNotEmpty(license.getOfdSignFileId())) {
                                            tempDownloadUrlExpireTime.setFileId(license.getOfdSignFileId());
                                        } else {
                                            tempDownloadUrlExpireTime.setFileId(license.getOfdFileId());
                                        }
                                    } else {
                                        tempDownloadUrlExpireTime.setFileId(license.getOfdFileId());
                                    }

                                    tempDownloadUrlExpireTime.setIsDownloaded(0);
                                    tempDownloadUrlExpireTime.setIsFileDeleted(0);
                                    tempDownloadUrlExpireTime.setCreateTime(createTime);
                                    tempDownloadUrlExpireTime.setExpiredTime(this.timeCalculateUtil.getExpiredTime(createTime));
                                    TempDownloadUrlExpireTime save = this.tempDownloadUrlExpireTimeService.save(tempDownloadUrlExpireTime);
                                    tempFileId  = save.getTempFileId();
                                    String contentUrl = (this.isPrefix.equals("1") ? UrlPrefixUtil.getUrlPrefix(request) : "") + request.getContextPath() + "/zzgxpt/download?id=" + tempFileId;
                                    downloadUrlDataRes.setContentType(request.getScheme());
                                    downloadUrlDataRes.setContent("http://172.20.8.2:28080" + contentUrl);
                                    if (this.certIdentifier.equals("1")) {
                                        downloadUrlDataRes.setCertIdentifier(license.getFileNumber());
                                    } else if (this.certIdentifier.equals("0")) {
                                        tempFileId = this.getDbDATA_CERIDENTIFIER_SDZZZ(license.getFileNumber());
                                        if (StringUtils.isNotEmpty(tempFileId)) {
                                            downloadUrlDataRes.setCertIdentifier(tempFileId);
                                        }
                                    }

                                    mapList.add(downloadUrlDataRes);
                                    this.generateWaterMarkerFile(tempDownloadUrlExpireTime.getFileId(), tempFileId, data.getUseCause());
                                    downloadUrlRes.setHead(responseHead);
                                    downloadUrlRes.setData(this.encrypt(request, mapList));
                                    return downloadUrlRes;
                                } else {
                                    for(int i = 0; i < licenseList.size(); ++i) {
                                        License license = (License)licenseList.get(i);
                                        DownloadUrlDataRes downloadUrlDataResTemp = new DownloadUrlDataRes();
                                        if (license != null) {
                                            Date createTime = new Date();
                                            TempDownloadUrlExpireTime tempDownloadUrlExpireTime = new TempDownloadUrlExpireTime();
                                            tempDownloadUrlExpireTime.setAccountId(query.getAccessId());
                                            tempDownloadUrlExpireTime.setCertificateName(license.getLicenseName());
                                            tempDownloadUrlExpireTime.setTempFileId(UuidUtil.getUuid());
                                            if (this.validCertState.contains(String.valueOf(LicenseState.STATE_RELEASE))) {
                                                if (StringUtils.isNotEmpty(license.getOfdSignFileId())) {
                                                    tempDownloadUrlExpireTime.setFileId(license.getOfdSignFileId());
                                                } else {
                                                    tempDownloadUrlExpireTime.setFileId(license.getOfdFileId());
                                                }
                                            } else {
                                                tempDownloadUrlExpireTime.setFileId(license.getOfdFileId());
                                            }

                                            tempDownloadUrlExpireTime.setIsDownloaded(0);
                                            tempDownloadUrlExpireTime.setIsFileDeleted(0);
                                            tempDownloadUrlExpireTime.setCreateTime(createTime);
                                            tempDownloadUrlExpireTime.setExpiredTime(this.timeCalculateUtil.getExpiredTime(createTime));
                                            TempDownloadUrlExpireTime save = this.tempDownloadUrlExpireTimeService.save(tempDownloadUrlExpireTime);
                                            tempFileId = save.getTempFileId();
                                            String contentUrl = (this.isPrefix.equals("1") ? UrlPrefixUtil.getUrlPrefix(request) : "") + request.getContextPath() + "/zzgxpt/download?id=" + tempFileId;
                                            downloadUrlDataResTemp.setContentType(request.getScheme());
                                            downloadUrlDataResTemp.setContent("http://172.20.8.2:28080" + contentUrl);
                                            if (this.certIdentifier.equals("1")) {
                                                downloadUrlDataResTemp.setCertIdentifier(license.getFileNumber());
                                            } else if (this.certIdentifier.equals("0")) {
                                                downloadUrlDataResTemp.setCertIdentifier("1.2.156.3005.2.11100000000013661B006.113700000045046442.209FA4E88F9E4C878F3E9BED2CE7EA49.001.M");
                                            }

                                            this.generateWaterMarkerFile(tempDownloadUrlExpireTime.getFileId(), tempFileId, data.getUseCause());
                                            mapList.add(downloadUrlDataResTemp);
                                        }
                                    }

                                    if (mapList != null && mapList.size() != 0) {
                                        downloadUrlRes.setHead(responseHead);
                                        downloadUrlRes.setData(this.encrypt(request, mapList));
                                        return downloadUrlRes;
                                    } else {
                                        return this.returnParams(downloadUrlRes.getClass(), 10, "未找到匹配的证照信息", downloadUrlDataRes);
                                    }
                                }
                            } else {
                                return this.returnParams(downloadUrlRes.getClass(), 10, "未找到匹配的证照信息", downloadUrlDataRes);
                            }
                        } else {
                            return this.returnParams(downloadUrlRes.getClass(), 10, "未找到匹配的证照信息", downloadUrlDataRes);
                        }
                    }
                } else {
                    return this.returnParams(downloadUrlRes.getClass(), 113, "证照类型代码有误", downloadUrlDataRes);
                }
            }
        } else {
            return this.returnParams(downloadUrlRes.getClass(), 12, "要求必填的输入参数值不为空", downloadUrlDataRes);
        }
    }

    @LogsProvinceApi(
        apiName = "downloadFile",
        apiDescription = "证照文件base64下载"
    )
    public Object downloadFile(HttpServletRequest request, DownloadFileQuery data) {
        DownloadFileData downloadFileData = data.getData();
        DownloadUrlRes downloadUrlRes = new DownloadUrlRes();
        new ResponseHead();
        DownloadUrlDataRes downloadUrlDataRes = new DownloadUrlDataRes();
        if (!this.verifyUserToken(data.getAccessId(), data.getAccessToken())) {
            return this.returnParams(downloadUrlRes.getClass(), 11, "身份验证不通过", downloadUrlDataRes);
        } else if (!StringUtils.isEmpty(downloadFileData.getCertificateIdentifier()) && !StringUtils.isEmpty(downloadFileData.getCertificateCopyCause())) {
            License license = null;
            String tempFileId;
            if (this.certIdentifier.equals("1")) {
                license = this.licenseService.getLicenseByFileNumber(downloadFileData.getCertificateIdentifier());
            } else if (this.certIdentifier.equals("0")) {
                tempFileId = this.getDbFileNumber(downloadFileData.getCertificateIdentifier());
                if (StringUtils.isNotEmpty(tempFileId)) {
                    license = this.licenseService.getLicenseByFileNumber(tempFileId);
                }
            }

            if (license != null) {
                ResponseHead responseHead = this.verifyCertState(license.getState());
                if (!responseHead.getStatus().equals(0)) {
                    downloadUrlRes.setHead(responseHead);
                    downloadUrlRes.setData(downloadUrlDataRes);
                    return downloadUrlRes;
                } else {
                    tempFileId = UuidUtil.getUuid();
                    String pngIds;
                    if (downloadFileData.getFileType() == null || downloadFileData.getFileType() != null && downloadFileData.getFileType().equals("") || downloadFileData.getFileType() != null && downloadFileData.getFileType().toLowerCase().equals("ofd")) {
                        pngIds = "";
                        if (this.validCertState.contains(String.valueOf(LicenseState.STATE_RELEASE))) {
                            if (StringUtils.isNotEmpty(license.getOfdSignFileId())) {
                                pngIds = license.getOfdSignFileId();
                            } else {
                                pngIds = license.getOfdFileId();
                            }
                        } else {
                            pngIds = license.getOfdFileId();
                        }

                        this.generateWaterMarkerFile(pngIds, tempFileId, downloadFileData.getCertificateCopyCause());
                        downloadUrlDataRes.setContent(this.getWaterMarkerFile(tempFileId));
                        this.ofdUtil.deleteFile(tempFileId);
                    } else {
                        if (downloadFileData.getFileType() == null || !downloadFileData.getFileType().toLowerCase().equals("png")) {
                            return this.returnParams(downloadUrlRes.getClass(), 102, "参数值错误(data.FileType值不正确)", downloadUrlDataRes);
                        }

                        pngIds = "";
                        if (this.pngMethod.equals("0")) {
                            if (this.validCertState.contains(String.valueOf(LicenseState.STATE_RELEASE))) {
                                pngIds = license.getImgSignFileId();
                                if (StringUtils.isEmpty(pngIds)) {
                                    pngIds = license.getImgUnsignFileId();
                                }
                            } else {
                                pngIds = license.getImgUnsignFileId();
                            }

                            downloadUrlDataRes.setContent(this.getDbImgBase64(pngIds.split(",")));
                        } else if (this.pngMethod.equals("1")) {
                            String fileId = "";
                            if (this.validCertState.contains(String.valueOf(LicenseState.STATE_RELEASE))) {
                                fileId = license.getOfdSignFileId();
                                if (StringUtils.isEmpty(fileId)) {
                                    fileId = license.getOfdFileId();
                                }
                            } else {
                                fileId = license.getOfdFileId();
                            }

                            this.generateOfdFile(fileId, tempFileId);
                            downloadUrlDataRes.setContent(this.ofdUtil.ofd2png(tempFileId));
                        }
                    }

                    downloadUrlDataRes.setContentType("base64");
                    if (this.certIdentifier.equals("1")) {
                        downloadUrlDataRes.setCertIdentifier(license.getFileNumber());
                    } else if (this.certIdentifier.equals("0")) {
                        downloadUrlDataRes.setCertIdentifier(downloadFileData.getCertificateIdentifier());
                    }

                    downloadUrlRes.setHead(responseHead);
                    downloadUrlRes.setData(downloadUrlDataRes);
                    return downloadUrlRes;
                }
            } else {
                return this.returnParams(downloadUrlRes.getClass(), 10, "未找到匹配的证照信息", downloadUrlDataRes);
            }
        } else {
            return this.returnParams(downloadUrlRes.getClass(), 12, "要求必填的输入参数值不为空", downloadUrlDataRes);
        }
    }

    @LogsProvinceApi(
        apiName = "downloadUrl",
        apiDescription = "证照标识获取下载地址"
    )
    public Object downloadUrl(HttpServletRequest request, DownLoadUrlQuery data) {
        DownLoadUrlData downLoadUrlData = data.getData();
        DownloadUrlRes downloadUrlRes = new DownloadUrlRes();
        ResponseHead responseHead = null;
        DownloadUrlDataRes downloadUrlDataRes = new DownloadUrlDataRes();
        System.out.println("downloadUrl==========");
        if (!this.verifyUserToken(data.getAccessId(), data.getAccessToken())) {
            return this.returnParams(downloadUrlRes.getClass(), 11, "身份验证不通过", downloadUrlDataRes);
        } else if (StringUtils.isEmpty(downLoadUrlData.getCertIdentifier())) {
            return this.returnParams(downloadUrlRes.getClass(), 12, "要求必填的输入参数值不为空", downloadUrlDataRes);
        } else {
            License license = null;
            if (this.certIdentifier.equals("1")) {
                license = this.licenseService.getLicenseByFileNumber(downLoadUrlData.getCertIdentifier());
            } else if (this.certIdentifier.equals("0")) {
                String fileNumber = this.getDbFileNumber(downLoadUrlData.getCertIdentifier());
                if (StringUtils.isNotEmpty(fileNumber)) {
                    license = this.licenseService.getLicenseByFileNumber(fileNumber);
                }
            }

            if (license != null) {
                responseHead = this.verifyCertState(license.getState());
                if (!responseHead.getStatus().equals(0)) {
                    downloadUrlRes.setHead(responseHead);
                    downloadUrlRes.setData(downloadUrlDataRes);
                    return downloadUrlRes;
                } else if (!this.verifyUserCertPermission(data.getAccessId(), license.getLicence_Type_Code())) {
                    return this.returnParams(downloadUrlRes.getClass(), 100, "该用户无访问该证的权限！请先申请", downloadUrlDataRes);
                } else {
                    Date createTime = new Date();
                    TempDownloadUrlExpireTime tempDownloadUrlExpireTime = new TempDownloadUrlExpireTime();
                    tempDownloadUrlExpireTime.setAccountId(data.getAccessId());
                    tempDownloadUrlExpireTime.setCertificateName(license.getLicenseName());
                    tempDownloadUrlExpireTime.setTempFileId(UuidUtil.getUuid());
                    if (this.validCertState.contains(String.valueOf(LicenseState.STATE_RELEASE))) {
                        if (StringUtils.isNotEmpty(license.getOfdSignFileId())) {
                            tempDownloadUrlExpireTime.setFileId(license.getOfdSignFileId());
                        } else {
                            tempDownloadUrlExpireTime.setFileId(license.getOfdFileId());
                        }
                    } else {
                        tempDownloadUrlExpireTime.setFileId(license.getOfdFileId());
                    }

                    tempDownloadUrlExpireTime.setIsDownloaded(0);
                    tempDownloadUrlExpireTime.setIsFileDeleted(0);
                    tempDownloadUrlExpireTime.setCreateTime(createTime);
                    tempDownloadUrlExpireTime.setExpiredTime(this.timeCalculateUtil.getExpiredTime(createTime));
                    TempDownloadUrlExpireTime save = this.tempDownloadUrlExpireTimeService.save(tempDownloadUrlExpireTime);
                    String tempFileId = save.getTempFileId();
                    System.out.println("**&&&^^^$$$$$==========");
                    String contentUrl = (this.isPrefix.equals("1") ? UrlPrefixUtil.getUrlPrefix(request) : "") + request.getContextPath() + "/zzgxpt/download?id=" + tempFileId;
                    downloadUrlDataRes.setContentType(request.getScheme());
                    downloadUrlDataRes.setContent("http://172.20.8.2:28080" + contentUrl);
                    if (this.certIdentifier.equals("1")) {
                        downloadUrlDataRes.setCertIdentifier(license.getFileNumber());
                    } else if (this.certIdentifier.equals("0")) {
                        downloadUrlDataRes.setCertIdentifier(downLoadUrlData.getCertIdentifier());
                    }

                    this.generateWaterMarkerFile(tempDownloadUrlExpireTime.getFileId(), tempFileId, downLoadUrlData.getUseCause());
                    downloadUrlRes.setHead(responseHead);
                    downloadUrlRes.setData(this.encrypt(request, downloadUrlDataRes));
                    return downloadUrlRes;
                }
            } else {
                return this.returnParams(downloadUrlRes.getClass(), 10, "未找到匹配的证照信息", downloadUrlDataRes);
            }
        }
    }

    @LogsProvinceApi(
        apiName = "queryCertInfo",
        apiDescription = "根据电子证照标识获取该证照的信息内容"
    )
    public Object queryCertInfo(HttpServletRequest request, QueryCertInfoQuery queryCertInfoQuery) {
        new ResponseHead();
        QueryCertInfoRes queryCertInfoRes = new QueryCertInfoRes();
        QueryCertInfoDataRes queryCertInfoDataRes = new QueryCertInfoDataRes();
        QueryCertInfoData queryCertInfoData = queryCertInfoQuery.getData();
        if (!this.verifyUserToken(queryCertInfoQuery.getAccessId(), queryCertInfoQuery.getAccessToken())) {
            return this.returnParams(queryCertInfoRes.getClass(), 11, "身份验证不通过", queryCertInfoDataRes);
        } else if (!StringUtils.isEmpty(queryCertInfoData.getCertIdentifier()) && !StringUtils.isEmpty(queryCertInfoData.getUseCause())) {
            License license = null;
            if (this.certIdentifier.equals("1")) {
                license = this.licenseService.getLicenseByFileNumber(queryCertInfoData.getCertIdentifier());
            } else if (this.certIdentifier.equals("0")) {
                String fileNumber = this.getDbFileNumber(queryCertInfoData.getCertIdentifier());
                if (StringUtils.isNotEmpty(fileNumber)) {
                    license = this.licenseService.getLicenseByFileNumber(fileNumber);
                }
            }

            if (license != null) {
                ResponseHead responseHead = this.verifyCertState(license.getState());
                if (!responseHead.getStatus().equals(0)) {
                    queryCertInfoRes.setHead(responseHead);
                    queryCertInfoRes.setData(queryCertInfoDataRes);
                    return queryCertInfoRes;
                } else if (!this.verifyUserCertPermission(queryCertInfoQuery.getAccessId(), license.getLicence_Type_Code())) {
                    return this.returnParams(queryCertInfoRes.getClass(), 100, "该用户无访问该证的权限！请先申请", queryCertInfoDataRes);
                } else {
                    Map<String, String> map = new HashMap();
                    if (this.updateFieldConvert(license)) {
                        map = this.dzzzMap2ProvinceMap(license, 1, (Map)null);
                    }

                    if (this.certIdentifier.equals("1")) {
                        ((Map)map).put("cert_identifier", license.getFileNumber());
                    } else if (this.certIdentifier.equals("0")) {
                        ((Map)map).put("cert_identifier", queryCertInfoData.getCertIdentifier());
                    }

                    queryCertInfoDataRes.setCertData(map);
                    queryCertInfoRes.setHead(responseHead);
                    queryCertInfoRes.setData(this.encrypt(request, queryCertInfoDataRes));
                    return queryCertInfoRes;
                }
            } else {
                return this.returnParams(queryCertInfoRes.getClass(), 10, "未找到匹配的证照信息", queryCertInfoDataRes);
            }
        } else {
            return this.returnParams(queryCertInfoRes.getClass(), 12, "要求必填的输入参数值不为空", queryCertInfoDataRes);
        }
    }

    @LogsProvinceApi(
        apiName = "verifyCertInfo",
        apiDescription = "验证证照信息"
    )
    public Object verifyCertInfo(HttpServletRequest request, VerifyCertInfoQuery verifyCertInfoQuery) {
        VerifyCertInfoData data = verifyCertInfoQuery.getData();
        VerifyDataRes verifyDataRes = new VerifyDataRes();
        ResponseHead responseHead = new ResponseHead();
        VerifyDataInfoRes verifyDataInfoRes = new VerifyDataInfoRes();
        if (!this.verifyUserToken(verifyCertInfoQuery.getAccessId(), verifyCertInfoQuery.getAccessToken())) {
            return this.returnParams(verifyDataRes.getClass(), 11, "身份验证不通过", verifyDataInfoRes);
        } else if (!StringUtils.isEmpty(data.getCertTypeCode()) && !data.getCertData().equals((Object)null) && !StringUtils.isEmpty(data.getUseCause())) {
            Map certData = (Map)data.getCertData();
            if (certData.size() > 0) {
                if (certData.get("holderCode") == null) {
                    return this.returnParams(verifyDataRes.getClass(), 110, "验证信息中holderCode【持证主体代码】不能为空", verifyDataInfoRes);
                }

                if (certData.get("holder") == null) {
                    return this.returnParams(verifyDataRes.getClass(), 111, "验证信息中holder【持证主体】不能为空", verifyDataInfoRes);
                }

                if (certData.get("certNo") == null) {
                    return this.returnParams(verifyDataRes.getClass(), 109, "验证信息中certNo【证照编码】不能为空", verifyDataInfoRes);
                }

                QueryMapBuilder builder = QueryMapBuilder.builder();
                QueryEntity queryEntity = new QueryEntity();
                queryEntity.setField("licence_Type_Code");
                queryEntity.setValue(data.getCertTypeCode());
                queryEntity.setType(QueryOperator.IS);
                builder.put(queryEntity);
                Iterator entries = certData.entrySet().iterator();

                while(entries.hasNext()) {
                    Entry<String, Object> entry = (Entry)entries.next();
                    String key = (String)entry.getKey();
                    Object value = entry.getValue();
                    if (StringUtils.isNotEmpty(key) && value != null) {
                        QueryEntity queryEntity_holderCode;
                        if ("certNo".equals(key)) {
                            queryEntity_holderCode = new QueryEntity();
                            queryEntity_holderCode.setField("license_number");
                            queryEntity_holderCode.setValue(value.toString());
                            queryEntity_holderCode.setType(QueryOperator.IS);
                            builder.put(queryEntity_holderCode);
                        }

                        if ("holder".equals(key)) {
                            queryEntity_holderCode = new QueryEntity();
                            queryEntity_holderCode.setField("holder");
                            queryEntity_holderCode.setValue(value.toString());
                            queryEntity_holderCode.setType(QueryOperator.IS);
                            builder.put(queryEntity_holderCode);
                        } else if ("holderCode".equals(key)) {
                            queryEntity_holderCode = new QueryEntity();
                            queryEntity_holderCode.setField("holder_code");
                            queryEntity_holderCode.setValue(value.toString());
                            queryEntity_holderCode.setType(QueryOperator.IS);
                            builder.put(queryEntity_holderCode);
                        }
                    }
                }

                QueryEntity queryEntity_state = new QueryEntity();
                queryEntity_state.setField("state");
                queryEntity_state.setValue(this.stringArr2IntegerArr(this.validCertState));
                queryEntity_state.setType(QueryOperator.IN);
                builder.put(queryEntity_state);
                List<License> list = this.licenseService.findLicenseByCon(builder.build(), QueryModel.AND);
                if (list != null && list.size() > 0) {
                    if (list.size() == 1) {
                        License license = (License)list.get(0);
                        if (!this.verifyUserCertPermission(verifyCertInfoQuery.getAccessId(), license.getLicence_Type_Code())) {
                            return this.returnParams(verifyDataRes.getClass(), 100, "该用户无访问该证的权限！请先申请", verifyDataInfoRes);
                        }

                        int state = license.getState();
                        responseHead = this.verifyCertState(state);
                        if (responseHead.getStatus().equals(0)) {
                            verifyDataRes.setHead(responseHead);
                            if (this.validCertState.contains(String.valueOf(state))) {
                                List<NewAddCol> newAddColList = license.getNewAddCol();
                                if (this.compareMapInfo(license, certData)) {
                                    verifyDataInfoRes.setResult("0");
                                    verifyDataInfoRes.setMessage("信息正确且有效");
                                } else {
                                    verifyDataInfoRes.setResult("7");
                                    verifyDataInfoRes.setMessage("部分信息有误或不完整");
                                }
                            } else if (LicenseState.NOT_Active == state) {
                                verifyDataInfoRes.setResult("1");
                                verifyDataInfoRes.setMessage("信息正确且未激活");
                            } else if (LicenseState.STATE_FREEZE == state) {
                                verifyDataInfoRes.setResult("2");
                                verifyDataInfoRes.setMessage("信息正确且证照暂时失效");
                            } else if (LicenseState.STATE_CANCEL == state || LicenseState.STATE_REVOKE == state || LicenseState.STATE_OVERDUE == state || LicenseState.STATE_CHANGE == state || LicenseState.STATE_ALRER == state || LicenseState.STATE_YEAR == state || LicenseState.STATE_YEARCANCEL == state) {
                                verifyDataInfoRes.setResult("3");
                                verifyDataInfoRes.setMessage("信息正确且证照已失效");
                            }
                        }
                    } else {
                        verifyDataInfoRes.setResult("4");
                        verifyDataInfoRes.setMessage("信息不全无法验证");
                    }
                } else {
                    verifyDataInfoRes.setResult("5");
                    verifyDataInfoRes.setMessage("查无此信息");
                }
            } else {
                verifyDataInfoRes.setResult("6");
                verifyDataInfoRes.setMessage("请填写certData中参数");
            }

            verifyDataRes.setHead(responseHead);
            verifyDataRes.setData(this.encrypt(request, verifyDataInfoRes));
            return verifyDataRes;
        } else {
            return this.returnParams(verifyDataRes.getClass(), 12, "要求必填的输入参数值不为空", verifyDataInfoRes);
        }
    }

    @LogsProvinceApi(
        apiName = "verifyFile",
        apiDescription = "验证证照文件"
    )
    public Object verifyFile(HttpServletRequest request, VerifyFileQuery verifyFileQuery) {
        VerifyFileData data = verifyFileQuery.getData();
        VerifyDataRes verifyDataRes = new VerifyDataRes();
        new ResponseHead();
        VerifyDataInfoRes verifyDataInfoRes = new VerifyDataInfoRes();
        if (!this.verifyUserToken(verifyFileQuery.getAccessId(), verifyFileQuery.getAccessToken())) {
            return this.returnParams(verifyDataRes.getClass(), 11, "身份验证不通过", verifyDataInfoRes);
        } else if (!StringUtils.isEmpty(data.getCertTypeCode()) && !StringUtils.isEmpty(data.getContent()) && !StringUtils.isEmpty(data.getContentType()) && !StringUtils.isEmpty(data.getUseCause())) {
            return !data.getContentType().equals("base64") ? this.returnParams(verifyDataRes.getClass(), 102, "data.contentType固定为：base64", verifyDataInfoRes) : this.returnParams(verifyDataRes.getClass(), 2, "证照源未提供此服务接口", verifyDataInfoRes);
        } else {
            return this.returnParams(verifyDataRes.getClass(), 12, "要求必填的输入参数值不为空", verifyDataInfoRes);
        }
    }

    @LogsProvinceApi(
        apiName = "downloadCertFile",
        apiDescription = "证照文件下载"
    )
    public void downloadCertFile(HttpServletRequest request, HttpServletResponse response, String id) throws BaseException {
        try {
            ServletOutputStream outputStream = response.getOutputStream();

            try {
                if (StringUtils.isEmpty(id)) {
                    outputStream.write("id参数不能为空".getBytes("UTF-8"));
                    outputStream.flush();
                }

                if (id.length() != 32) {
                    outputStream.write("id参数的长度不对".getBytes("UTF-8"));
                    outputStream.flush();
                }

                TempDownloadUrlExpireTime tempDownloadUrlExpireTime = this.tempDownloadUrlExpireTimeService.findOneByTempFileId(id);
                if (tempDownloadUrlExpireTime != null) {
                    if (tempDownloadUrlExpireTime.getIsDownloaded().equals(1)) {
                        outputStream.write("此id的文件已经被下载，不能再次下载".getBytes("UTF-8"));
                        outputStream.flush();
                    } else if (this.timeCalculateUtil.isExpired(tempDownloadUrlExpireTime.getCreateTime(), tempDownloadUrlExpireTime.getExpiredTime())) {
                        outputStream.write("此id的文件已10分钟过期，请重新请求".getBytes("UTF-8"));
                        outputStream.flush();
                    } else {
                        InputStream waterMarkerFileInputStream = new FileInputStream(this.ofdFilePath + id + this.destFileNameExt);
                        if (waterMarkerFileInputStream != null) {
                            response.setHeader("Content-type", "application/ofd");
                            response.setHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(id, "UTF-8") + this.destFileNameExt);
                            OutputFormateUtil.ReturnInPutStream(waterMarkerFileInputStream, outputStream);
                            if (waterMarkerFileInputStream.available() == 0) {
                                waterMarkerFileInputStream.close();
                            }

                            if (this.deleteFileRightNow.equals("1")) {
                                this.ofdUtil.deleteFile(id);
                            }

                            tempDownloadUrlExpireTime.setIsDownloaded(1);
                            tempDownloadUrlExpireTime.setIsFileDeleted(1);
                            this.tempDownloadUrlExpireTimeService.save(tempDownloadUrlExpireTime);
                        } else {
                            outputStream.write("加注件文件获取异常！".getBytes("UTF-8"));
                            outputStream.flush();
                        }
                    }
                }
            } catch (Throwable var8) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException var9) {
            this.logger.error("IO异常：{}", var9.getMessage());
        }

    }

    @LogsProvinceApi(
        apiName = "getDateByQRcode",
        apiDescription = "根据二维码信息获取证照数据,给业务部门使用"
    )
    public Object getDateByQRcode(HttpServletRequest request, QueryCertInfoByQrCodeQuery queryCertInfoByQrCodeQuery) {
        QueryCertInfoByQrCodeData data = queryCertInfoByQrCodeQuery.getData();
        new ResponseHead();
        QueryCertInfoRes queryCertInfoRes = new QueryCertInfoRes();
        QueryCertInfoDataRes queryCertInfoDataRes = new QueryCertInfoDataRes();
        if (!this.verifyUserToken(queryCertInfoByQrCodeQuery.getAccessId(), queryCertInfoByQrCodeQuery.getAccessToken())) {
            return this.returnParams(queryCertInfoRes.getClass(), 11, "身份验证不通过", queryCertInfoDataRes);
        } else if (!StringUtils.isEmpty(data.getQrcode()) && !StringUtils.isEmpty(data.getUseCause())) {
            QueryMapBuilder builder = QueryMapBuilder.builder();
            QueryEntity queryEntity = new QueryEntity();
            queryEntity.setField("qrCode");
            queryEntity.setValue(data.getQrcode());
            queryEntity.setType(QueryOperator.IS);
            builder.put(queryEntity);
            QueryEntity queryEntity_state = new QueryEntity();
            queryEntity_state.setField("state");
            queryEntity_state.setValue(this.stringArr2IntegerArr(this.validCertState));
            queryEntity_state.setType(QueryOperator.IN);
            builder.put(queryEntity_state);
            List<License> list = this.licenseService.findLicenseByCon(builder.build(), QueryModel.AND);
            License license = (License)list.get(0);
            if (license != null) {
                ResponseHead responseHead = this.verifyCertState(license.getState());
                if (!responseHead.getStatus().equals(0)) {
                    queryCertInfoRes.setHead(responseHead);
                    queryCertInfoRes.setData(queryCertInfoDataRes);
                    return queryCertInfoRes;
                } else if (!this.verifyUserCertPermission(queryCertInfoByQrCodeQuery.getAccessId(), license.getLicence_Type_Code())) {
                    return this.returnParams(queryCertInfoRes.getClass(), 100, "该用户无访问该证的权限！请先申请", queryCertInfoDataRes);
                } else {
                    List<NewAddCol> newAddColList = license.getNewAddCol();
                    Map<String, String> map = new HashMap();
                    if (this.updateFieldConvert(license)) {
                        map = this.dzzzMap2ProvinceMap(license, 1, (Map)null);
                    }

                    if (this.certIdentifier.equals("1")) {
                        ((Map)map).put("", license.getFileNumber());
                    } else if (this.certIdentifier.equals("0")) {
                        String dbDATA_ceridentifier_sdzzz = this.getDbDATA_CERIDENTIFIER_SDZZZ(license.getFileNumber());
                        if (StringUtils.isNotEmpty(dbDATA_ceridentifier_sdzzz)) {
                            ((Map)map).put("cert_identifier", dbDATA_ceridentifier_sdzzz);
                        }
                    }

                    queryCertInfoDataRes.setCertData(map);
                    queryCertInfoRes.setHead(responseHead);
                    queryCertInfoRes.setData(this.encrypt(request, queryCertInfoDataRes));
                    return queryCertInfoRes;
                }
            } else {
                return this.returnParams(queryCertInfoRes.getClass(), 10, "未找到匹配的证照信息", queryCertInfoDataRes);
            }
        } else {
            return this.returnParams(queryCertInfoRes.getClass(), 12, "要求必填的输入参数值不为空", queryCertInfoDataRes);
        }
    }

    public Object checkCertInfoByQRcode(HttpServletRequest request, QueryCertInfoQuery queryCertInfoQuery) {
        return null;
    }

    @LogsProvinceApi(
        apiName = "getDataByHolder",
        apiDescription = "基于持证主体代码信息获取服务"
    )
    public Object getDataByHolder(HttpServletRequest request, QueryCertInfoByHolderCode query) throws Exception {
        QueryCertInfoByHolderCodeData data = query.getData();
        ResponseHead responseHead = new ResponseHead();
        QueryCertInfoRes queryCertInfoRes = new QueryCertInfoRes();
        QueryCertInfoDataRes queryCertInfoDataRes = new QueryCertInfoDataRes();
        if (!this.verifyUserToken(query.getAccessId(), query.getAccessToken())) {
            return this.returnParams(queryCertInfoRes.getClass(), 11, "身份验证不通过", queryCertInfoDataRes);
        } else if (!StringUtils.isEmpty(data.getHolderCode()) && !StringUtils.isEmpty(data.getHolderTypeCode()) && !StringUtils.isEmpty(data.getCertTypeCode()) && !StringUtils.isEmpty(data.getUseCause())) {
            if (!this.isHolderTypeCode(data.getHolderTypeCode())) {
                return this.returnParams(queryCertInfoRes.getClass(), 103, "持证主体代码类型代码不符合规范", queryCertInfoDataRes);
            } else {
                QueryMapBuilder builder = QueryMapBuilder.builder();
                QueryEntity queryEntity = new QueryEntity();
                queryEntity.setField("licence_Type_Code");
                queryEntity.setValue(data.getCertTypeCode());
                queryEntity.setType(QueryOperator.IS);
                builder.put(queryEntity);
                List<Catalog> catalogByCon = this.catalogService.findCatalogByCon(builder.build(), new Integer[]{1}, new String[]{"updatetime"}, QueryModel.AND);
                if (catalogByCon.size() > 0 && catalogByCon.get(0) != null) {
                    if (!this.verifyUserCertPermission(query.getAccessId(), ((Catalog)catalogByCon.get(0)).getLicence_Type_Code())) {
                        return this.returnParams(queryCertInfoRes.getClass(), 100, "该用户无访问该证的权限！请先申请", queryCertInfoDataRes);
                    } else {
                        QueryEntity queryEntity_holderCode;
                        if (StringUtils.isNotEmpty(data.getCertNo())) {
                            queryEntity_holderCode = new QueryEntity();
                            queryEntity_holderCode.setField("license_number");
                            queryEntity_holderCode.setValue(data.getCertNo());
                            queryEntity_holderCode.setType(QueryOperator.IS);
                            builder.put(queryEntity_holderCode);
                        }

                        queryEntity_holderCode = new QueryEntity();
                        queryEntity_holderCode.setField("holder_code");
                        queryEntity_holderCode.setValue(data.getHolderCode());
                        queryEntity_holderCode.setType(QueryOperator.IS);
                        builder.put(queryEntity_holderCode);
                        Integer[] stateInteger = this.stringArr2IntegerArr(this.validCertState);
                        QueryEntity queryEntity_state = new QueryEntity();
                        queryEntity_state.setField("state");
                        queryEntity_state.setValue(stateInteger);
                        queryEntity_state.setType(QueryOperator.IN);
                        builder.put(queryEntity_state);

                        for(int i = 0; i < stateInteger.length; ++i) {
                            responseHead = this.verifyCertState(stateInteger[i]);
                            if (!responseHead.getStatus().equals(0)) {
                                queryCertInfoRes.setHead(responseHead);
                                queryCertInfoRes.setData(queryCertInfoDataRes);
                                return queryCertInfoRes;
                            }
                        }

                        List<License> list = this.licenseService.findLicenseByCon(builder.build(), QueryModel.AND);
                        if (list != null) {
                            if (list.size() > 0) {
                                if (list.size() == 1) {
                                    License license = (License)list.get(0);
                                    if (license != null) {
                                        Map<String, String> map = new HashMap();
                                        if (this.certIdentifier.equals("1")) {
                                            map.put("cert_identifier", license.getFileNumber());
                                        } else if (this.certIdentifier.equals("0")) {
                                            String dbDATA_ceridentifier_sdzzz = this.getDbDATA_CERIDENTIFIER_SDZZZ(license.getFileNumber());
                                            if (StringUtils.isNotEmpty(dbDATA_ceridentifier_sdzzz)) {
                                                map.put("cert_identifier", dbDATA_ceridentifier_sdzzz);
                                            }
                                        }

                                        List<Map<String, String>> mapList = new ArrayList();
                                        mapList.add(map);
                                        queryCertInfoDataRes.setCertData(mapList);
                                        queryCertInfoRes.setHead(responseHead);
                                        queryCertInfoRes.setData(this.encrypt(request, queryCertInfoDataRes));
                                        return queryCertInfoRes;
                                    } else {
                                        return this.returnParams(queryCertInfoRes.getClass(), 10, "未找到匹配的证照信息", queryCertInfoDataRes);
                                    }
                                } else {
                                    List<Map<String, String>> mapList = new ArrayList();

                                    for(int i = 0; i < list.size(); ++i) {
                                        License license = (License)list.get(i);
                                        if (license != null) {
                                            Map<String, String> map = new HashMap();
                                            if (this.certIdentifier.equals("1")) {
                                                map.put("cert_identifier", license.getFileNumber());
                                            } else if (this.certIdentifier.equals("0")) {
                                                String dbDATA_ceridentifier_sdzzz = this.getDbDATA_CERIDENTIFIER_SDZZZ(license.getFileNumber());
                                                if (StringUtils.isNotEmpty(dbDATA_ceridentifier_sdzzz)) {
                                                    map.put("cert_identifier", dbDATA_ceridentifier_sdzzz);
                                                }
                                            }

                                            mapList.add(map);
                                        }
                                    }

                                    if (mapList != null && mapList.size() != 0) {
                                        queryCertInfoDataRes.setCertData(mapList);
                                        queryCertInfoRes.setHead(responseHead);
                                        queryCertInfoRes.setData(this.encrypt(request, queryCertInfoDataRes));
                                        return queryCertInfoRes;
                                    } else {
                                        return this.returnParams(queryCertInfoRes.getClass(), 10, "未找到匹配的证照信息", queryCertInfoDataRes);
                                    }
                                }
                            } else {
                                return this.returnParams(queryCertInfoRes.getClass(), 10, "未找到匹配的证照信息", queryCertInfoDataRes);
                            }
                        } else {
                            return this.returnParams(queryCertInfoRes.getClass(), 10, "未找到匹配的证照信息", queryCertInfoDataRes);
                        }
                    }
                } else {
                    return this.returnParams(queryCertInfoRes.getClass(), 113, "证照类型代码有误", queryCertInfoDataRes);
                }
            }
        } else {
            return this.returnParams(queryCertInfoRes.getClass(), 12, "要求必填的输入参数值不为空", queryCertInfoDataRes);
        }
    }

    public Object downloadPdfFile(HttpServletRequest request, DownloadFileQuery data) {
        return null;
    }

    @LogsProvinceApi(
        apiName = "getCertRemarkInfo",
        apiDescription = "基于证照类型代码获取证照照面的字段解析"
    )
    public Object getCertRemarkInfo(HttpServletRequest request, CertRemarkQuery certRemarkQuery) {
        CertRemarkData data = certRemarkQuery.getData();
        ResponseHead responseHead = new ResponseHead();
        CertRemarkRes certRemarkRes = new CertRemarkRes();
        if (!this.verifyUserToken(certRemarkQuery.getAccessId(), certRemarkQuery.getAccessToken())) {
            return this.returnParams(certRemarkRes.getClass(), 11, "身份验证不通过", (Object)null);
        } else if (!StringUtils.isEmpty(data.getCertTypeCode()) && !StringUtils.isEmpty(data.getCertName())) {
            Map<String, QueryEntity> map = new HashMap();
            QueryEntity entity = new QueryEntity();
            entity.setField("state");
            entity.setValue(new Integer[]{CatalogState.STATE_RELEASE});
            entity.setType(new QueryOperator[]{QueryOperator.IS});
            map.put(entity.getField(), entity);
            if (StringUtils.isNotEmpty(data.getCertTypeCode())) {
                entity = new QueryEntity();
                entity.setField("licence_Type_Code");
                entity.setValue(new String[]{data.getCertTypeCode()});
                entity.setType(new QueryOperator[]{QueryOperator.IS});
                map.put(entity.getField(), entity);
            }

            if (StringUtils.isNotEmpty(data.getCertName())) {
                entity = new QueryEntity();
                entity.setField("license_name");
                entity.setValue(new String[]{data.getCertName()});
                entity.setType(new QueryOperator[]{QueryOperator.IS});
                map.put(entity.getField(), entity);
            }

            List<Catalog> catalogByCon = this.catalogService.findCatalogByCon(map, new Integer[]{1}, new String[]{"updatetime"}, QueryModel.AND);
            if (catalogByCon != null) {
                if (catalogByCon.size() > 0 && catalogByCon.size() == 1) {
                    Catalog catalog = (Catalog)catalogByCon.get(0);
                    if (!this.verifyUserCertPermission(certRemarkQuery.getAccessId(), catalog.getLicence_Type_Code())) {
                        return this.returnParams(certRemarkRes.getClass(), 100, "该用户无访问该证的权限！请先申请", (Object)null);
                    } else {
                        List<LicenseTemplate> templateListByCol = this.licenseTemplateService.findTemplateListByCol(catalog.getId(), "11");
                        if (templateListByCol != null && templateListByCol.size() > 0) {
                            if (templateListByCol.size() == 1) {
                                Map<String, String> dataMap = new LinkedHashMap();
                                Map<String, Object> retMap = new LinkedHashMap();
                                retMap.put("certTypeCode", "证照类型编码【必填项】");
                                dataMap.put("holderCode", "持证主体代码【必填项】");
                                dataMap.put("holder", "持证主体【必填项】");
                                dataMap.put("certNo", "证照编号【必填项】");
                                ((LicenseTemplate)templateListByCol.get(0)).getSurface().forEach((surface) -> {
                                    String simple = surface.getSimple();
                                    String chName = surface.getChName();
                                    dataMap.put(simple, chName);
                                });
                                retMap.put("certData", dataMap);
                                responseHead.setMessage("接口调用成功");
                                responseHead.setStatus(0);
                                certRemarkRes.setHead(responseHead);
                                certRemarkRes.setData(this.encrypt(request, retMap));
                                return certRemarkRes;
                            } else {
                                return this.returnParams(certRemarkRes.getClass(), 108, "证照模板数大于1，请联系管理员", (Object)null);
                            }
                        } else {
                            return this.returnParams(certRemarkRes.getClass(), 107, "未找到匹配的证照模板信息", (Object)null);
                        }
                    }
                } else {
                    return this.returnParams(certRemarkRes.getClass(), 106, "证照目录无法确定，请联系管理员", (Object)null);
                }
            } else {
                return this.returnParams(certRemarkRes.getClass(), 105, "未找到匹配的证照目录信息", (Object)null);
            }
        } else {
            return this.returnParams(certRemarkRes.getClass(), 12, "要求必填的输入参数值不为空", (Object)null);
        }
    }

    public boolean verifyUserToken(String accessId, String accessToken) {
        if (StringUtils.isNotEmpty(accessId) && StringUtils.isNotEmpty(accessToken)) {
            OauthUser oauthUser = this.oauthUserService.getByUsername(accessId);
            if (oauthUser != null) {
                if (this.isEncryptPWD.equals("1")) {
                    if (oauthUser.isEnabled() && oauthUser.getPassword().equals(MD5Util.md5Encrypt32Lower(accessToken))) {
                        return true;
                    }
                } else if (this.isEncryptPWD.equals("0") && oauthUser.isEnabled() && oauthUser.getPassword().equals(accessToken)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean verifyUserCertPermission(String accessId, String licenseTypeCode) {
        Map<String, String> map = this.certNameUserService.findKVByAccountId(accessId);
        if (map != null && map.size() > 0) {
            Iterator iterator = map.entrySet().iterator();

            while(iterator.hasNext()) {
                Entry<String, String> next = (Entry)iterator.next();
                if (((String)next.getKey()).equals(licenseTypeCode)) {
                    return true;
                }
            }
        }

        return false;
    }

    public ResponseHead verifyCertState(Integer licenseState) {
        ResponseHead responseHead = new ResponseHead();
        String[] splitSupportCertState = this.supportCertState.split(",");
        boolean isSystemSupport = false;
        String[] var5 = splitSupportCertState;
        int var6 = splitSupportCertState.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String sCertState = var5[var7];
            if (sCertState.equals(String.valueOf(licenseState))) {
                isSystemSupport = true;
                break;
            }
        }

        if (!isSystemSupport) {
            responseHead.setMessage("证照类型不存在或未发布");
            responseHead.setStatus(13);
            return responseHead;
        } else {
            switch(licenseState) {
            case -8:
            case -5:
            case -3:
            case -2:
                responseHead.setMessage("该电子证照已废止或已注销");
                responseHead.setStatus(21);
                break;
            case -7:
            case -6:
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                responseHead.setMessage("系统异常，证照状态配置错误");
                responseHead.setStatus(101);
                break;
            case -4:
                responseHead.setMessage("该电子证照已过期");
                responseHead.setStatus(22);
                break;
            case 12:
            case 13:
                responseHead.setMessage("该电子证照已受限使用");
                responseHead.setStatus(23);
            }

            if (this.validCertState.contains(licenseState.toString())) {
                responseHead.setMessage("接口调用成功");
                responseHead.setStatus(0);
            }

            return responseHead;
        }
    }

    private Integer[] stringArr2IntegerArr(String str) {
        String[] split = str.split(",");
        Integer[] integers = new Integer[split.length];

        for(int i = 0; i < split.length; ++i) {
            integers[i] = Integer.parseInt(split[i]);
        }

        return integers;
    }

    private Map newAddCol2Map(List<NewAddCol> list) {
        Map<String, String> returnMap = new HashMap();
        list.forEach((newAddCol) -> {
            returnMap.put(newAddCol.gettKey(), newAddCol.gettValue());
        });
        return returnMap;
    }

    private boolean compareMapInfo(License license, Map<String, String> map) {
        boolean retB = true;
        map.remove("certNo");
        map.remove("holder");
        map.remove("holderCode");
        Map mapDzzz = this.dzzzMap2ProvinceMap(license, 0, map);
        Iterator iterator = mapDzzz.entrySet().iterator();

        while(true) {
            Entry next;
            String[] split;
            label64:
            do {
                while(iterator.hasNext()) {
                    next = (Entry)iterator.next();
                    if (((String)next.getKey()).contains(".")) {
                        split = ((String)next.getKey()).split("\\.");
                        continue label64;
                    }

                    String dzzzKey = (String)next.getKey();
                    split = dzzzKey.split("_");
                    String getMethodName = "get";

                    for(int i = 0; i < split.length; ++i) {
                        getMethodName = getMethodName + split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
                    }

                    Class licenseClass = license.getClass();

                    try {
                        Method method = licenseClass.getMethod(getMethodName);
                        if (method.getReturnType().getName().equals("java.lang.String") && method.invoke(license) != null && !method.invoke(license).toString().equals(next.getValue())) {
                            retB = false;
                        }

                        if (method.getReturnType().getName().equals("java.util.Date") && method.invoke(license) != null && !this.timeCalculateUtil.date2String((Date)method.invoke(license)).equals(next.getValue())) {
                            retB = false;
                        }
                    } catch (NoSuchMethodException var12) {
                        var12.printStackTrace();
                    } catch (IllegalAccessException var13) {
                        var13.printStackTrace();
                    } catch (InvocationTargetException var14) {
                        var14.printStackTrace();
                    }
                }

                return retB;
            } while(!split[0].equals("NewAddCol"));

            List<NewAddCol> newAddColList = license.getNewAddCol();

            for(int i = 0; i < newAddColList.size(); ++i) {
                if (split[split.length - 1].equals(((NewAddCol)newAddColList.get(i)).gettKey()) && !((String)next.getValue()).equals(((NewAddCol)newAddColList.get(i)).gettValue())) {
                    retB = false;
                }
            }
        }
    }

    private boolean isHolderTypeCode(String holderTypeCode) {
        String[] splitHolderTypeCodes = this.holderTypeCodes.split(",");
        String[] var3 = splitHolderTypeCodes;
        int var4 = splitHolderTypeCodes.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String splitHolderTypeCode = var3[var5];
            if (splitHolderTypeCode.equals(holderTypeCode)) {
                return true;
            }
        }

        return false;
    }

    private boolean isUseCauseExceed200(String useCause) {
        return useCause.length() > 200;
    }

    private Object encrypt(HttpServletRequest request, Object toEncrypt) {
        Gson gson = (new GsonBuilder()).disableHtmlEscaping().create();
        String retStr = gson.toJson(toEncrypt);
        if (request.getHeader(this.localRequestKey) != null && request.getHeader(this.localRequestKey).equals(this.localRequestValue)) {
            return toEncrypt;
        } else {
            this.logger.debug("未加密前json值：" + retStr);

            try {
                if (toEncrypt instanceof QueryCertInfoDataRes) {
                    QueryCertInfoDataRes queryCertInfoDataRes = (QueryCertInfoDataRes)toEncrypt;
                    String certData = gson.toJson(queryCertInfoDataRes.getCertData());
                    queryCertInfoDataRes.setCertData(SM2Utils.encrypt(Util.hexToByte(this.publickey), certData.getBytes("utf-8")));
                    return queryCertInfoDataRes;
                }

                retStr = SM2Utils.encrypt(Util.hexToByte(this.publickey), retStr.getBytes("utf-8"));
            } catch (IOException var7) {
                var7.printStackTrace();
            }

            return retStr;
        }
    }

    private void generateWaterMarkerFile(String fileId, String tempFileId, String useFor) {
        InputStream in = null;
        FileOutputStream fileOutputStream = null;
        if (StringUtils.isNotEmpty(fileId) && StringUtils.isNotEmpty(tempFileId) && StringUtils.isNotEmpty(useFor)) {
            try {
                in = this.gridfsService.getInputStreamById("3", fileId);
                fileOutputStream = new FileOutputStream(this.ofdFilePath + tempFileId + this.srcFileNameExt);
                if (in != null) {
                    IOUtils.copy(in, fileOutputStream);
                }

                fileOutputStream.flush();
                fileOutputStream.close();
                in.close();
                this.ofdUtil.addWaterMarker(useFor, tempFileId);
            } catch (FileNotFoundException var17) {
                this.logger.error("文件未找到异常：{}", var17.getMessage());
            } catch (IOException var18) {
                this.logger.error("IO异常：{}", var18.getMessage());
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }

                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var16) {
                    var16.printStackTrace();
                }

            }
        }

    }

    private void generateOfdFile(String fileId, String tempFileId) {
        if (StringUtils.isNotEmpty(fileId) && StringUtils.isNotEmpty(tempFileId)) {
            try {
                InputStream in = this.gridfsService.getInputStreamById("3", fileId);

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.ofdFilePath + tempFileId + this.srcFileNameExt);

                    try {
                        IOUtils.copy(in, fileOutputStream);
                    } catch (Throwable var9) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }

                        throw var9;
                    }

                    fileOutputStream.close();
                } catch (Throwable var10) {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Throwable var7) {
                            var10.addSuppressed(var7);
                        }
                    }

                    throw var10;
                }

                if (in != null) {
                    in.close();
                }
            } catch (FileNotFoundException var11) {
                this.logger.error("文件未找到异常：{}", var11.getMessage());
            } catch (IOException var12) {
                this.logger.error("IO异常：{}", var12.getMessage());
            }
        }

    }

    private List<String> getDbImgBase64(String[] imgIds) {
        List<String> retStrList = new ArrayList();

        for(int i = 0; i < imgIds.length; ++i) {
            try {
                InputStream in = this.gridfsService.getInputStreamById("3", imgIds[i]);

                try {
                    retStrList.add(Base64Util.ioToBase64(in));
                } catch (Throwable var8) {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (in != null) {
                    in.close();
                }
            } catch (IOException var9) {
                this.logger.error("数据库图片获取异常：" + var9.getMessage());
            }
        }

        return retStrList;
    }

    private String getSuwellConvertImg(String ofdFileId) {
        return "";
    }

    private String getWaterMarkerFile(String tempFileId) {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.ofdFilePath + tempFileId + this.destFileNameExt);

            String var3;
            try {
                var3 = Base64Util.ioToBase64(fileInputStream);
            } catch (Throwable var6) {
                try {
                    fileInputStream.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            fileInputStream.close();
            return var3;
        } catch (FileNotFoundException var7) {
            this.logger.error("文件未找到异常:{}", var7.getMessage());
        } catch (IOException var8) {
            this.logger.error("IO异常:{}", var8.getMessage());
        }

        return null;
    }

    private <T> T returnParams(Class<T> tClass, Integer status, String message, Object data) {
        ResponseHead responseHead = null;
        if (!StringUtils.isEmpty(status.toString()) && !StringUtils.isEmpty(message)) {
            responseHead = new ResponseHead();
            responseHead.setStatus(status);
            responseHead.setMessage(message);
        } else {
            this.logger.error("status和message参数都不能为空");
        }

        try {
            T t = tClass.newInstance();
            Method[] methods = tClass.getDeclaredMethods();
            Method[] var8 = methods;
            int var9 = methods.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Method method = var8[var10];
                if (method.getName().equals("setHead")) {
                    method.invoke(t, responseHead);
                }

                if (method.getName().equals("setData") && data != null) {
                    method.invoke(t, data);
                }
            }

            return t;
        } catch (IllegalAccessException var12) {
            this.logger.error("IllegalAccessException:{}", var12.getMessage());
        } catch (InstantiationException var13) {
            this.logger.error("InstantiationException:{}", var13.getMessage());
        } catch (InvocationTargetException var14) {
            this.logger.error("InvocationTargetException:{}", var14.getMessage());
        }

        return null;
    }

    private String getDbDATA_CERIDENTIFIER_SDZZZ(String fileNumber) {
        Map<String, String> map = new HashMap();
        map.put("fileNumber", fileNumber);
        String retStr = this.httpInstance.sendHttpPost(this.fileNumber2CertIdentifierUrl, map);
        return retStr;
    }

    private String getDbFileNumber(String DATA_CERIDENTIFIER_SDZZZ) {
        Map<String, String> map = new HashMap();
        map.put("newIdentifier", DATA_CERIDENTIFIER_SDZZZ);
        String retStr = this.httpInstance.sendHttpPost(this.certIdentifier2fileNumberUrl, map);
        return retStr;
    }

    public boolean updateFieldConvert(License license) {
//        this.mapCatalogIds = this.readConfig2Map(this.byCatalogIds);
//        this.mapLicenseTypeCodes = this.readConfig2Map(this.byLicenseTypeCodes);
//        List<FieldConvert> fieldConvertList = null;
//        if (this.mapCatalogIds != null && this.mapCatalogIds.containsKey(license.getCatalogId())) {
        List<FieldConvert>  fieldConvertList = this.iFieldConvertService.findByCatalogIdIsAutoAdjust0(license.getCatalogId());
//        } else if (this.mapLicenseTypeCodes != null && this.mapLicenseTypeCodes.containsKey(license.getLicence_Type_Code()) && fieldConvertList == null) {
//            fieldConvertList = this.iFieldConvertService.findByLicenseTypeCodeIsAutoAdjust0(license.getLicence_Type_Code());
//        }

        if (fieldConvertList.size() > 0) {
            Method[] declaredMethods = license.getClass().getSuperclass().getDeclaredMethods();

            for(int i = 0; i < declaredMethods.length; ++i) {
                Iterator var5 = fieldConvertList.iterator();

                while(var5.hasNext()) {
                    FieldConvert fc = (FieldConvert)var5.next();
                    if (declaredMethods[i].getName().replace("get", "").toLowerCase().equals(fc.getDzzzField().replaceAll("_", "").toLowerCase())) {
                        fc.setIsAutoAdjust("1");
                        this.iFieldConvertService.save(fc);
                    }
                }
            }

            List<NewAddCol> newAddColList = license.getNewAddCol();
            for (int i = 0; i < newAddColList.size(); i++) {
                NewAddCol newAddCol =newAddColList.get(i);

                fieldConvertList.forEach((fieldConvert) -> {
                    if (newAddCol.gettKey().equals(fieldConvert.getDzzzField())) {
                        fieldConvert.setDzzzField("NewAddCol." + newAddCol.gettKey());
                        fieldConvert.setIsAutoAdjust("1");
                        this.iFieldConvertService.save(fieldConvert);
                    }

                });
            }


        }

        return fieldConvertList.size() == 0;
    }

    public Map dzzzMap2ProvinceMap(License license, Integer flag, Map<String, String> provinceMap) {
        Map retMap = new HashMap();
//        List<FieldConvert> fieldConvertList = null;
//        if (this.mapCatalogIds != null && this.mapCatalogIds.containsKey(license.getCatalogId())) {
            List<FieldConvert> fieldConvertList = this.iFieldConvertService.findByCatalogId(license.getCatalogId());
//        } else if (this.mapLicenseTypeCodes != null && this.mapLicenseTypeCodes.containsKey(license.getLicence_Type_Code()) && fieldConvertList == null) {
//            fieldConvertList = this.iFieldConvertService.findByLicenseTypeCode(license.getLicence_Type_Code());
//        }

        if (fieldConvertList.size() > 0) {
            Class<? extends License> licenseClass = license.getClass();
            Iterator var7 = fieldConvertList.iterator();

            while(true) {
                while(var7.hasNext()) {
                    FieldConvert fieldConvert = (FieldConvert)var7.next();
                    if (flag.equals(1)) {
                        String value = "";
                        String dzzzField = fieldConvert.getDzzzField();
                        if (dzzzField.contains(".")) {
                            String[] split = dzzzField.split("\\.");
                            if (split[0].equals("NewAddCol")) {
                                Iterator var22 = license.getNewAddCol().iterator();

                                while(var22.hasNext()) {
                                    NewAddCol newAddCol = (NewAddCol)var22.next();
                                    if (newAddCol.gettKey().equals(split[1])) {
                                        value = newAddCol.gettValue();
                                    }
                                }
                            }
                        } else {
                            Method method = null;

                            try {
                                String dzzzFieldTemp = fieldConvert.getDzzzField();
                                String[] strArray = dzzzFieldTemp.split("_");
                                String finalDzzzField = "";

                                for(int i = 0; i < strArray.length; ++i) {
                                    finalDzzzField = finalDzzzField + strArray[i].substring(0, 1).toUpperCase() + strArray[i].substring(1, strArray[i].length());
                                }

                                method = licenseClass.getMethod("get" + finalDzzzField);
                                if (method.getReturnType().getName().equals("java.lang.String")) {
                                    if (method.invoke(license) != null) {
                                        value = method.invoke(license).toString();
                                    }
                                } else if (method.getReturnType().getName().equals("java.util.Date") && method.invoke(license) != null) {
                                    value = this.timeCalculateUtil.date2String((Date)method.invoke(license));
                                }
                            } catch (NoSuchMethodException var16) {
                                var16.printStackTrace();
                            } catch (IllegalAccessException var17) {
                                var17.printStackTrace();
                            } catch (InvocationTargetException var18) {
                                var18.printStackTrace();
                            }
                        }

                        retMap.put(fieldConvert.getProvinceField(), value);
                    } else if (flag.equals(0) && provinceMap != null && provinceMap.size() > 0) {
                        Iterator iterator = provinceMap.entrySet().iterator();

                        while(iterator.hasNext()) {
                            Entry<String, String> next = (Entry)iterator.next();
                            if (((String)next.getKey()).equals(fieldConvert.getProvinceField())) {
                                retMap.put(fieldConvert.getDzzzField(), next.getValue());
                                break;
                            }
                        }
                    }
                }

                return retMap;
            }
        } else {
            return retMap;
        }
    }

    private Map readConfig2Map(String readConfig) {
        Gson gson = (new GsonBuilder()).disableHtmlEscaping().create();
        Map retMap = Maps.newHashMap();
        retMap = (Map)gson.fromJson(readConfig, Map.class);
        return retMap;
    }
}
