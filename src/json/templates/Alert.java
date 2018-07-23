package json.templates;

import java.util.ArrayList;
import java.util.List;

public class Alert {
	private String id;
	private String activation;
	private String expiry;
	private Mission mission;
	private boolean expired;
	private String eta;
	private List<String> rewardTypes = new ArrayList<String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public List<String> getRewardTypes() {
		return rewardTypes;
	}
	public void setRewardTypes(List<String> rewardTypes) {
		this.rewardTypes = rewardTypes;
	}
}
