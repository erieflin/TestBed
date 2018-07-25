package json.templates;

public class FlashSale {
	private String item;
	private String expiry;
	private String discount;
	private String premiumOverride;
	private boolean isFeatured;
	private boolean isPopular;
	private String id;
	private boolean expired;
	private String eta;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getPremiumOverride() {
		return premiumOverride;
	}
	public void setPremiumOverride(String premiumOverride) {
		this.premiumOverride = premiumOverride;
	}
	public boolean isFeatured() {
		return isFeatured;
	}
	public void setFeatured(boolean isFeatured) {
		this.isFeatured = isFeatured;
	}
	public boolean isPopular() {
		return isPopular;
	}
	public void setPopular(boolean isPopular) {
		this.isPopular = isPopular;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
