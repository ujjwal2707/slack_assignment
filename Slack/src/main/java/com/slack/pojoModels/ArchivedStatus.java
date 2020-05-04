package com.slack.pojoModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchivedStatus {

	private boolean ok;
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

}
