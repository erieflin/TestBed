package json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import json.templates.Alert;

public class JSONTest {
	private static final String ALERTSURL = "https://api.warframestat.us/pc/alerts";
	public static  void main(String[] args){
		getAlerts();
	}
	public static List<Alert> getAlerts(){
		List<Alert> alerts = new ArrayList<Alert>();
		try {
			HttpResponse response = HttpUtils.sendRequest(JSONTest.ALERTSURL);
			String json = HttpUtils.getContentFromResponse(response);
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<Alert>>(){}.getType();
			alerts =  gson.fromJson(json, listType);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alerts;
	}
}
