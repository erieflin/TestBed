package json.templates;

import java.util.ArrayList;
import java.util.List;

public class Reward {
	private List<String> items = new ArrayList<String>();
	private  List<CountedItem> countedItems = new ArrayList<CountedItem>();
	private String credits;
	private String asString;
	private String itemString;
	private String thumbnail;
	private String color;
	
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public List<CountedItem> getCountedItems() {
		return countedItems;
	}
	public void setCountedItems(List<CountedItem> countedItems) {
		this.countedItems = countedItems;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getAsString() {
		return asString;
	}
	public void setAsString(String asString) {
		this.asString = asString;
	}
	public String getItemString() {
		return itemString;
	}
	public void setItemString(String itemString) {
		this.itemString = itemString;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString(){
		return this.asString;
	}
}
