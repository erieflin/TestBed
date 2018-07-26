package warframe.json.templates;

import java.util.HashMap;

public class News {
	private String id;
	private String message;
	private String link;
	private String imageLink;
	private boolean priority;
	private String date;
	private String eta;
	private boolean update;
	private boolean primeAccess;
	private boolean stream;
	private HashMap<String,String> translations = new HashMap<String,String>();
	private String asString;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isPrimeAccess() {
		return primeAccess;
	}
	public void setPrimeAccess(boolean primeAccess) {
		this.primeAccess = primeAccess;
	}
	public boolean isStream() {
		return stream;
	}
	public void setStream(boolean stream) {
		this.stream = stream;
	}
	public HashMap<String, String> getTranslations() {
		return translations;
	}
	public void setTranslations(HashMap<String, String> translations) {
		this.translations = translations;
	}
	public String getAsString() {
		return asString;
	}
	public void setAsString(String asString) {
		this.asString = asString;
	}
}
