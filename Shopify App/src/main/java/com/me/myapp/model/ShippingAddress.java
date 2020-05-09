package com.me.myapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ShippingAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5335279804494899936L;

	@Id
	@GeneratedValue
	private int shippingAddressId;
	
	@NotEmpty(message="Street name name cannot be empty.")
	private String streetName;
	
	@NotEmpty(message="Apartment number cannot be empty.")
	private String apartmentNumber;
	
	@NotEmpty(message="City cannot be empty.")
	private String city;
	
	@NotEmpty(message="State cannot be empty.")
	private String state;
	
	@NotEmpty(message="Country cannot be empty.")
	private String country;
	
	@NotEmpty(message="Zipcode cannot be empty.")
	private String zipcode;
	
	@OneToOne
	private Customer customer;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShippingAddress [streetName=" + streetName + ", apartmentNumber=" + apartmentNumber + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}
	
	
}
