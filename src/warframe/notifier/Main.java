package warframe.notifier;

import java.util.Timer;
import java.util.TimerTask;

import com.utils.Time;

public class Main {
	private static final int interval = 2;

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				NotificationEngine engine = new NotificationEngine();
				engine.checkUpdates();
			}
		}, 0, Time.seconds(60 * interval).getMilliseconds());
	}

}
