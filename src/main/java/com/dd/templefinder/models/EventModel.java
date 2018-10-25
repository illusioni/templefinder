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
	
	/**
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return
	 */
	public String getEventPrice() {
		return eventPrice;
	}
	/**
	 * @param eventPrice
	 */
	public void setEventPrice(String eventPrice) {
		this.eventPrice = eventPrice;
	}
	/**
	 * @return
	 */
	public String getEventTimings() {
		return eventTimings;
	}
	/**
	 * @param eventTimings
	 */
	public void setEventTimings(String eventTimings) {
		this.eventTimings = eventTimings;
	}
	/**
	 * @return
	 */
	public String getOtherDetails() {
		return otherDetails;
	}
	/**
	 * @param otherDetails
	 */
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
}
