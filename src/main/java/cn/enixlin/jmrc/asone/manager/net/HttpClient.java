package cn.enixlin.jmrc.asone.manager.net;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;

public class HttpClient {

	private CloseableHttpClient httpClient;
	private CookieStore cookieStore;
	private BasicHttpContext basicHttpContext;
	private RequestConfig requestConfig;

	public HttpClient() {
		// TODO Auto-generated constructor stub
		super();
		this.httpClient = HttpClients.createDefault();
		this.basicHttpContext = new BasicHttpContext();
		//basicHttpContext.setAttribute("connect", "www.124.com");
		HttpGet httpget = new HttpGet("http://asone.safesvc.gov.cn/asone/jsp/code.jsp");
		try {
			httpClient.execute(httpget, basicHttpContext);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("initial httpclient is done");
	}

	public int setInitConfig() {

		return 0;
	}

	public Object doPost() {
		Object object = null;
		return object;
	}

	public Object doGet() {
		Object object = null;
		return object;
	}

}
