package com.soap.ws.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="RideRequest")
public class RideRequest {
	
	private String id;
	private String from;
	private String to;
	private Double cost;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}

}
