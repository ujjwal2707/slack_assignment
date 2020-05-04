package com.slack.pojoModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Purpose {
	private String value;
	private String creator;
	private int  last_set;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getLast_set() {
		return last_set;
	}
	public void setLast_set(int last_set) {
		this.last_set = last_set;
	}

}
