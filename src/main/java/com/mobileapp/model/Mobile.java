package com.mobileapp.model;

public class Mobile {
	private Integer mobileId;
    private String model;
    private String brand;
    private double price;
    
   
	/**
	 * 
	 */
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param mobileId
	 * @param model
	 * @param brand
	 * @param price
	 */
	public Mobile(Integer mobileId, String model, String brand, double price) {
		super();
		this.mobileId = mobileId;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	/**
	 * @return the mobileId
	 */
	public Integer getMobileId() {
		return mobileId;
	}
	/**
	 * @param mobileId the mobileId to set
	 */
	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
}
