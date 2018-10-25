package com.dd.templefinder.models;

import java.util.List;

/**
 * 
 * @author aditya
 *
 */
public class TempleModel {

	private String templeName;
	private String templeTimings;
	private AddressModel addressModel;
	private EventModel eventModel;
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
	
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
	        sb.append("----------Temple Information-----------");
	        sb.append("Templename: " + getTempleName() + "\n");
	        sb.append("TempleTimings:  " + getTempleTimings() + "\n");
	        return sb.toString();
	}
	/**
	 * @return
	 */
	public AddressModel getAddressModel() {
		return addressModel;
	}
	/**
	 * @param addressModel
	 */
	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}
	/**
	 * @return
	 */
	public EventModel getEventModel() {
		return eventModel;
	}
	/**
	 * @param eventModel
	 */
	public void setEventModel(EventModel eventModel) {
		this.eventModel = eventModel;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	
}
