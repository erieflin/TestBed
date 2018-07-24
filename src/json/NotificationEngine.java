package json;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.notification.NotificationFactory;
import com.notification.NotificationFactory.Location;
import com.notification.NotificationManager;
import com.notification.manager.SimpleManager;
import com.notification.types.TextNotification;
import com.theme.ThemePackagePresets;
import com.utils.Time;

import json.templates.Alert;

public class NotificationEngine {
	private List<Alert> alerts = new ArrayList<Alert>();
	private Filters filters = new Filters();

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Filters getFilters() {
		return filters;
	}

	public void setFilters(Filters filters) {
		this.filters = filters;
	}

	public void displayNotifications() {
		// makes a factory with the built-in clean theme
		// themes are customizeable
		NotificationFactory factory = new NotificationFactory(ThemePackagePresets.cleanLight());
		// factories build notifications using a theme, while managers handle
		// how
		// how they appear on the screen
		// this manager just simple pops up the notification in the specified
		// location
		// other managers do sliding, queues, etc.
		NotificationManager plain = new SimpleManager(Location.SOUTHEAST);
		
		// creates a text notification; you can also have progress bar
		// Notifications,
		// icon Notifications, Notifications that ask for user feedback, etc.
		for (Alert alert : alerts) {
		//for(int i =0; i < 20; ++i){
			TextNotification notification = factory.buildTextNotification(alert.getMission().getType(), alert.toString());
			notification.setCloseOnClick(true);
			// the notification will disappear after 2 seconds, or after you
			// click it
			plain.addNotification(notification, Time.infinite());
			
			try {
				Thread.sleep(2000);
				plain.removeNotification(notification);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		plain = null;
	}
}
