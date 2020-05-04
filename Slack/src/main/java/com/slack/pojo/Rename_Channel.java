package com.slack.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rename_Channel {
	
	private boolean ok;
	private Join_Rename_Channel_Values channel;
	
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
	public Join_Rename_Channel_Values getChannel() {
		return channel;
	}
	public void setChannel(Join_Rename_Channel_Values channel) {
		this.channel = channel;
	}
	

}
