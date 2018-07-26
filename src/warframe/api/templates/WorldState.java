package warframe.api.templates;

import java.util.ArrayList;
import java.util.List;

public class WorldState {
	private String timestamp;
	private List<News> news = new ArrayList<News>();
	private List<String> events = new ArrayList<String>();
	private List<Alert> alerts = new ArrayList<Alert>();
	private Sortie sortie;
	private List<SyndicateMission> syndicateMissions = new ArrayList<SyndicateMission>();
	private List<Fissure> fissures = new ArrayList<Fissure>();
	private List<String> globalUpgrades = new ArrayList<String>();
	private List<FlashSale> flashsales = new ArrayList<FlashSale>();
	private List<Invasion> invasions = new ArrayList<Invasion>();
	private List<DarkSector> darkSectors = new ArrayList<DarkSector>();
	private VoidTrader voidTrader;
	private List<DailyDeal> dailyDeals = new ArrayList<DailyDeal>();
	private Simaris simaris;
	private List<ConclaveChallenge> conclaveChallenges = new ArrayList<ConclaveChallenge>();
	private List<String> persistantEnimies = new ArrayList<String>();
	private EarthCycle earthCycle;
	private CetusCycle cetusCycle;
	private ConstructionProcess constructionProgress;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Sortie getSortie() {
		return sortie;
	}

	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}

	public List<SyndicateMission> getSyndicateMissions() {
		return syndicateMissions;
	}

	public void setSyndicateMissions(List<SyndicateMission> syndicateMissions) {
		this.syndicateMissions = syndicateMissions;
	}

	public List<Fissure> getFissures() {
		return fissures;
	}

	public void setFissures(List<Fissure> fissures) {
		this.fissures = fissures;
	}

	public List<String> getGlobalUpgrades() {
		return globalUpgrades;
	}

	public void setGlobalUpgrades(List<String> globalUpgrades) {
		this.globalUpgrades = globalUpgrades;
	}

	public List<FlashSale> getFlashsales() {
		return flashsales;
	}

	public void setFlashsales(List<FlashSale> flashsales) {
		this.flashsales = flashsales;
	}

	public List<Invasion> getInvasions() {
		return invasions;
	}

	public void setInvasions(List<Invasion> invasions) {
		this.invasions = invasions;
	}

	public List<DarkSector> getDarkSectors() {
		return darkSectors;
	}

	public void setDarkSectors(List<DarkSector> darkSectors) {
		this.darkSectors = darkSectors;
	}

	public VoidTrader getVoidTrader() {
		return voidTrader;
	}

	public void setVoidTrader(VoidTrader voidTrader) {
		this.voidTrader = voidTrader;
	}

	public List<DailyDeal> getDailyDeals() {
		return dailyDeals;
	}

	public void setDailyDeals(List<DailyDeal> dailyDeals) {
		this.dailyDeals = dailyDeals;
	}

	public Simaris getSimaris() {
		return simaris;
	}

	public void setSimaris(Simaris simaris) {
		this.simaris = simaris;
	}

	public List<ConclaveChallenge> getConclaveChallenges() {
		return conclaveChallenges;
	}

	public void setConclaveChallenges(List<ConclaveChallenge> conclaveChallenges) {
		this.conclaveChallenges = conclaveChallenges;
	}

	public List<String> getPersistantEnimies() {
		return persistantEnimies;
	}

	public void setPersistantEnimies(List<String> persistantEnimies) {
		this.persistantEnimies = persistantEnimies;
	}

	public EarthCycle getEarthCycle() {
		return earthCycle;
	}

	public void setEarthCycle(EarthCycle earthCycle) {
		this.earthCycle = earthCycle;
	}

	public CetusCycle getCetusCycle() {
		return cetusCycle;
	}

	public void setCetusCycle(CetusCycle cetusCycle) {
		this.cetusCycle = cetusCycle;
	}

	public ConstructionProcess getConstructionProgress() {
		return constructionProgress;
	}

	public void setConstructionProgress(ConstructionProcess constructionProgress) {
		this.constructionProgress = constructionProgress;
	}
}
