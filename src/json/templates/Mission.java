package json.templates;

public class Mission {
	private String node;
	private String type;
	private String faction;
	private Reward reward;
	private String minEnemyLevel;
	private String maxEnemyLevel;
	private boolean nightmare;
	private boolean archwingRequired;
	
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFaction() {
		return faction;
	}
	public void setFaction(String faction) {
		this.faction = faction;
	}
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
	public String getMinEnemyLevel() {
		return minEnemyLevel;
	}
	public void setMinEnemyLevel(String minEnemyLevel) {
		this.minEnemyLevel = minEnemyLevel;
	}
	public String getMaxEnemyLevel() {
		return maxEnemyLevel;
	}
	public void setMaxEnemyLevel(String maxEnemyLevel) {
		this.maxEnemyLevel = maxEnemyLevel;
	}
	public boolean isNightmare() {
		return nightmare;
	}
	public void setNightmare(boolean nightmare) {
		this.nightmare = nightmare;
	}
	public boolean isArchwingRequired() {
		return archwingRequired;
	}
	public void setArchwingRequired(boolean archwingRequired) {
		this.archwingRequired = archwingRequired;
	}
}
