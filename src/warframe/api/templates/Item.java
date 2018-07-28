package warframe.api.templates;

public class Item {
	private String item;
	private String ducats;
	private String credits;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDucats() {
		return ducats;
	}
	public void setDucats(String ducats) {
		this.ducats = ducats;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String toString(){
		return item + ": " + ducats + " ducats, " + credits + " credits"; 
	}
}
