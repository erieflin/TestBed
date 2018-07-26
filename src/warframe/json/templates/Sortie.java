package warframe.json.templates;

import java.util.ArrayList;
import java.util.List;

public class Sortie {
	private String id;
	private String activation;
	private String expiry;
	private String rewardPool;
	private List<Variant> variants = new ArrayList<Variant>();
	private String boss;
	private String faction;
	private boolean expired;
	private String eta;
	
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
	public String getRewardPool() {
		return rewardPool;
	}
	public void setRewardPool(String rewardPool) {
		this.rewardPool = rewardPool;
	}
	public List<Variant> getVariants() {
		return variants;
	}
	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getFaction() {
		return faction;
	}
	public void setFaction(String faction) {
		this.faction = faction;
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
