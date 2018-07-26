package warframe.json.templates;

import java.util.ArrayList;
import java.util.List;

public class SyndicateMission {
	private String id;
	private String activation;
	private String expiry;
	private String syndicate;
	private List<String> nodes = new ArrayList<String>();  
	private List<Job> jobs = new ArrayList<Job>(); 
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
	public String getSyndicate() {
		return syndicate;
	}
	public void setSyndicate(String syndicate) {
		this.syndicate = syndicate;
	}
	public List<String> getNodes() {
		return nodes;
	}
	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
}
