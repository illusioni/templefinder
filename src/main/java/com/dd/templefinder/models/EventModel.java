package com.dd.templefinder.models;

/**
 * 
 * @author aditya
 *
 */
public class EventModel {

	private String eventName;
	private String eventPrice;
	private String eventTimings;
	private String otherDetails;
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(String eventPrice) {
		this.eventPrice = eventPrice;
	}
	public String getEventTimings() {
		return eventTimings;
	}
	public void setEventTimings(String eventTimings) {
		this.eventTimings = eventTimings;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
}
