package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlacesAddModal {
/*
	{
		  "location": {
		    "lat": -33.8669710,
		    "lng": 151.1958750
		  },
		  "accuracy": 50,
		  "name": "Google Shoes!",
		  "phone_number": "(02) 9374 4000",
		  "address": "48 Pirrama Road, Pyrmont, NSW 2009, Australia",
		  "types": ["shoe_store"],
		  "website": "http://www.google.com.au/",
		  "language": "en-AU"
		}*/
	
	Map<String, Double> location=new HashMap<>();
   
	List<String> types=new ArrayList<>();
    
	private String name;
    private int accuray;
    private String phone_number;
    private String address;
    private String website;
    private String language;
	
    public Map<String, Double> getLocation() {
		return location;
	}
	public void setLocation(Map<String, Double> location) {
		this.location = location;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccuray() {
		return accuray;
	}
	public void setAccuray(int accuray) {
		this.accuray = accuray;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
