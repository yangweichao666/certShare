//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    private RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000).setConnectionRequestTimeout(15000).build();
    private static HttpUtils instance = null;

    public HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (instance == null) {
            instance = new HttpUtils();
        }

        return instance;
    }

    public String sendHttpPost(String httpUrl) {
        HttpPost httpPost = new HttpPost(httpUrl);
        return this.sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);

        try {
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
        } catch (Exception var5) {
            logger.error(var5.getMessage(), var5);
        }

        return this.sendHttpPost(httpPost);
    }

    public Map<String, Object> sendHttpPostRetObjec(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        HashMap mapResult = new HashMap();

        try {
            if (params != null && params != "") {
                StringEntity stringEntity = new StringEntity(params, "UTF-8");
                stringEntity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(stringEntity);
            }
        } catch (Exception var27) {
            logger.error(var27.getMessage(), var27);
        }

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        ByteArrayInputStream swapInputStream = null;
        HttpEntity entity = null;
        Object var9 = null;

        HashMap var11;
        try {
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(this.requestConfig);
            response = httpClient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                response.getEntity().writeTo(bos);
                swapInputStream = new ByteArrayInputStream(bos.toByteArray());
                mapResult.put("inputStream", swapInputStream);
                mapResult.put("code", "00");
                Header[] headers = response.getAllHeaders();
                Header[] var13 = headers;
                int var14 = headers.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    Header header = var13[var15];
                    if (Objects.equals(header.getName(), "Content-Type")) {
                        mapResult.put("contentType", header.getValue());
                    }

                    if (Objects.equals(header.getName(), "Content-Disposition")) {
                        mapResult.put("contentDisposition", header.getValue());
                    }
                }

                HashMap var32 = mapResult;
                return var32;
            }

            mapResult.put("code", "99");
            mapResult.put("msg", "调用接口异常，返回码:" + code);
            var11 = mapResult;
        } catch (Exception var28) {
            logger.error(var28.getMessage(), var28);
            mapResult.put("code", "99");
            mapResult.put("msg", "调用接口异常");
            var11 = mapResult;
            return var11;
        } finally {
            try {
                if (swapInputStream != null) {
                    swapInputStream.close();
                }

                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var26) {
                logger.error(var26.getMessage(), var26);
            }

        }

        return var11;
    }

    public String sendHttpPost(String httpUrl, Map<String, String> maps) {
        HttpPost httpPost = new HttpPost(httpUrl);
        List<NameValuePair> nameValuePairs = new ArrayList();
        Iterator var5 = maps.keySet().iterator();

        while(var5.hasNext()) {
            String key = (String)var5.next();
            nameValuePairs.add(new BasicNameValuePair(key, (String)maps.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception var7) {
            logger.error(var7.getMessage(), var7);
        }

        return this.sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, Map<String, String> maps, List<File> fileLists) {
        HttpPost httpPost = new HttpPost(httpUrl);
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
        Iterator var6 = maps.keySet().iterator();

        while(var6.hasNext()) {
            String key = (String)var6.next();
            meBuilder.addPart(key, new StringBody((String)maps.get(key), ContentType.TEXT_PLAIN));
        }

        var6 = fileLists.iterator();

        while(var6.hasNext()) {
            File file = (File)var6.next();
            FileBody fileBody = new FileBody(file);
            meBuilder.addPart("files", fileBody);
        }

        HttpEntity reqEntity = meBuilder.build();
        httpPost.setEntity(reqEntity);
        return this.sendHttpPost(httpPost);
    }

    private String sendHttpPost(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        try {
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(this.requestConfig);
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception var15) {
            logger.error(var15.getMessage(), var15);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var14) {
                logger.error(var14.getMessage(), var14);
            }

        }

        return responseContent;
    }

    public String sendHttpGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);
        return this.sendHttpGet(httpGet);
    }

    public String sendHttpsGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);
        return this.sendHttpsGet(httpGet);
    }

    private String sendHttpGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        try {
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(this.requestConfig);
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception var15) {
            logger.error(var15.getMessage(), var15);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var14) {
                logger.error(var14.getMessage(), var14);
            }

        }

        return responseContent;
    }

    private String sendHttpsGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        try {
            PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(new URL(httpGet.getURI().toString()));
            DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
            httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
            httpGet.setConfig(this.requestConfig);
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception var16) {
            logger.error(var16.getMessage(), var16);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var15) {
                logger.error(var15.getMessage(), var15);
            }

        }

        return responseContent;
    }

    public static String buildQuery(Map<String, Object> params, String charset) {
        if (params != null && !params.isEmpty()) {
            StringBuffer data = new StringBuffer();
            boolean flag = false;
            Iterator var4 = params.entrySet().iterator();

            while(var4.hasNext()) {
                Entry<String, Object> entry = (Entry)var4.next();
                if (flag) {
                    data.append("&");
                } else {
                    flag = true;
                }

                if (entry.getValue() != null) {
                    String str = entry.getValue().toString();

                    try {
                        data.append((String)entry.getKey()).append("=").append(URLEncoder.encode(str, charset));
                    } catch (UnsupportedEncodingException var8) {
                        logger.error(var8.getMessage(), var8);
                    }
                }
            }

            logger.info("http请求:" + data.toString());
            return data.toString();
        } else {
            return null;
        }
    }

    public static Map<String, Object> getHttpContent(String url, Map<String, Object> transParams) {
        HttpUtils httpclient = getInstance();
        String params = "";
        String content = "";
        Map<String, Object> result = new HashMap();
        params = buildQuery(transParams, "UTF-8");
        content = httpclient.sendHttpPost(url, params);
        result.put("code", "00");
        result.put("msg", content);
        return result;
    }

    public static Map<String, Object> getHttpInputStream(String url, Map<String, Object> transParams) {
        HttpUtils httpclient = getInstance();
        String params = "";
        new HashMap();
        params = buildQuery(transParams, "UTF-8");
        Map<String, Object> content = httpclient.sendHttpPostRetObjec(url, params);
        return content;
    }
}
