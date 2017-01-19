package com.seasia.api;

public class SlideRequest {

	private Integer id;
	private String location;
	private String token;
	private String extractText;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getExtractText() {
		return extractText;
	}
	public void setExtractText(String extractText) {
		this.extractText = extractText;
	}
	
	
}
