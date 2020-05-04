package com.slack.pojoModels;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChannels {
	
	private boolean ok;
	private List<Channels> channels;
	private String error;
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean getOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public List<Channels> getChannels() {
		return channels;
	}
	public void setChannels(List<Channels> channels) {
		this.channels = channels;
	}
	
	

}
