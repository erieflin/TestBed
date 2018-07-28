package warframe.api.templates;

import java.util.ArrayList;
import java.util.List;

public class Event {
	private String id;
	private String expiry;
	private String maximumScore;
	private String smallInterval;
	private String largeInterval;
	private String faction;
	private String description;
	private String node;
	private List<String> concurrentNodes = new ArrayList<String>();
	private List<Reward> rewards = new ArrayList<Reward>();
	private boolean expired;
	private String asString;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getMaximumScore() {
		return maximumScore;
	}
	public void setMaximumScore(String maximumScore) {
		this.maximumScore = maximumScore;
	}
	public String getSmallInterval() {
		return smallInterval;
	}
	public void setSmallInterval(String smallInterval) {
		this.smallInterval = smallInterval;
	}
	public String getLargeInterval() {
		return largeInterval;
	}
	public void setLargeInterval(String largeInterval) {
		this.largeInterval = largeInterval;
	}
	public String getFaction() {
		return faction;
	}
	public void setFaction(String faction) {
		this.faction = faction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public List<String> getConcurrentNodes() {
		return concurrentNodes;
	}
	public void setConcurrentNodes(List<String> concurrentNodes) {
		this.concurrentNodes = concurrentNodes;
	}
	public List<Reward> getRewards() {
		return rewards;
	}
	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public String getAsString() {
		return asString;
	}
	public void setAsString(String asString) {
		this.asString = asString;
	}
	public String toString(){
		return this.asString;
	}
}
