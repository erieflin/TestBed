package warframe.api.templates;

public class Fissure {
	private String id;
	private String node;
	private String missionType;
	private String enemy;
	private String tier;
	private String tierNum;
	private String activation;
	private String exiry;
	private boolean expired;
	private String eta;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getMissionType() {
		return missionType;
	}

	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}

	public String getEnemy() {
		return enemy;
	}

	public void setEnemy(String enemy) {
		this.enemy = enemy;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getTierNum() {
		return tierNum;
	}

	public void setTierNum(String tierNum) {
		this.tierNum = tierNum;
	}

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getExiry() {
		return exiry;
	}

	public void setExiry(String exiry) {
		this.exiry = exiry;
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
}
