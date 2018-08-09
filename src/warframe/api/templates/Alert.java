package warframe.api.templates;

import java.util.ArrayList;
import java.util.List;

import warframe.api.filters.Filter;
import warframe.api.utils.TimeUtils;

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

	@Override
	public String toString() {
		String notificationString = TimeUtils.timeRemaining(this.getExpiry()) + "\nreward string\n" + this.getMission().getReward();
		return notificationString;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}if(obj == this){
			return true;
		}
		if(!(obj instanceof Alert)){
			return false;
		}
		Alert alertObj = (Alert) obj;
		return alertObj.getId().equalsIgnoreCase(this.getId());
	}
}
