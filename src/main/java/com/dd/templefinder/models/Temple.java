package com.dd.templefinder.models;

import java.util.List;

import com.dd.templefinder.commons.AppUtils;

/**
 *
 * @author aditya
 *
 */
public class Temple implements Comparable<Temple>{

	private String templeName;
	private String templeTimings;
	private String simpleAddress;
	private Address address;
	private Event event;
	private List<String> images;
	private String normalizedString; 

	public Temple() {}
	public Temple(String name) { setTempleName(name); }
	public Temple(String name, String timings, String address) {
		this.templeName = name;
		this.templeTimings = timings;
		this.simpleAddress = address;
	}
	public Temple(String name, String address, String timings, String normalizedString) {
		this.templeName = name;
		this.templeTimings = timings;
		this.simpleAddress = address;
		this.normalizedString = normalizedString;
	}

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
	public String getSimpleAddress() {
		return simpleAddress;
	}
	public void setSimpleAddress(String simpleAddress) {
		this.simpleAddress = simpleAddress;
	}
	public String getNormalizedString() {
		return normalizedString;
	}
	public void setNormalizedString(String normalizedString) {
		this.normalizedString = normalizedString;
	}
	@Override
	public int compareTo(Temple temple) {
		return this.templeName.compareTo(temple.templeName);
	}
	//Added for debugging purpose
	@Override 
	public String toString() {
		return "TempleName::" + getTempleName();
	}

	public void normalize() {
		this.normalizedString = new StringBuilder()
				.append(AppUtils.normalizeString(this.getTempleName()))
				.append(AppUtils.normalizeString(this.getSimpleAddress()))
				.append(AppUtils.normalizeString(this.getTempleTimings()))
				.toString();
	}

}
