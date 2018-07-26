package warframe.json;

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

import warframe.json.templates.Alert;
import warframe.json.templates.Invasion;
import warframe.json.templates.WorldState;
import warframe.utils.WorldstateUtils;

public class NotificationEngine {
	private List<Alert> alerts = new ArrayList<Alert>();
	private List<Invasion> invasions = new ArrayList<Invasion>();
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

	public List<Invasion> getInvasions() {
		return invasions;
	}

	public void setInvasions(List<Invasion> invasions) {
		this.invasions = invasions;
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
			displayNotification(factory, plain, alert.getMission().getType(), alert.toString());
		}
		for (Invasion invasion : invasions) {
			displayNotification(factory, plain, invasion.getDesc(), invasion.toString());
		}
		plain = null;
	}

	public void displayNotification(NotificationFactory factory, NotificationManager plain, String title,
			String message) {
		displayNotification(factory, plain, title, message, 2);
	}
	public void checkUpdates(){
		WorldState ws = WorldstateUtils.getWorldState();
		setAlerts(WorldstateUtils.getAlerts());
		setInvasions(WorldstateUtils.getInvasions());
		displayNotifications();
	}
	public void displayNotification(NotificationFactory factory, NotificationManager plain, String title,
			String message, double seconds) {
		TextNotification notification = factory.buildTextNotification(title, message);
		notification.setCloseOnClick(true);
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

}
