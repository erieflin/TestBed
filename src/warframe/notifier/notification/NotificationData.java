package warframe.notifier.notification;

public class NotificationData {
	private String title;
	private String message;
	private Class<?> source;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Class<?> getSource() {
		return source;
	}
	public void setSource(Class<?> source) {
		this.source = source;
	}
}
