package cn.enixlin.jmrc.asone.manager.net;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {

	private CloseableHttpClient httpClient;
	private CookieStore cookieStore;

	public HttpClient() {
		// TODO Auto-generated constructor stub
		super();
		this.httpClient = HttpClients.createDefault();
	}
	
	public Object doPost() {
		Object object=null;
		return  object;
	}
	
	
	public Object doGet() {
		Object object=null;
		return  object;
	}

}
