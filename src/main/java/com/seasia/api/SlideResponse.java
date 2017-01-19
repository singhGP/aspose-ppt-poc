package com.seasia.api;

import java.util.Map;

public class SlideResponse {

	private Integer id;
	private Map<Integer,String> slideText;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Map<Integer, String> getSlideText() {
		return slideText;
	}
	public void setSlideText(Map<Integer, String> slideText) {
		this.slideText = slideText;
	}
	
}
