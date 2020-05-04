package com.slack.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Join_Channel {
	
	private Boolean ok;
	private String already_in_channel;
	
	private Join_Rename_Channel_Values channel;
	
	private String error;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	public String getAlready_in_channel() {
		return already_in_channel;
	}
	public void setAlready_in_channel(String already_in_channel) {
		this.already_in_channel = already_in_channel;
	}
	public Join_Rename_Channel_Values getChannel() {
		return channel;
	}
	public void setChannel(Join_Rename_Channel_Values channel) {
		this.channel = channel;
	}
	

}
