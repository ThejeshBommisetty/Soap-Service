package com.soap.ws.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="RideResponse")
public class RideResponse {

	private boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
