package com.seasia.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.aspose.slides.IParagraph;
import com.aspose.slides.IPortion;
import com.aspose.slides.ISlideCollection;
import com.aspose.slides.ITextFrame;
import com.aspose.slides.Presentation;
import com.aspose.slides.SlideUtil;
import com.seasia.controller.SlidesController;

@Service("textService")
public class TextService {
	private Logger logger = LoggerFactory.getLogger(SlidesController.class);

	/**
	 * method to process the text using aspose lib
	 * @param filePath of the pptx file
	 * @return
	 */
	public Map<Integer,String> readText(String filePath) {
		logger.info("In readText");
		long startTimeStamp = System.currentTimeMillis();
		Map<Integer,String> resultMap = new LinkedHashMap<Integer,String>();
		//Instatiate Presentation class that represents a PPTX file
		Presentation pptxPresentation = new Presentation(filePath);

		ISlideCollection presentaionSlides = pptxPresentation.getSlides();

		presentaionSlides.forEach(iSlide ->{
			long startTimeStamp_slide = System.currentTimeMillis();
			int slideIndex = presentaionSlides.indexOf(iSlide);
			ITextFrame[] textFrames =SlideUtil.getAllTextBoxes(iSlide);
			String slideText = null;

			for (ITextFrame textFrame : textFrames) 

				//Loop through paragraphs in current ITextFrame
				for(IParagraph para : textFrame.getParagraphs()) 

					//Loop through portions in the current IParagraph
					for(IPortion port : para.getPortions())
					{
						slideText += "\n "+port.getText();

					}
			logger.info("slide text fetched ,T :"+ (System.currentTimeMillis() - startTimeStamp_slide));
			logger.info("slide text fetched ,TT :"+ (System.currentTimeMillis() - startTimeStamp));
			resultMap.put(slideIndex, slideText);
		});
		logger.info("OUT readText , TT :"+ (System.currentTimeMillis() - startTimeStamp));

		return resultMap;
	}

}
