package com.dd.templefinder.models;

import java.util.List;

/**
 * 
 * @author aditya
 *
 */
public class Temple implements Comparable<Temple>{

	private String templeName;
	private String templeTimings;
	private Address address;
	private Event event;
	private List<String> images;

	public String getTempleName() {
		return templeName;
	}
	/**
	 * @param templeName
	 */
	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}
	/**
	 * @return
	 */
	public String getTempleTimings() {
		return templeTimings;
	}
	/**
	 * @param templeTimings
	 */
	public void setTempleTimings(String templeTimings) {
		this.templeTimings = templeTimings;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	@Override
	public int compareTo(Temple temple) {
		return this.templeName.compareTo(temple.templeName);
	}
}
