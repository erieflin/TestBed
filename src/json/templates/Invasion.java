package json.templates;

import java.util.List;

public class Invasion {
	private String id;
	private String desc;
	private Reward attackerReward;
	private String attackingFaction;
	private Reward defenderReward;
	private String defendingFaction;
	private String vsInfestation;
	private String activation;
	private String count;
	private String requiredRuns;
	private String completion;
	private boolean completed;
	private String eta;
	private List<String> rewardTypes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Reward getAttackerReward() {
		return attackerReward;
	}
	public void setAttackerReward(Reward attackerReward) {
		this.attackerReward = attackerReward;
	}
	public String getAttackingFaction() {
		return attackingFaction;
	}
	public void setAttackingFaction(String attackingFaction) {
		this.attackingFaction = attackingFaction;
	}
	public Reward getDefenderReward() {
		return defenderReward;
	}
	public void setDefenderReward(Reward defenderReward) {
		this.defenderReward = defenderReward;
	}
	public String getDefendingFaction() {
		return defendingFaction;
	}
	public void setDefendingFaction(String defendingFaction) {
		this.defendingFaction = defendingFaction;
	}
	public String getVsInfestation() {
		return vsInfestation;
	}
	public void setVsInfestation(String vsInfestation) {
		this.vsInfestation = vsInfestation;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getRequiredRuns() {
		return requiredRuns;
	}
	public void setRequiredRuns(String requiredRuns) {
		this.requiredRuns = requiredRuns;
	}
	public String getCompletion() {
		return completion;
	}
	public void setCompletion(String completion) {
		this.completion = completion;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
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
	public String toString(){
		String notificationString = this.getEta() + "\nreward strings\nAttacker: " +  this.attackerReward + "\nDefender: " + this.defenderReward;
		return notificationString;
	}
}
