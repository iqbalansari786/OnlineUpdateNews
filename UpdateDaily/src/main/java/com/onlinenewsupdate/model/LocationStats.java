package com.onlinenewsupdate.model;


public class LocationStats {

    private String state;
    private String country;
    private String lastUpdate;
    private String confirmed;
    private String recovered;
    private String death;
    
	public String getDeath() {
		return death;
	}
	public void setDeath(String death) {
		this.death = death;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", lastUpdate=" + lastUpdate + ", confirmed="
				+ confirmed + ", recovered=" + recovered + "]";
	}

 
}