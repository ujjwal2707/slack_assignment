package com.slack.pojoModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateChannel {

	private boolean ok;
	private CreateChannelValues channel;
	private String error;
	private String detail;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	public boolean getOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public CreateChannelValues getChannel() {
		return channel;
	}
	public void setChannel(CreateChannelValues channel) {
		this.channel = channel;
	}
	
	
}