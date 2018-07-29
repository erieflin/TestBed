package warframe.notifier;

import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.Arrays;

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
import warframe.api.templates.CetusCycle;
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


		for(Class<?> key: fe.getData().keySet()){
			for(Object o: fe.getData().get(key)){
				displayNotification(factory, plain, o);
			}
		}
		plain = null;
	}
	
	public void displayNotification(NotificationFactory factory, NotificationManager plain, Object o){
		if(o instanceof Alert){
			Alert alert = (Alert) o;
			WarframeNotification notification = buildNotification(factory, alert.getMission().getType(), alert.toString());

			ClickedListener listener = new ClickedListener(alert.getClass(),alert.getId());
			notification.addNotificationListener(listener);
			displayNotification(plain,notification);
		}
		
		if(o instanceof Invasion){
			Invasion i = (Invasion) o;
			WarframeNotification notification = buildNotification(factory, i.getDesc(), i.toString());
			ClickedListener listener = new ClickedListener(i.getClass(),i.getId());
			notification.addNotificationListener(listener);
			displayNotification(plain,notification);
		}
		
		if(o instanceof Event){
			Event e = (Event) o;
			WarframeNotification notification = buildNotification(factory, e.getDescription(), e.toString());
			ClickedListener listener = new ClickedListener(e.getClass(),e.getId());
			notification.addNotificationListener(listener);
			displayNotification(plain,notification);
		}
		
		if(o instanceof CetusCycle){
			CetusCycle c = (CetusCycle) o; 
			WarframeNotification notification = buildNotification(factory, "Cetus Status", c.toString());
			ClickedListener listener = new ClickedListener(c.getClass(),c.getId());
			notification.addNotificationListener(listener);
			displayNotification(plain,notification);
		}
			
	}
	public WarframeNotification buildNotification(NotificationFactory factory, String title,
			String message) {
		return buildNotification(factory, title, message, 2);
	}

	public void checkUpdates() {
		ws = WorldstateUtils.getWorldState();
		fe.applyFilters(ws);
		
		displayNotifications();
		
		
	}


	public WarframeNotification buildNotification(NotificationFactory factory,  String title,
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

		return notification;
	
	}

	public void displayNotification(NotificationManager manager, Notification notification){
		manager.addNotification(notification, Time.infinite());

		try {

			Thread.sleep(Time.seconds(2).getMilliseconds());
			manager.removeNotification(notification);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class ClickedListener implements NotificationListener {
		
		private Class<?> sourceClass;
		private String sourceId;
		public ClickedListener(Class<?> sourceClass, String sourceId) {
			this.sourceClass = sourceClass;
			this.sourceId = sourceId;
		}
		@Override
		public void actionCompleted(Notification notification, String action) {
			if (action.equals(WindowNotification.CLICKED )) {
				fe.ignoreId(sourceClass,sourceId);
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
