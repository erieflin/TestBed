package warframe.api.templates;

import java.util.List;
import java.util.ArrayList;

public class Job {
	private String id;
	private String type;
	private List<String> enemyLevels = new ArrayList<String>();

	private List<String> standingStages = new ArrayList<String>();

	private List<String> rewardPool = new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getEnemyLevels() {
		return enemyLevels;
	}

	public void setEnemyLevels(List<String> enemyLevels) {
		this.enemyLevels = enemyLevels;
	}

	public List<String> getStandingStages() {
		return standingStages;
	}

	public void setStandingStages(List<String> standingStages) {
		this.standingStages = standingStages;
	}

	public List<String> getRewardPool() {
		return rewardPool;
	}

	public void setRewardPool(List<String> rewardPool) {
		this.rewardPool = rewardPool;
	}
}
