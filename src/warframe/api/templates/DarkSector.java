package warframe.api.templates;

import java.util.ArrayList;
import java.util.List;

public class DarkSector {
	private String id;
	private boolean isAlliance;
	private String defenderName;
	private String defenderDeployemntActivation;
	private String defenderMOTD;
	private String deployerName;
	private String deployerClan;
	private List<String> history = new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isAlliance() {
		return isAlliance;
	}

	public void setAlliance(boolean isAlliance) {
		this.isAlliance = isAlliance;
	}

	public String getDefenderName() {
		return defenderName;
	}

	public void setDefenderName(String defenderName) {
		this.defenderName = defenderName;
	}

	public String getDefenderDeployemntActivation() {
		return defenderDeployemntActivation;
	}

	public void setDefenderDeployemntActivation(String defenderDeployemntActivation) {
		this.defenderDeployemntActivation = defenderDeployemntActivation;
	}

	public String getDefenderMOTD() {
		return defenderMOTD;
	}

	public void setDefenderMOTD(String defenderMOTD) {
		this.defenderMOTD = defenderMOTD;
	}

	public String getDeployerName() {
		return deployerName;
	}

	public void setDeployerName(String deployerName) {
		this.deployerName = deployerName;
	}

	public String getDeployerClan() {
		return deployerClan;
	}

	public void setDeployerClan(String deployerClan) {
		this.deployerClan = deployerClan;
	}

	public List<String> getHistory() {
		return history;
	}

	public void setHistory(List<String> history) {
		this.history = history;
	}
}
