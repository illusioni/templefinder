package com.dd.templefinder.models;

/**
 * 
 * @author aditya
 *
 */
public class AddressModel {

	private String streetName;
	private String houseNo;
	private String postalCode;
	private String cityName;
	private String[] imageNames;
	
	/**
	 * @return
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	/**
	 * @return
	 */
	public String getHouseNo() {
		return houseNo;
	}
	/**
	 * @param houseNo
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	/**
	 * @return
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return
	 */
	public String[] getImageNames() {
		return imageNames;
	}
	/**
	 * @param imageNames
	 */
	public void setImageNames(String[] imageNames) {
		this.imageNames = imageNames;
	}
	
	
	
}
