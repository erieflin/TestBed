package json;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpUtils {
	public static HttpResponse sendRequest(String url) throws ClientProtocolException, IOException, NoSuchAlgorithmException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		return   httpclient.execute(httpGet);
	

	}
	
	public static String getContentFromResponse(HttpResponse response) throws UnsupportedOperationException, IOException{
		String responseStr = IOUtils.toString(response.getEntity().getContent(), "utf-8");
		return responseStr;
	}
}
