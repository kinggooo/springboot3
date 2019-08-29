package com.wangnz.springboot.hello.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;
import java.util.Set;

//import org.apache.log4j.Logger;

/**
 *
 * @author Luo Kai
 *
 */
public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * Post方法调用接口。
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params, String charset) {
		StringBuffer response = new StringBuffer();
		HttpClient client = new HttpClient();

		  client.getHttpConnectionManager().getParams()
		    .setConnectionTimeout(30000);
		client.getHttpConnectionManager().getParams().setSoTimeout(30000);
		PostMethod method = new PostMethod(url);
		// 设置Http Post数据
		method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		if (params != null) {
			Set<String> keySet = params.keySet();
			NameValuePair[] param = new NameValuePair[keySet.size()];
			int i = 0;
			for (String key : keySet) {
				param[i] = new NameValuePair(key, params.get(key));
				i++;
			}
			method.setRequestBody(param);
		}
		InputStream responseBodyStream = null;
		InputStreamReader streamReader = null;
		BufferedReader reader = null;
		try {
			int responseCode = client.executeMethod(method);
			//logger.info(responseCode);

			if (method.getStatusCode() == HttpStatus.SC_OK) {

				responseBodyStream = method.getResponseBodyAsStream();
				streamReader = new InputStreamReader(responseBodyStream, charset);
				reader = new BufferedReader(streamReader);
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}

			}
		} catch (IOException e) {
			logger.error("执行HTTP Post请求" + url + "时，发生异常！", e);
		} finally {
			try {
				if(null != responseBodyStream){
					responseBodyStream.close();
				}
				if(null != streamReader){
					streamReader.close();
				}
				if(null != reader){
					reader.close();
				}
			} catch (IOException e) {
				logger.error("执行HTTP Post请求" + url + "时，发生异常，关闭流异常！", e);
				e.printStackTrace();
			}
			method.releaseConnection();
		}
		return response.toString();
	}

	/**
	 * Get方法调用接口。
	 * @param url
	 * @return
	 */
	public static String doGet(String url,String charset) {

		//创建默认的httpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String retMsg = null;
        try {

        	 //URL urlTemp = new URL(url);
             URI uri = new URI(url);//urlTemp.getProtocol(), urlTemp.getHost(), urlTemp.getPath(), urlTemp.getQuery(), null);

            //用get方法发送http请求
            HttpGet get = new HttpGet(uri);

            //get.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            try{
                //response实体
            	HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                  //  System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                	retMsg = EntityUtils.toString(entity,charset);
                }
            }
            finally{
                httpResponse.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        finally{

            try{
                if (httpClient != null){
                	httpClient.close();
                }

            } catch (IOException e){
                logger.error(e.getMessage());
            }
        }

        return retMsg;
	}
	/**
     * Post方法调用接口。
     * @param url
     * @param params
     * @param charset
     * @return
     */
    public static String doPost(String url, Map<String, String> params,  String charset,int ConnectionTimeout,int SoTimeout) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();

          client.getHttpConnectionManager().getParams()
            .setConnectionTimeout(ConnectionTimeout);
        client.getHttpConnectionManager().getParams().setSoTimeout(SoTimeout);
        PostMethod method = new PostMethod(url);
        // 设置Http Post数据
        method.setRequestHeader("Connection", "close");
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(1, false));
        if (params != null) {
            Set<String> keySet = params.keySet();
            NameValuePair[] param = new NameValuePair[keySet.size()];
            int i = 0;
            for (String key : keySet) {
                param[i] = new NameValuePair(key, params.get(key));
                i++;
            }
            method.setRequestBody(param);
        }
        InputStream responseBodyStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        try {
            int responseCode = client.executeMethod(method);
            //logger.info(responseCode);

            if (method.getStatusCode() == HttpStatus.SC_OK) {

                responseBodyStream = method.getResponseBodyAsStream();
                streamReader = new InputStreamReader(responseBodyStream, charset);
                reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

            }
        } catch (IOException e) {
            logger.error("执行HTTP Post请求" + url + "时，发生异常！", e);
        } finally {
            try {
                if(null != responseBodyStream){
                    responseBodyStream.close();
                }
                if(null != streamReader){
                    streamReader.close();
                }
                if(null != reader){
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("执行HTTP Post请求" + url + "时，发生异常，关闭流异常！", e);
                e.printStackTrace();
            }
            method.releaseConnection();
        }
        return response.toString();
    }
}
