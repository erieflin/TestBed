package warframe.json;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpUtils {
	private static CloseableHttpClient httpClient = null;
	
	public static void closeClient() throws IOException{
		httpClient.close();
	}
	public static void openClient(){
		if(httpClient != null){
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		httpClient = HttpClients.createDefault();
	}
	public static CloseableHttpResponse sendRequest(String url) throws ClientProtocolException, IOException, NoSuchAlgorithmException{
		
		HttpGet httpGet = new HttpGet(url);
		return  httpClient.execute(httpGet);
		

	}
	
	public static String getContentFromResponse(HttpResponse response) throws UnsupportedOperationException, IOException{
		String responseStr = IOUtils.toString(response.getEntity().getContent(), "utf-8");
		return responseStr;
	}
}
