package com.slack.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Create_Channel {

	private boolean ok;
	private Create_Channel_values channel;
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
	public Create_Channel_values getChannel() {
		return channel;
	}
	public void setChannel(Create_Channel_values channel) {
		this.channel = channel;
	}
	
	
}