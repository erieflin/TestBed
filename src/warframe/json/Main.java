package warframe.json;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import warframe.json.templates.Alert;
import warframe.json.templates.Invasion;
import warframe.utils.WorldstateUtils;

public class Main {
	public static void main(String[] args) {
		NotificationEngine engine = new NotificationEngine();
		engine.checkUpdates();
	}
	
}
