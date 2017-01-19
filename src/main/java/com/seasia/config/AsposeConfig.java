package com.seasia.config;

import java.io.InputStream;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.annotation.Configuration;

import com.aspose.slides.License;

@Configuration
public class AsposeConfig implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
				
				InputStream inputStream = AsposeConfig.class.getClassLoader().getResourceAsStream("Aspose.Slides.lic");

				License license = new License();
				Locale.setDefault(new Locale("en-US"));
					
				license.setLicense(inputStream);
				System.out.println(license.isLicensed());
				ServletContext application  = context.getServletContext();
				
				//Fetch configs from context Initialization
				String directoryPath = application.getInitParameter("dataDirectory");
				String verificationURL = application.getInitParameter("verificationURL");
				String notifyTaskCompletionURL = application.getInitParameter("notifyTaskCompleteURL");
				String notifySlidesCreationTaskCompleteURL = application.getInitParameter("notifySlidesCreationTaskCompleteURL");
				String notifyAdminSlidesCreationTaskCompleteURL = application.getInitParameter("notifyAdminSlidesCreationTaskCompleteURL");
				
				//Set config in application scope for access in various servlets
				application.setAttribute("dataDirectory", directoryPath);
				application.setAttribute("verificationURL", verificationURL);
				application.setAttribute("notifyTaskCompletionURL", notifyTaskCompletionURL);
				application.setAttribute("notifySlidesCreationTaskCompleteURL", notifySlidesCreationTaskCompleteURL);
				application.setAttribute("notifyAdminSlidesCreationTaskCompleteURL", notifyAdminSlidesCreationTaskCompleteURL);
	}

}
