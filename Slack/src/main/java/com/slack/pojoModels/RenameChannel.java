package com.slack.pojoModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RenameChannel {
	
	private boolean ok;
	private JoinOrRenameChannelValues channel;
	
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
	public JoinOrRenameChannelValues getChannel() {
		return channel;
	}
	public void setChannel(JoinOrRenameChannelValues channel) {
		this.channel = channel;
	}
	

}
