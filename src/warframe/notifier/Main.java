package warframe.notifier;

public class Main {
	public static void main(String[] args) {
		NotificationEngine engine = new NotificationEngine();
		engine.checkUpdates();
	}

}
