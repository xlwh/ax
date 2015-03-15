package com.ax.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

/**
 * 短信发送接口
 * @author Administrator
 *
 */

@Component
public class SMSUtil {
	private static int connectTimeOut = 5000;
	private static int readTimeOut = 10000;
	private static String requestEncoding = "UTF-8";
	public static String MSG_TEMPLATE = "尊敬的用户，您的验证码为：xxxxxx,工作人员不会索取，请勿泄露。";

	public static int getConnectTimeOut() {
		return connectTimeOut;
	}

	public static void setConnectTimeOut(int connectTimeOut) {
		SMSUtil.connectTimeOut = connectTimeOut;
	}

	public static int getReadTimeOut() {
		return readTimeOut;
	}

	public static void setReadTimeOut(int readTimeOut) {
		SMSUtil.readTimeOut = readTimeOut;
	}

	public static String getRequestEncoding() {
		return requestEncoding;
	}

	public static void setRequestEncoding(String requestEncoding) {
		SMSUtil.requestEncoding = requestEncoding;
	}

	public static String doGet(String requrl, Map<?, ?> parameters, String recvEndcoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset = recvEndcoding == "" ? SMSUtil.requestEncoding : recvEndcoding;
		try {
			StringBuffer params = new StringBuffer();
			for (Iterator<?> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(), vchartset));
				params.append("&");
			}
			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}
			URL url = new URL(requrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			System.setProperty("连接超时：", String.valueOf(SMSUtil.connectTimeOut));
			System.setProperty("访问超时：", String.valueOf(SMSUtil.readTimeOut));
			url_con.setDoOutput(true);//
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len).trim());
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}
		} catch (Exception e) {
			System.out.println("网络故障:" + e.toString());
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;

	}

	public static String doGet(String reqUrl, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset = recvEncoding == "" ? SMSUtil.requestEncoding : recvEncoding;
		try {
			StringBuffer params = new StringBuffer();
			String queryUrl = reqUrl;
			int paramIndex = reqUrl.indexOf("?");

			if (paramIndex > 0) {
				queryUrl = reqUrl.substring(0, paramIndex);
				String parameters = reqUrl.substring(paramIndex + 1, reqUrl.length());
				String[] paramArray = parameters.split("&");
				for (int i = 0; i < paramArray.length; i++) {
					String string = paramArray[i];
					int index = string.indexOf("=");
					if (index > 0) {
						String parameter = string.substring(0, index);
						String value = string.substring(index + 1, string.length());
						params.append(parameter);
						params.append("=");
						params.append(URLEncoder.encode(value, vchartset));
						params.append("&");
					}
				}

				params = params.deleteCharAt(params.length() - 1);
			}
			URL url = new URL(queryUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(SMSUtil.connectTimeOut));
			System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(SMSUtil.readTimeOut));
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len)).trim();
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}
		} catch (Exception e) {
			System.out.println("网络故障:" + e.toString());
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;

	}

	public static String doPost(String reqUrl, Map<String, String> parameters, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset = recvEncoding == "" ? SMSUtil.requestEncoding : recvEncoding;
		try {
			StringBuffer params = new StringBuffer();
			for (Iterator<?> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(), vchartset));
				params.append("&");
			}

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setConnectTimeout(SMSUtil.connectTimeOut);
			url_con.setReadTimeout(SMSUtil.readTimeOut);
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len)).trim();
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}

		} catch (IOException e) {
			System.out.println("网络故障:" + e.toString());
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
	}

	/**
	 * 发送短信验证码
	 * @param phone
	 * @param code
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String sendSMS(String phone, String code) {
		/*String msg = "尊敬的用户，您的验证码为"+code+",工作人员不会索取，请勿泄露。";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "18951899340");//此处填写用户账号
		map.put("pwd", "11F5342184C8B9CF02397D608628");//此处填写用户密码
		map.put("content",msg);//此处填写发送号码
		map.put("mobile",phone);//此处填写模板短信编号
		map.put("type","pt");//此处填写模板短信内容
		map.put("sign", "爱学圈");
		String temp = SMSUtil.doPost("http://sms.1xinxi.cn/asmx/smsservice.aspx",map, "UTF-8");
		return temp;*/
		HashMap<String, Object> result = null;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		restAPI.init("sandboxapp.cloopen.com", "8883");
		restAPI.setAccount("8a48b5514b0b8727014b2fac38d623fc", "c3872575ecfa467dbdaaeafa0733b3ac");
		restAPI.setAppId("8a48b5514b0b8727014b2fad62db2406");
		result = restAPI.sendTemplateSMS(phone, "1", new String[] { code, "3" });
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			//正常返回输出data包体信息（map）
			HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for (String key : keySet) {
				Object object = data.get(key);
				System.out.println(key + " = " + object);
			}
		} else {
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
		}
		return "" + result.get("statusCode");
	}

}
