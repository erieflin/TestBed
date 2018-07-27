package warframe.notifier;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.notification.NotificationFactory;
import com.notification.NotificationFactory.Location;
import com.notification.NotificationManager;
import com.notification.manager.SimpleManager;
import com.notification.types.TextNotification;
import com.theme.ThemePackagePresets;
import com.utils.Time;

import warframe.api.WorldstateUtils;
import warframe.api.filters.Filter;
import warframe.api.templates.Alert;
import warframe.api.templates.CetusCycle;
import warframe.api.templates.Invasion;
import warframe.api.templates.WorldState;

public class NotificationEngine {
	// private List<Alert> alerts = new ArrayList<Alert>();
	// private List<Invasion> invasions = new ArrayList<Invasion>();
	private HashMap<String,String> miscToNotify = new HashMap<String,String>();
	WorldState ws;
	private List<Filter> alertFilters = new ArrayList<Filter>();
	private List<Filter> invasionFilters = new ArrayList<Filter>();
	private List<Filter> cetusFilters = new ArrayList<Filter>();
	public List<Filter> getCetusFilters() {
		return cetusFilters;
	}

	public void setCetusFilters(List<Filter> cetusFilters) {
		this.cetusFilters = cetusFilters;
	}

//	public List<Alert> getAlerts() {
//		return alerts;
//	}
//
//	public void setAlerts(List<Alert> alerts) {
//		this.alerts = alerts;
//	}
//
//	public List<Invasion> getInvasions() {
//		return invasions;
//	}
//
//	public void setInvasions(List<Invasion> invasions) {
//		this.invasions = invasions;
//	}

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
		for (Alert alert : ws.getAlerts()) {
			displayNotification(factory, plain, alert.getMission().getType(), alert.toString());
		}
		for (Invasion invasion : ws.getInvasions()) {
			displayNotification(factory, plain, invasion.getDesc(), invasion.toString());
		}
		
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
		miscToNotify.clear();
//		addNewAlerts(ws.getAlerts());
//		addNewInvasions(ws.getInvasions());
		
		applyFilters(ws.getAlerts(), this.alertFilters);
		applyFilters(ws.getInvasions(), this.invasionFilters);
		CetusCycle cetus = ws.getCetusCycle();
		if(fufillsFilters(cetus, cetusFilters)){
			miscToNotify.put("Cetus Status", cetus.toString());
		}
		displayNotifications();
		
		
	}

	public boolean fufillsFilters(Object o, List<Filter> filters) {
		boolean matches = false;
		for (Filter filter : filters) {
			if (filter.doesPass(o)) {
				matches = true;
			}
		}
		return matches;

	}

	public void applyFilters(List<?> list, List<Filter> filters) {
		Iterator<?> i = list.iterator();
		while (i.hasNext()) {
			Object o = i.next();

			if (!fufillsFilters(o, filters)) {
				i.remove();
			}
		}
	}

//	public void addNewInvasions(List<Invasion> newInvasions) {
//		Iterator<Invasion> i = invasions.iterator();
//		while (i.hasNext()) {
//			Invasion inv = i.next();
//			if (inv.isCompleted()) {
//				i.remove();
//				continue;
//			}
//			if (!newInvasions.contains(inv)) {
//				i.remove();
//			}
//		}
//		for (Invasion newInvasion : newInvasions) {
//			boolean found = false;
//			for (Invasion currentInvasion : invasions) {
//				if (currentInvasion.equals(newInvasion)) {
//					found = true;
//					break;
//				}
//			}
//			if (!found) {
//				invasions.add(newInvasion);
//			}
//		}
//	}
//
//	public void addNewAlerts(List<Alert> newAlerts) {
//		Iterator<Alert> i = alerts.iterator();
//		while (i.hasNext()) {
//			Alert a = i.next();
//			Instant instant = Instant.parse(a.getExpiry());
//			if (instant.compareTo(Instant.now()) < 0) {
//				i.remove();
//				continue;
//			}
//			if (!newAlerts.contains(a)) {
//				i.remove();
//			}
//		}
//
//		for (Alert newAlert : newAlerts) {
//			boolean found = false;
//			for (Alert currentAlert : alerts) {
//				if (currentAlert.equals(newAlert)) {
//					found = true;
//					break;
//				}
//			}
//			if (!found) {
//				alerts.add(newAlert);
//			}
//		}
//	}

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

	public List<Filter> getAlertFilters() {
		return alertFilters;
	}

	public void setAlertFilters(List<Filter> alertFilters) {
		this.alertFilters = alertFilters;
	}

	public List<Filter> getInvasionFilters() {
		return invasionFilters;
	}

	public void setInvasionFilters(List<Filter> invasionFilters) {
		this.invasionFilters = invasionFilters;
	}

}
