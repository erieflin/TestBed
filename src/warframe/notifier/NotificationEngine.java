package warframe.notifier;

import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.notification.Notification;
import com.notification.NotificationFactory;
import com.notification.NotificationFactory.Location;
import com.notification.NotificationListener;
import com.notification.NotificationManager;
import com.notification.manager.SimpleManager;
import com.notification.types.WindowNotification;
import com.theme.ThemePackagePresets;
import com.utils.Time;

import warframe.api.WorldstateUtils;
import warframe.api.templates.Alert;
import warframe.api.templates.Event;
import warframe.api.templates.Invasion;
import warframe.api.templates.WorldState;
import warframe.notifier.notification.FilteringEngine;
import warframe.notifier.notification.WarframeNotification;

public class NotificationEngine {
	private FilteringEngine fe = new FilteringEngine();
	


	WorldState ws;
	

	public void displayNotifications() {
		
		NotificationFactory factory = new NotificationFactory(ThemePackagePresets.cleanLight());
		factory.addBuilder(WarframeNotification.class, new WarframeNotification.CustomBuilder());

		NotificationManager plain = new SimpleManager(Location.SOUTHEAST);


		for (Alert alert : ws.getAlerts()) {
			displayNotification(factory, plain, alert.getMission().getType(), alert.toString());
		}
		for (Invasion invasion : ws.getInvasions()) {
			displayNotification(factory, plain, invasion.getDesc(), invasion.toString());
		}
		for(Event event: ws.getEvents()){
			displayNotification(factory, plain, event.getDescription(), event.getAsString());
		}
		HashMap<String,String> miscToNotify = fe.getMiscToNotify();
		for(String key: miscToNotify.keySet()){
			displayNotification(factory, plain, key, miscToNotify.get(key));
		}
		plain = null;
	}

	public void displayNotification(NotificationFactory factory, NotificationManager plain, String title,
			String message) {
		displayNotification(factory, plain, title, message, 2);
	}

	public void checkUpdates() {
		ws = WorldstateUtils.getWorldState();
		fe.applyFilters(ws);
		
		displayNotifications();
		
		
	}


	public void displayNotification(NotificationFactory factory, NotificationManager plain, String title,
			String message, double seconds) {
		WarframeNotification notification = factory.build(WarframeNotification.class, title, message);
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(message.split("\n")));
		String longestLine = lines.get(0);
		for(String line: lines){
			if(line.length()>longestLine.length()){
				longestLine = line;
			}
		}
		FontMetrics messageMetrics = notification.getMessageMetrics();
		FontMetrics titleMetrics = notification.getTitleMetrics();
		int longestWidth = messageMetrics.stringWidth(longestLine);
		int titleWidth = titleMetrics.stringWidth(title);
		if(titleWidth> longestWidth){
			longestWidth = titleWidth;
		}
		int lineHeight = lines.size() * messageMetrics.getHeight();
		int width =  20 + longestWidth;
		int height = 40 + titleMetrics.getHeight() + lineHeight;
		
		notification.setCloseOnClick(true);
		notification.setSize(width, height);
		// the notification will disappear after 2 seconds, or after you
		// click it
		plain.addNotification(notification, Time.infinite());

		try {

			Thread.sleep(Time.seconds(2).getMilliseconds());
			plain.removeNotification(notification);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private class ClickedListener implements NotificationListener {
		@Override
		public void actionCompleted(Notification notification, String action) {
			if (action.equals(WindowNotification.CLICKED )) {
				//
				
				
			}
		}
	}
	
	public FilteringEngine getFe() {
		return fe;
	}

	public void setFe(FilteringEngine fe) {
		this.fe = fe;
	}

	

}
