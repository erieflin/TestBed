package warframe.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import warframe.json.Filters;
import warframe.json.HttpUtils;
import warframe.json.templates.Alert;
import warframe.json.templates.CetusCycle;
import warframe.json.templates.Fissure;
import warframe.json.templates.Invasion;
import warframe.json.templates.WorldState;

public class WorldstateUtils {

	private static final String PCURL = "https://api.warframestat.us/pc";
	private static final String ALERTSURL = PCURL + "/alerts";
	private static final String INVASIONSURL = PCURL + "/invasions";
	private static final String FISSURESSURL = PCURL + "/fissures";
	private static final String CETUSURL = PCURL + "/cetusCycle";
	
	public static WorldState getWorldState() {
		WorldState world = new WorldState();
		CloseableHttpResponse response = null;
		try {
			HttpUtils.openClient();
			response = HttpUtils.sendRequest(WorldstateUtils.PCURL);
			String json = HttpUtils.getContentFromResponse(response);

			Gson gson = new Gson();

			world = gson.fromJson(json, WorldState.class);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
					HttpUtils.closeClient();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return world;
	}
	
	public static CetusCycle getCetus(){
		CetusCycle cetus = new CetusCycle();
		CloseableHttpResponse response = null;
		try {
			HttpUtils.openClient();
			response = HttpUtils.sendRequest(WorldstateUtils.CETUSURL);
			String json = HttpUtils.getContentFromResponse(response);

			Gson gson = new Gson();

			cetus = gson.fromJson(json, CetusCycle.class);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
					HttpUtils.closeClient();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cetus;
	}
	
	
	public static List<Fissure> getFissures(){
		List<Fissure> fissures = new ArrayList<Fissure>();
		CloseableHttpResponse response = null;
		try {
			HttpUtils.openClient();
			response = HttpUtils.sendRequest(WorldstateUtils.FISSURESSURL);
			String json = HttpUtils.getContentFromResponse(response);

			Gson gson = new Gson();
			Type listType = new TypeToken<List<Fissure>>() {
			}.getType();
			fissures = gson.fromJson(json, listType);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
					HttpUtils.closeClient();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fissures;
	}
	
	public static List<Invasion> getInvasions() {
		List<Invasion> invasions = new ArrayList<Invasion>();
		CloseableHttpResponse response = null;
		try {
			HttpUtils.openClient();
			response = HttpUtils.sendRequest(WorldstateUtils.INVASIONSURL);
			String json = HttpUtils.getContentFromResponse(response);

			Gson gson = new Gson();
			Type listType = new TypeToken<List<Invasion>>() {
			}.getType();
			invasions = gson.fromJson(json, listType);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
					HttpUtils.closeClient();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return invasions;
	}
	
	public static List<Alert> getAlerts() {
		List<Alert> alerts = new ArrayList<Alert>();
		CloseableHttpResponse response = null;
		try {
			HttpUtils.openClient();
			response = HttpUtils.sendRequest(WorldstateUtils.ALERTSURL);
			String json = HttpUtils.getContentFromResponse(response);

			Gson gson = new Gson();
			Type listType = new TypeToken<List<Alert>>() {
			}.getType();
			alerts = gson.fromJson(json, listType);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
					HttpUtils.closeClient();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return alerts;
	}

}
