package com.seasia.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.seasia.api.SlideRequest;
import com.seasia.api.SlideResponse;
import com.seasia.service.TextService;

@Controller
public class SlidesController {
	
	private Logger LOG = LoggerFactory.getLogger(SlidesController.class);
	
	@Autowired
	TextService asposeTextService;
	
	/**
	 * method to get the text from the pptx slide
	 * @param slideRequest
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.POST}, value="/extract-text")
	@ResponseBody
	public ResponseEntity<SlideResponse> processSlides(
			@RequestBody SlideRequest slideRequest) {
		LOG.info("In extractText");
		long startTimeStamp = System.currentTimeMillis();
		SlideResponse response = new SlideResponse();
		response.setId(slideRequest.getId());
		Map<Integer,String> slideContent =  asposeTextService.readText(slideRequest.getLocation());
		response.setSlideText(slideContent);
		LOG.info("OUT extractText, TT :"+(System.currentTimeMillis() - startTimeStamp));
		
		return new ResponseEntity<SlideResponse>(response, HttpStatus.OK);
	}
	
}
